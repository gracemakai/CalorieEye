package com.grace.calorieeye.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.grace.calorieeye.R;
import com.grace.calorieeye.databinding.FragmentHomeScreenBinding;

public class HomeScreenFragment extends Fragment {

    View view;
    TextView nameOfDay, date;
    ImageView filterView;
    RecyclerView mealsRecyclerView;
    FloatingActionButton newMealFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHomeScreenBinding fragmentHomeScreenBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_home_screen, container, false);
        view = fragmentHomeScreenBinding.getRoot();

        initViews();

        return view;
    }

    private void initViews() {
        nameOfDay = view.findViewById(R.id.day_name);
        date = view.findViewById(R.id.date);
        filterView = view.findViewById(R.id.filter_view);
        mealsRecyclerView = view.findViewById(R.id.meals_recyclerview);
        newMealFab = view.findViewById(R.id.new_meal_fab);

        newMealFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new NewMealFragment());
                fragmentTransaction.commit();
            }
        });
    }
}