package com.example.dropdownmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import androidx.annotation.NonNull





class MainActivity : AppCompatActivity() {
    private var button: LinearLayout? = null
    private var viewWastedFoodButton: LinearLayout? = null
    private var settingsButton: Button? = null
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        button = findViewById<View>(R.id.layoutAddFood) as LinearLayout
        button!!.setOnClickListener { openActivity2() }

        viewWastedFoodButton = findViewById<View>(R.id.layoutViewWaste) as LinearLayout
        viewWastedFoodButton!!.setOnClickListener { openActivity3() }

        bottomNavigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView!!)

        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuHome -> {
                    val intent1 = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent1)
                }
                R.id.menuSettings -> {
                    val intent2 = Intent(this@MainActivity, SettingsPage::class.java)
                    startActivity(intent2)
                }
            }
            false
        }


//        settingsButton = findViewById<View>(R.id.button4) as Button
//        settingsButton!!.setOnClickListener { openActivity4() }
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