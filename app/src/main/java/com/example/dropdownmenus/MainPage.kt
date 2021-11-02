package com.example.dropdownmenus

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.*
import android.widget.AdapterView

import android.widget.ArrayAdapter

import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.DateFormat
import java.util.*

class MainPage : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var button: Button? = null
    var calendar: Calendar? = java.util.Calendar.getInstance()
    var food: String? = null
    var amount: EditText? = null
    var type: String? = null
    var date: String? = null
    var sp: SharedPreferences? = null
    var sp2: SharedPreferences? = null
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("FoodAndAmount", Context.MODE_PRIVATE)
        sp2 = getSharedPreferences("TypeAndDate", Context.MODE_PRIVATE)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val foodSpinnerSpinner = findViewById<Spinner>(R.id.foodSpinner)
        val foodSpinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.Foods, R.layout.support_simple_spinner_dropdown_item
        )
        foodSpinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        foodSpinnerSpinner.adapter = foodSpinnerAdapter
        foodSpinnerSpinner.onItemSelectedListener = this

        val typeSpinner = findViewById<Spinner>(R.id.typeSpinner)
        val typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.Type, R.layout.spinner_layout
        )
        typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        typeSpinner.adapter = typeAdapter
        typeSpinner.onItemSelectedListener = this

        button = findViewById<View>(R.id.submitButton) as Button
        button!!.setOnClickListener { goToMainPage() }

        amount = findViewById<View>(R.id.btn_weight_input) as EditText
        amount!!.setGravity(Gravity.CENTER_HORIZONTAL);
        amount!!.setGravity(Gravity.CENTER_VERTICAL);
        amount!!.setPadding(0, 0, 0, 0);

        bottomNavigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView!!)

        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuHome -> {
                    val intent1 = Intent(this@MainPage, MainActivity::class.java)
                    startActivity(intent1)
                }
                R.id.menuSettings -> {
                    val intent2 = Intent(this@MainPage, SettingsPage::class.java)
                    startActivity(intent2)
                }
            }
            false
        }

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val text = parent.getItemAtPosition(position).toString()
        if (parent.count == 4) {
            type = text
        } else {
            food = text
        }
//        Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    fun goToMainPage() {
        println(amount?.text.toString())
        println(type)
        println(food)
        println(DateFormat.getDateInstance().format(calendar?.time).toString())

        date = DateFormat.getDateInstance().format(calendar?.time).toString()
        val editor = sp?.edit()
        val editor2 = sp2?.edit()

        val foodTaken = sp?.getString("food", "")
        val amountTaken = sp?.getString("amount", "")

        val typeTaken = sp2?.getString("type", "")
        val dateTaken = sp2?.getString("date", "")


        editor?.putString("food", foodTaken+" @ "+food)
        editor?.putString("amount", amountTaken+" @ "+amount?.text.toString())
        editor?.commit()

        editor2?.putString("type", typeTaken+" @ "+type)
        editor2?.putString("date", dateTaken+" @ "+date)
        editor2?.commit()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}