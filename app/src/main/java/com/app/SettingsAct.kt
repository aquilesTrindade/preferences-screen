package com.app

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

import com.app.R
import com.app.Prefs

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