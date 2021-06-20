package com.grace.calorieeye.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grace.calorieeye.R;
import com.grace.calorieeye.model.NewMealModel;

import java.util.ArrayList;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    View view;
    Context context;

    ArrayList<NewMealModel> newMealModelArrayList = new ArrayList<>();

    public HomeRecyclerAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context).inflate(R.layout.home_meal_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewMealModel newMealModel = newMealModelArrayList.get(position);
        holder.mealTime.setText(newMealModel.getTime());
        holder.mealDate.setText(newMealModel.getDate());
        holder.nameOfMeal.setText(newMealModel.getNameOfMeal());
        holder.mealItems.setText(String.valueOf(newMealModel.getFoodNutrientsModels().size()));
        holder.mealTotalCalories.setText(newMealModel.getTotalCalories());

    }

    @Override
    public int getItemCount() {
        return newMealModelArrayList.size();
    }

    public void setNewMealModelArrayList(ArrayList<NewMealModel> newMealModelArrayList) {
        this.newMealModelArrayList = newMealModelArrayList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mealTime, mealDate, nameOfMeal, mealItems, mealTotalCalories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mealTime = itemView.findViewById(R.id.meal_time_home);
            mealDate = itemView.findViewById(R.id.meal_date_home);
            nameOfMeal = itemView.findViewById(R.id.name_of_meal_home);
            mealItems = itemView.findViewById(R.id.meal_items_home);
            mealTotalCalories = itemView.findViewById(R.id.meal_total_calories_home);
        }
    }
}
