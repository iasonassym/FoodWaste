package com.example.dropdownmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView

import android.widget.Toast

import android.widget.ArrayAdapter

import android.widget.Spinner





class MainPage : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var button: Button? = null
    var food: String? = null
    var amount: EditText? = null
    var type: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
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

//        println(foodSpinnerSpinner.selectedItem.toString())


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
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


//    class Foods : AppCompatActivity(), AdapterView.OnItemSelectedListener {
//
//        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
////            println(parent.count)
////            println(view)
////            println(id)
//
//            val text = parent.getItemAtPosition(position).toString()
//            food = text
//            Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
//            println(parent.getItemAtPosition(position).toString())
//        }
//
//        override fun onNothingSelected(parent: AdapterView<*>?) {}
//    }
//
//    class Types : AppCompatActivity(), AdapterView.OnItemSelectedListener{
//
//        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//            println(parent.count)
//            println(view)
//            println(id)
//            val text = parent.getItemAtPosition(position).toString()
//            Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
//            println(parent.getItemAtPosition(position).toString())
//        }
//
//        override fun onNothingSelected(parent: AdapterView<*>?) {}
//    }

}


//class MainPage : AppCompatActivity(), AdapterView.OnItemSelectedListener {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val spinner = findViewById<Spinner>(R.id.foodSpinner)
//        val adapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.Foods, android.R.layout.simple_spinner_item
//        )
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = adapter
//        spinner.onItemSelectedListener = this
//    }
//
//    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
//        println("hi")
//        val text = parent.getItemAtPosition(position).toString()
//        Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {}
//}