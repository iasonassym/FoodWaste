package com.example.dropdownmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var viewWastedFoodButton: Button? = null
    private var settingsButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<View>(R.id.btn_add_waste) as Button
        button!!.setOnClickListener { openActivity2() }

        viewWastedFoodButton = findViewById<View>(R.id.btn_view_waste) as Button
        viewWastedFoodButton!!.setOnClickListener { openActivity3() }


        settingsButton = findViewById<View>(R.id.button4) as Button
        settingsButton!!.setOnClickListener { openActivity4() }
    }

    fun openActivity2() {
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }

    fun openActivity3() {
        val intent = Intent(this, WastedFoodPage::class.java)
        startActivity(intent)
    }

    fun openActivity4() {
        val intent = Intent(this, SettingsPage::class.java)
        startActivity(intent)
    }
}