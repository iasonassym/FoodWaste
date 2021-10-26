package com.example.dropdownmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<View>(R.id.button3) as Button
        button!!.setOnClickListener { openActivity2() }
    }

    fun openActivity2() {
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }
}