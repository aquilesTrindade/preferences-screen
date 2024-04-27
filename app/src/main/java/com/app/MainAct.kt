package com.app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.appbar.MaterialToolbar

import com.app.R
import com.app.SettingsAct

public class MainAct : AppCompatActivity() {
	
  private lateinit var mToolbar: MaterialToolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
	mToolbar = findViewById(R.id.mToolbar)
	setSupportActionBar(mToolbar)	
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId
    if (id == R.id.settings) {
      goToPreferences()
    }
    return super.onOptionsItemSelected(item)
  }

  private fun goToPreferences() {
    startActivity(Intent(this, SettingsAct::class.java))
  }

  private fun toolbar() {
    mToolbar.setOnMenuItemClickListener { item ->
      when (item.itemId) {
        R.id.settings -> {
			goToPreferences()
          true
        }
        else -> false
      }
    }
  }
}
