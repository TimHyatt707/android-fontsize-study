package com.example.android.fontsizestudy

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent


class MainActivity : AppCompatActivity() {

    companion object {
        const val SMALL_FONT = "Small"
        const val MEDIUM_FONT = "Medium"
        const val LARGE_FONT = "Large"
        const val FONT_SIZE_KEY = "FONT_SIZE"
        const val PACKAGE_NAME = "com.example.android.fontsizestudy"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val settings = getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)

        val fontSizePref = settings.getString(FONT_SIZE_KEY, MEDIUM_FONT)

        // Default size
        var themeId = R.style.ThemeMediumFont

        when (fontSizePref) {
            SMALL_FONT -> {
                themeId = R.style.ThemeSmallFont
            }
            LARGE_FONT -> {
                themeId = R.style.ThemeLargeFont
            }
            else -> { }
        }

        setTheme(themeId)

        // Theme must be set before onCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSmall.setOnClickListener {
            setSmallTheme()
        }

        btnMedium.setOnClickListener {
            setMediumTheme()
        }

        btnLarge.setOnClickListener {
            setLargeTheme()
        }
    }

    // Helper functions for setting new theme, activity must be reset to see changes on current screen
    private fun setSmallTheme() {
        val settings = getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)
        settings.edit().putString(FONT_SIZE_KEY, SMALL_FONT).apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setMediumTheme() {
        val settings = getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)
        settings.edit().putString(FONT_SIZE_KEY, MEDIUM_FONT).apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setLargeTheme() {
        val settings = getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)
        settings.edit().putString(FONT_SIZE_KEY, LARGE_FONT).apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}
