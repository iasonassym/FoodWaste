package com.example.dropdownmenus

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class WastedFoodPage : AppCompatActivity() {
    val array: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        println(array)
        var t1: TextView? = null
        var t2: TextView? = null
        var table = findViewById<View>(R.id.table) as TableLayout
        var table2 = findViewById<View>(R.id.table2) as TableLayout

        val foodData = ArrayList<String>()
        val amountData = ArrayList<String>()

        val typeData = ArrayList<String>()
        val dateData = ArrayList<String>()

        var sp: SharedPreferences? = null
        var sp2: SharedPreferences? = null
        sp = applicationContext.getSharedPreferences("FoodAndAmount", Context.MODE_PRIVATE)
        sp2 = applicationContext.getSharedPreferences("TypeAndDate", Context.MODE_PRIVATE)
        var food: String
        food = sp.getString("food", "").toString()
        var amount: String
        amount = sp.getString("amount", "").toString()

        var type: String
        type = sp2.getString("type", "").toString()
        var date: String
        date = sp2.getString("date", "").toString()


        var foods = food.split("@")
        foods = foods.subList(1, foods.size)
        var amounts = amount.split("@")
        amounts = amounts.subList(1, amounts.size)

        var types = type.split("@")
        types = types.subList(1, types.size)
        var dates = date.split("@")
        dates = dates.subList(1, dates.size)

        println(foods)
        foodData.addAll(foods)
        amountData.addAll(amounts)
        println(amounts)

        typeData.addAll(types)
        dateData.addAll(dates)

        println(types)
        println(dates)

        for (i in 0 until foodData.size) {
            val row = TableRow(this)
            val phone = foodData[i]
            val amount = amountData[i]
            val tv1 = TextView(this)
            tv1.text = phone
            val tv2 = TextView(this)
            tv2.text = amount
            row.addView(tv1)
            row.addView(tv2)
            table.addView(row)
        }

        for (i in 0 until typeData.size) {
            val row = TableRow(this)
            val phone = typeData[i]
            val amount = dateData[i]
            val tv1 = TextView(this)
            tv1.text = phone
            val tv2 = TextView(this)
            tv2.text = amount
            row.addView(tv1)
            row.addView(tv2)
            table2.addView(row)
        }
    }
}
