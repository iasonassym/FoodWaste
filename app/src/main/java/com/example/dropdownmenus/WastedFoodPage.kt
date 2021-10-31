package com.example.dropdownmenus

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dropdownmenus.GlobalVariables
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.round

class WastedFoodPage : AppCompatActivity() {
    val array: MutableList<String> = ArrayList()
    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        println(array)
        var t1: TextView? = null
        var t2: TextView? = null
        var table = findViewById<View>(R.id.table) as TableLayout
        var table2 = findViewById<View>(R.id.table2) as TableLayout
        var monthly_price = findViewById<View>(R.id.monthly_cost) as TextView

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

        val listOfProducts = GlobalVariables.getProducts();
        var monthly_cost = 0.0;
        var rounded_monthly_cost = 0.0;

        for (i in 0 until foodData.size) {
            val foodName = foodData[i].trim();
            val foodQuantity = amountData[i].trim();
            val foodDate = dateData[i].trim().split(" ")[0];

            val date: Date = Date()
            val cal: Calendar = Calendar.getInstance()
            cal.setTime(date)
            val current_month: Int = cal.get(Calendar.MONTH)
            var isCurrentMonth = false

            println(current_month)

            when (foodDate){
                "Jan" -> if(current_month == 0) isCurrentMonth = true
                "Feb" -> if(current_month == 1) isCurrentMonth = true
                "Mar" -> if(current_month == 2) isCurrentMonth = true
                "Apr" -> if(current_month == 3) isCurrentMonth = true
                "May" -> if(current_month == 4) isCurrentMonth = true
                "Jun" -> if(current_month == 5) isCurrentMonth = true
                "Jul" -> if(current_month == 6) isCurrentMonth = true
                "Aug" -> if(current_month == 7) isCurrentMonth = true
                "Sep" -> if(current_month == 8) isCurrentMonth = true
                "Oct" -> if(current_month == 9) {
                    println("was here")
                    isCurrentMonth = true
                    println(isCurrentMonth)
                }
                "Nov" -> if(current_month == 10) isCurrentMonth = true
                "Dec" -> if(current_month == 11) isCurrentMonth = true
            }

            println(isCurrentMonth)
            println("f is $foodName")
            for (p in listOfProducts){
                println(dateData[i])
                if (foodName.equals(p.name) && isCurrentMonth){
                    println("p is " + p.name)
                    monthly_cost += (p.price * Integer.parseInt(foodQuantity)) / p.quantity;
                }
            }
        }
        rounded_monthly_cost = Math.round(monthly_cost*100.0)/100.0;
        monthly_price.setText("This month you have wasted: $rounded_monthly_cost EUR")
    }
}



