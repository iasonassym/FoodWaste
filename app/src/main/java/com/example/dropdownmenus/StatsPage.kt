package com.example.dropdownmenus


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


internal class StatsPage : AppCompatActivity() {
    val array: MutableList<String> = ArrayList()
//    val barChart = findViewById<View>(R.id.barChart) as BarChart
    var monthly_avg_one = 0.0;
    var monthly_avg_two = 0.0;
    var money_per_month = ArrayList<Double>();
    var amount_per_month = ArrayList<Double>();
    var frequent_items = ArrayList<String>();
    var months = ArrayList<String>();

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        val viewPager = findViewById<View>(R.id.viewPager) as ViewPager


        val listOfProducts = GlobalVariables.getProducts();

        tabLayout.setupWithViewPager(viewPager)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager, FragmentAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        fragmentAdapter.addFragment(FragmentOne(), "");
        fragmentAdapter.addFragment(FragmentTwo(), "");
        fragmentAdapter.addFragment(FragmentThree(), "");
        viewPager.setAdapter(fragmentAdapter)

//        val average_money = viewPager.findViewById<View>(R.id.food_waste2) as TextView
//        val average_weight = viewPager.findViewById<View>(R.id.food_waste6) as TextView

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

        foodData.addAll(foods)
        amountData.addAll(amounts)
        typeData.addAll(types)
        dateData.addAll(dates)


        /**
         * Find monthly averages in Euro and Grams.
         */
        var curr_month = "nothing"
        var counted_months = 1;
        var avg_money_waste = 0.0;
        var avg_gram_waste = 0.0;

        for (i in 0 until foodData.size){
            if(curr_month != "nothing" && curr_month != dateData[i].trim().split(" ").get(0)){
                counted_months += 1
                months.add(curr_month)
                money_per_month.add(avg_money_waste)
                amount_per_month.add(avg_gram_waste)
                avg_money_waste = 0.0
                avg_gram_waste = 0.0
            }

            curr_month = dateData[i].trim().split(" ").get(0)
            months.add(curr_month)

            for (p in listOfProducts){

                if (foodData[i].trim().equals(p.name)){
                    frequent_items.add(p.name)
                    avg_money_waste += (p.price * Integer.parseInt(amountData[i].trim())) / p.quantity;

                    if(p.weight_per_unit != null){
                        avg_gram_waste += (Integer.parseInt(amountData[i].trim()) *  p.weight_per_unit)
                    } else {
                        avg_gram_waste += Integer.parseInt(amountData[i].trim())
                    }
                }
            }
        }
        money_per_month.add(avg_money_waste)
        amount_per_month.add(avg_gram_waste)

        monthly_avg_one = Math.round((money_per_month.sum() / counted_months)*100.0)/100.0;
        monthly_avg_two = Math.round((amount_per_month.sum() / counted_months)*100.0)/100.0;
        println(months)

    }

    fun getSortedFrequentItemList() : List<String> {
        return frequent_items.sortedByDescending { x -> frequent_items.count { it == x } }.distinct()
    }

    fun money_per_month() : ArrayList<Double> {
        return money_per_month
    }

    fun getMonthList() : List<String> {
        return months.distinct();
    }

    fun amount_per_month() : ArrayList<Double> {
        return amount_per_month
    }

    fun getMonthlyAvgOne() : Double {
        return monthly_avg_one
    }

    fun getMonthlyAvgTwo() : Double {
        return monthly_avg_two
    }
}