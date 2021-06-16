package com.grace.calorieeye.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grace.calorieeye.R;

public class EditMealFragment extends Fragment {

    View view;
    TextView time, date, nameOfMeal, addNewMeal;
    RecyclerView editMealRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit_meal, container, false);

        initViews();

        return view;
    }

    private void initViews() {
        time = view.findViewById(R.id.time);
        date = view.findViewById(R.id.date);
        nameOfMeal = view.findViewById(R.id.name_of_meal);
        addNewMeal = view.findViewById(R.id.add_new_meal);
        editMealRecyclerView = view.findViewById(R.id.edit_meal_recyclerview);
    }
}