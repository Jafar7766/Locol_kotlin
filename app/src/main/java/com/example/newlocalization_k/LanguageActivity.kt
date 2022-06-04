package com.example.newlocalization_k

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import java.util.*

class LanguageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        initViews()
    }

    fun initViews(){
        var b_english = findViewById<Button>(R.id.b_english)
        var b_uzbek = findViewById<Button>(R.id.b_uzbek)
        var b_korean = findViewById<Button>(R.id.b_korean)
        var b_japanese = findViewById<Button>(R.id.b_japanese)

        b_english.setOnClickListener{
            setLocale("en")
        }
        b_uzbek.setOnClickListener{
            setLocale("uz")
        }
        b_korean.setOnClickListener{
           setLocale("ko")
        }
        b_japanese.setOnClickListener{
            setLocale("ja")
        }
        val one = resources.getQuantityString(R.plurals.my_cats, 1,1)

        val few = resources.getQuantityString(R.plurals.my_cats, 2,3)

        val many = resources.getQuantityString(R.plurals.my_cats, 5,10)

        Timber.d("LanguageActivity",one)
        Timber.d("LanguageActivity",few)
        Timber.d("LanguageActivity",many)
    }

    fun setLocale(lan:String){
        val locale = Locale(lan)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}