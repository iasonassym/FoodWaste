package com.example.dropdownmenus

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WastedFoodPage : AppCompatActivity() {
    val array: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        var t1: TextView? = null
        var t2: TextView? = null

        t1 = findViewById(R.id.textView)
        t2 = findViewById(R.id.textView2)

        var sp: SharedPreferences? = null
        sp = applicationContext.getSharedPreferences("FoodAndAmount", Context.MODE_PRIVATE)
        var food: String
        food = sp.getString("food", "").toString()
        var amount: String
        amount = sp.getString("amount", "").toString()
        array.add(food)
        array.add(amount)
        t1.setText(array.toString())
//        t1.setText(food)
//        t2.setText(amount)

    }

}
