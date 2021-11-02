package com.example.dropdownmenus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

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
        ImageView prod_image0 = view.findViewById(R.id.img_prod1);
        ImageView prod_image1 = view.findViewById(R.id.img_prod2);
        ImageView prod_image2 = view.findViewById(R.id.img_prod3);
        StatsPage activity = (StatsPage) getActivity();
        assert activity != null;


        if (frequent_items.size() > 0){
            String name_one = frequent_items.get(0);
            prod_name0.setText(name_one);

            int imageResource = getResources().getIdentifier(name_one.toLowerCase(Locale.ROOT), "drawable", activity.getPackageName());
            prod_image0.setImageResource(imageResource);
        }

        if (frequent_items.size() > 1){
            String name_two = frequent_items.get(1);
            prod_name1.setText(name_two);

            int imageResource = getResources().getIdentifier(name_two.toLowerCase(Locale.ROOT), "drawable", activity.getPackageName());
            prod_image1.setImageResource(imageResource);
        }

        if (frequent_items.size() > 2){
            String name_three = frequent_items.get(2);
            prod_name2.setText(name_three);

            int imageResource = getResources().getIdentifier(name_three.toLowerCase(Locale.ROOT), "drawable", activity.getPackageName());
            prod_image2.setImageResource(imageResource);
        }
    }
}