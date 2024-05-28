package com.trindade.preferences.screen

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

import com.trindade.preferences.screen.R
import com.trindade.preferences.screen.Prefs

public class SettingsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_preference, Prefs())
            .commit()
    }
}