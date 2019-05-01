package com.example.android.fontsizestudy

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val settings = getSharedPreferences("com.example.android.fontsizestudy", Context.MODE_PRIVATE)

        val fontSizePref = settings.getString("FONT_SIZE", "Medium")

        var themeId = R.style.Theme_TextMedium
        if (fontSizePref == "Small") {
            themeId = R.style.Theme_TextSmall
        } else if (fontSizePref == "Large") {
            themeId = R.style.Theme_TextLarge
        }

        setTheme(themeId)

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

    private fun setSmallTheme() {
        val settings = getSharedPreferences("com.example.android.fontsizestudy", Context.MODE_PRIVATE)
        settings.edit().putString("FONT_SIZE", "Small").apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setMediumTheme() {
        val settings = getSharedPreferences("com.example.android.fontsizestudy", Context.MODE_PRIVATE)
        settings.edit().putString("FONT_SIZE", "Medium").apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setLargeTheme() {
        val settings = getSharedPreferences("com.example.android.fontsizestudy", Context.MODE_PRIVATE)
        settings.edit().putString("FONT_SIZE", "Large").apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}
