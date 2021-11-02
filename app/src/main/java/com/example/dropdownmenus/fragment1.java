package com.example.dropdownmenus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class fragment1 extends Fragment {
    private Double monthly_avg_one;
    private Double monthly_avg_two;
    private final Double avg_money = 25.0;
    private final Double avg_waste = 2900.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StatsPage activity = (StatsPage) getActivity();
        assert activity != null;
        monthly_avg_one = activity.getMonthly_avg_one();
        monthly_avg_two = activity.getMonthly_avg_two();

        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        TextView text_one = view.findViewById(R.id.food_waste2);
        text_one.setText(this.monthly_avg_one.toString() + " €");
        TextView text_two = view.findViewById(R.id.food_waste3);
        String lessOrMore_one = "";
        double percentage_one = 0.0;
        if (this.monthly_avg_one <= avg_money){
            percentage_one = (1 - (monthly_avg_one/avg_money)) * 100;
            percentage_one = Math.round((percentage_one*100.0)/100.0);
            lessOrMore_one = Double.toString(percentage_one) + " % less";
        } else {
            percentage_one = (1 - (avg_money/monthly_avg_one)) * 100;
            percentage_one = Math.round((percentage_one*100.0)/100.0);
            lessOrMore_one = Double.toString(percentage_one) + " % more";
        }
        text_two.setText(lessOrMore_one);


        TextView text_three = view.findViewById(R.id.food_waste6);
        text_three.setText(this.monthly_avg_two.toString() + " grams");
        TextView text_four = view.findViewById(R.id.food_waste7);
        String lessOrMore_two = "";
        double percentage_two = 0.0;
        if (this.monthly_avg_one <= avg_money){
            percentage_two = (1 - (monthly_avg_two/avg_waste)) * 100;
            percentage_two = Math.round((percentage_two*100.0)/100.0);
            lessOrMore_two = Double.toString(percentage_two) + " % less";
        } else {
            percentage_two = (1 - (avg_waste/monthly_avg_two)) * 100;
            percentage_two = Math.round((percentage_two*100.0)/100.0);
            lessOrMore_two = Double.toString(percentage_two) + " % more";
        }
        text_four.setText(lessOrMore_two);
    }
}