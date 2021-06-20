package com.grace.calorieeye.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.grace.calorieeye.R;
import com.grace.calorieeye.adapter.NewItemRecyclerAdapter;
import com.grace.calorieeye.helper.Common;
import com.grace.calorieeye.model.FoodNutrientsModel;
import com.grace.calorieeye.model.NewMealModel;

import java.util.ArrayList;
import java.util.Calendar;

public class NewMealFragment extends Fragment {
    
    View view;
    TextView totalCalories,newItem, timePicked, datePicked;
    EditText numberMeal;
    FloatingActionButton savMealFab;
    EditText nameOfMeal;
    RecyclerView newMealRecyclerView;

    NewItemRecyclerAdapter itemRecyclerAdapter;

    ArrayList<FoodNutrientsModel> foodNutrientsModelArrayList;
    int year, month, day, hour, minute;
    float originalCalories = 0;

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
            getTotalCalories();
        }

        initViews();
        
        return view;
    }

    private void initViews() {
        totalCalories = view.findViewById(R.id.total_calories_new_meal);
        newItem = view.findViewById(R.id.add_new_item_new_meal);
        numberMeal  = view.findViewById(R.id.number_meal);
        timePicked = view.findViewById(R.id.time_picked);
        datePicked = view.findViewById(R.id.date_picked);
        savMealFab = view.findViewById(R.id.save_meal_fab);
        nameOfMeal = view.findViewById(R.id.name_of_meal_new_meal);
        newMealRecyclerView = view.findViewById(R.id.new_meal_recyclerview);

        totalCalories.setText(String.valueOf(originalCalories));

        newMealRecyclerView.setAdapter(itemRecyclerAdapter);
        newMealRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        newItem.setOnClickListener(v -> {

            newPage(new NewItemFragment());

        });

        timePicked.setOnClickListener(v -> getTime());

        datePicked.setOnClickListener(v -> getDate());
        
        numberMeal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() != 0) {
                    float currentTotalCalories = originalCalories * Float.parseFloat(s.toString());
                    totalCalories.setText(String.valueOf(currentTotalCalories));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        savMealFab.setOnClickListener(v -> saveMeal());
    }

    private void getDate() {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year, monthOfYear, dayOfMonth) ->
                        datePicked.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year),
                year, month, day);

        datePickerDialog.show();
    }

    private void getTime() {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                (view, hourOfDay, minute) -> timePicked.setText(hourOfDay + ":" + minute)
                , hour, minute, true);
        timePickerDialog.show();
    }


    private void getTotalCalories() {

        for (int i = 0; i < foodNutrientsModelArrayList.size(); i++){
            FoodNutrientsModel foodNutrientsModel = foodNutrientsModelArrayList.get(i);
            originalCalories = originalCalories + foodNutrientsModel.getFoods().get(0).getNfCalories();
        }


    }


    private void saveMeal() {

        NewMealModel newMealModel = new NewMealModel(nameOfMeal.getText().toString(),
                timePicked.getText().toString(), datePicked.getText().toString(),
                totalCalories.getText().toString(), String.valueOf(originalCalories),
                numberMeal.getText().toString(), foodNutrientsModelArrayList);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference(Common.DbReference);

        databaseReference
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child(Common.MealReference)
                .push()
                .setValue(newMealModel)
                .addOnSuccessListener(aVoid -> {
                    newPage(new HomeScreenFragment());
                });
    }

    private void newPage(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment)
                .addToBackStack("");
        fragmentTransaction.commit();
    }
}