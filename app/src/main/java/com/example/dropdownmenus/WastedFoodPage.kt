package com.example.dropdownmenus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.dropdownmenus.GlobalVariables
import com.ekn.gruzer.gaugelibrary.HalfGauge
import com.ekn.gruzer.gaugelibrary.Range
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.round
import android.widget.TextView
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text
import java.text.DateFormat


class WastedFoodPage : AppCompatActivity() {
    val array: MutableList<String> = ArrayList()
    private var bottomNavigationView: BottomNavigationView? = null

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
        var row = findViewById<View>(R.id.row) as TableRow
        var halfGauge = findViewById<HalfGauge>(R.id.halfGauge);
        var monthly_price = findViewById<View>(R.id.monthly_cost) as TextView
        var stats_button = findViewById<Button>(R.id.btn_stats) as Button

        val foodData = ArrayList<String>()
        val amountData = ArrayList<String>()

        val typeData = ArrayList<String>()
        val dateData = ArrayList<String>()

        var sp: SharedPreferences? = null
        var sp2: SharedPreferences? = null

        sp = applicationContext.getSharedPreferences("FoodAndAmount", Context.MODE_PRIVATE)
        sp2 = applicationContext.getSharedPreferences("TypeAndDate", Context.MODE_PRIVATE)

        bottomNavigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView!!)

        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuHome -> {
                    val intent1 = Intent(this@WastedFoodPage, MainActivity::class.java)
                    startActivity(intent1)
                }
                R.id.menuSettings -> {
                    val intent2 = Intent(this@WastedFoodPage, SettingsPage::class.java)
                    startActivity(intent2)
                }
            }
            false
        }

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

        for (i in 0 until 15) {
            val new_row = TableRow(this)
            val product = "Buk"
            val amount = "2"
            val unit = "gram"
            val date = "25"

            val product_col = TextView(this)
            val amount_col = TextView(this)
            val unit_col = TextView(this)
            val date_col = TextView(this)

            product_col.setText(product)
            product_col.textSize = 16F
            amount_col.setText(amount)
            amount_col.textSize = 16F
            unit_col.setText(unit)
            unit_col.textSize = 16F
            date_col.setText(date)
            date_col.textSize = 16F

            new_row.addView(product_col)
            new_row.addView(amount_col)
            new_row.addView(unit_col)
            new_row.addView(date_col)
            new_row.setBackgroundColor(Color.parseColor("#C2DBEB"))

            table.addView(new_row)
        }

        for (i in 0 until foodData.size) {

            val new_row = TableRow(this)
            val product = foodData[i]
            val amount = amountData[i]
            val unit = typeData[i]
            val date = dateData[i]

            val product_col = TextView(this)
            val amount_col = TextView(this)
            val unit_col = TextView(this)
            val date_col = TextView(this)

            product_col.setText(product)
            product_col.textSize = 16F
            amount_col.setText(amount)
            amount_col.textSize = 16F
            unit_col.setText(unit)
            unit_col.textSize = 16F
            date_col.setText(date)
            date_col.textSize = 16F

            new_row.addView(product_col)
            new_row.addView(amount_col)
            new_row.addView(unit_col)
            new_row.addView(date_col)
            new_row.setBackgroundColor(Color.parseColor("#C2DBEB"))

            table.addView(new_row)
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
        val int_monthly_cost = rounded_monthly_cost.toInt();

        if (rounded_monthly_cost >= 0.0 && rounded_monthly_cost < 25.0){
            monthly_price.setText("Well done being wasteless. Keep it up!")
        } else if (rounded_monthly_cost >= 25.0 && rounded_monthly_cost < 45.0){
            monthly_price.setText("Not bad, but can be want the needle to point green!")
        } else {
            rounded_monthly_cost = 80.0
            monthly_price.setText("Your food is very spoiled! Keep that in check.")
        }


        val range = Range()
        range.color = Color.parseColor("#BBF275")
        range.from = 0.0
        range.to = 25.0

        val range2 = Range()
        range2.color = Color.parseColor("#FAF278")
        range2.from = 25.0
        range2.to = 45.0

        val range3 = Range()
        range3.color = Color.parseColor("#F17257")
        range3.from = 45.0
        range3.to = 80.0

        //add color ranges to gauge
        halfGauge.addRange(range)
        halfGauge.addRange(range2)
        halfGauge.addRange(range3)

        //set min max and current value
        halfGauge.minValue = 0.0
        halfGauge.maxValue = 80.0
        halfGauge.value = rounded_monthly_cost
        halfGauge.setNeedleColor(Color.parseColor("#808080"))
        halfGauge.isEnableBackGroundShadow = false
        halfGauge.isEnableNeedleShadow = false
        halfGauge.minValueTextColor = 0
        halfGauge.maxValueTextColor = 0

        stats_button.setOnClickListener { goToStatsPage() }

    }

    fun goToStatsPage() {
        val intent = Intent(this, StatsPage::class.java)
        startActivity(intent)
    }
}




