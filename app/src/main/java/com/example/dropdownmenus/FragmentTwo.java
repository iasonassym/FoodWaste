package com.example.dropdownmenus;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {
    private List<Double> moneyPerMonth;
    private List<String> months;
    private List<Double> amountPerMonth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        StatsPage activity = (StatsPage) getActivity();
        assert activity != null;
        moneyPerMonth = activity.getMoney_per_month();
        amountPerMonth = activity.getAmount_per_month();
        months = activity.getMonthList();
        System.out.println(months);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        BarChart barChart = view.findViewById(R.id.barChart);
        barChart.setDrawValueAboveBar(false);
        barChart.getDescription().setEnabled(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(months));
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);

        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if(months.size() <= (int) value){
                    return "-";
                }
                return months.get((int) value);
            }
        };

        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        BarDataSet barDataSet = new BarDataSet(dataValues(), "Average Money Wasted per Month in the last 4 months");
        barDataSet.setColor(Color.parseColor("#EC7063"));

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);

        barChart.setData(barData);
        barChart.invalidate();
    }

    private ArrayList<BarEntry> dataValues(){
        ArrayList<BarEntry> dataVals = new ArrayList<>();

        dataVals.add(new BarEntry(0, 0));
        dataVals.add(new BarEntry(1, 0));
        dataVals.add(new BarEntry(2, 0));
        dataVals.add(new BarEntry(3, 0));

        for (int i = 0; i < moneyPerMonth.size(); i++){
            dataVals.get(i).setY(moneyPerMonth.get(i).floatValue());
        }

        return dataVals;
    }


}