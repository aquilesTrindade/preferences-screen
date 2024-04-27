package com.trindade.preferences.screen

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class Prefs : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.app_preferences, rootKey) // Correção do nome do arquivo XML
        val darkThemeSwitch: Preference? = findPreference("dark_theme")
        darkThemeSwitch?.setOnPreferenceChangeListener { _, newValue ->
            val isChecked = newValue as Boolean
            //setThemePreference(isChecked)
            true
        }
    }

    private fun setThemePreference(isDarkMode: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("dark_mode", isDarkMode)
        editor.apply()
    }

    private fun getThemePreference(): Boolean {
        return sharedPreferences.getBoolean("dark_mode", false)
    } 

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == "dark_mode") {
            val isDarkMode = sharedPreferences?.getBoolean("dark_mode", false) ?: false
           /* if (isDarkMode) {
                requireActivity().setThemye(R.style.)
            } else {
                requireActivity().setTheme(R.style.)
            }*/
            requireActivity().recreate()
        }
    } 
}