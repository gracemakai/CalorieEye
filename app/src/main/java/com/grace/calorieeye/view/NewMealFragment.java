package com.grace.calorieeye.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.grace.calorieeye.R;
import com.grace.calorieeye.adapter.NewItemRecyclerAdapter;
import com.grace.calorieeye.model.FoodNutrientsModel;

import java.util.ArrayList;

public class NewMealFragment extends Fragment {
    
    View view;
    TextView totalCalories,newItem, lessMeal, numberMeal, moreMeal, timePicked, datePicked;
    FloatingActionButton savMealFab;
    EditText nameOfMeal;
    RecyclerView newMealRecyclerView;

    NewItemRecyclerAdapter itemRecyclerAdapter;

    ArrayList<FoodNutrientsModel> foodNutrientsModelArrayList;

    public NewMealFragment(ArrayList<FoodNutrientsModel> foodNutrientsModels) {
        this.foodNutrientsModelArrayList = foodNutrientsModels;

    }

    public NewMealFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_meal, container, false);

        itemRecyclerAdapter = new NewItemRecyclerAdapter(getContext());

        if (foodNutrientsModelArrayList != null) {
            itemRecyclerAdapter.setItemList(foodNutrientsModelArrayList);
        }

        initViews();
        
        return view;
    }

    private void initViews() {
        totalCalories = view.findViewById(R.id.total_calories_new_meal);
        newItem = view.findViewById(R.id.add_new_item_new_meal);
        lessMeal  = view.findViewById(R.id.less_meal);
        numberMeal  = view.findViewById(R.id.number_meal);
        moreMeal = view.findViewById(R.id.more_meal);
        timePicked = view.findViewById(R.id.time_picked);
        datePicked = view.findViewById(R.id.date_picked);
        savMealFab = view.findViewById(R.id.save_meal_fab);
        nameOfMeal = view.findViewById(R.id.name_of_meal_new_meal);
        newMealRecyclerView = view.findViewById(R.id.new_meal_recyclerview);

        newMealRecyclerView.setAdapter(itemRecyclerAdapter);
        newMealRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        newItem.setOnClickListener(v -> {

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new NewItemFragment())
                    .addToBackStack("");
            fragmentTransaction.commit();

        });
    }
}