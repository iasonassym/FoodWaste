package com.example.dropdownmenus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentThree extends Fragment {
    private List<String> frequent_items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StatsPage activity = (StatsPage) getActivity();
        assert activity != null;
        frequent_items = activity.getSortedFrequentItemList();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView prod_name0 = view.findViewById(R.id.prod1_name);
        TextView prod_name1 = view.findViewById(R.id.prod2_name);
        TextView prod_name2 = view.findViewById(R.id.prod3_name);

        if (frequent_items.size() > 0){
            prod_name0.setText(frequent_items.get(0));
        }

        if (frequent_items.size() > 1){
            prod_name1.setText(frequent_items.get(1));
        }

        if (frequent_items.size() > 2){
            prod_name2.setText(frequent_items.get(2));
        }
    }
}