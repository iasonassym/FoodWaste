package com.example.dropdownmenus

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView

import android.widget.Toast

import android.widget.ArrayAdapter

import android.widget.Spinner
import java.sql.Time
import java.text.DateFormat
import java.util.*

class MainPage : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var button: Button? = null
    var calendar: Calendar? = java.util.Calendar.getInstance()
    var food: String? = null
    var amount: EditText? = null
    var type: String? = null
    var sp: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("FoodAndAmount", Context.MODE_PRIVATE)
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
            R.array.Type, R.layout.support_simple_spinner_dropdown_item
        )
        typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        typeSpinner.adapter = typeAdapter
        typeSpinner.onItemSelectedListener = this

        button = findViewById<View>(R.id.submitButton) as Button
        button!!.setOnClickListener { goToMainPage() }

        amount = findViewById<View>(R.id.editTextNumber) as EditText

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val text = parent.getItemAtPosition(position).toString()
        if (parent.count == 4) {
            type = text
        } else {
            food = text
        }
        Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    fun goToMainPage() {
        println(amount?.text.toString())
        println(type)
        println(food)
        println(DateFormat.getDateInstance().format(calendar?.time))
        val editor = sp?.edit()
        editor?.putString("food", food)
        editor?.putString("amount", amount?.text.toString())
        editor?.commit()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}