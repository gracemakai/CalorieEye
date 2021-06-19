package com.grace.calorieeye.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grace.calorieeye.R;
import com.grace.calorieeye.model.FoodNutrientsModel;
import com.grace.calorieeye.model.NewItemsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewItemRecyclerAdapter extends RecyclerView.Adapter<NewItemRecyclerAdapter.ViewHolder> {

    View view;
    Context context;

    ArrayList<FoodNutrientsModel> foodNutrientsModelArrayList = new ArrayList<>();
    FoodNutrientsModel foodNutrientsModel;

    public NewItemRecyclerAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context).inflate(R.layout.new_item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        foodNutrientsModel = foodNutrientsModelArrayList.get(position);
        List<NewItemsModel.ServingAltMeasures> servingUnit = new ArrayList<>();
        List<String> servingMeasureName = new ArrayList<>();


        for (int i = 0; i < foodNutrientsModel.getFoods()
                .get(0).getAltMeasures().size(); i++) {

            servingUnit.add(new NewItemsModel.ServingAltMeasures(
                    foodNutrientsModel.getFoods().get(0).getAltMeasures().get(i).getMeasure(),
                    foodNutrientsModel.getFoods().get(0).getAltMeasures().get(i).getServingWeight()));
        }

        for (int i = 0; i < servingUnit.size(); i++){
            servingMeasureName.add(servingUnit.get(i).getServingUnit());
        }

        NewItemsModel newItemsModel = new NewItemsModel(
                foodNutrientsModel.getFoods().get(0).getPhoto().getThumb(),
                foodNutrientsModel.getFoods().get(0).getServingQty().toString(),
                foodNutrientsModel.getFoods().get(0).getFoodName(),
                foodNutrientsModel.getFoods().get(0).getNfCalories().toString(),
                foodNutrientsModel.getFoods().get(0).getServingWeightGrams().toString(),
                servingUnit);

        Picasso.get()
                .load(newItemsModel.getItemImageResource())
                .centerCrop()
                .fit()
                .into(holder.foodItemImage);

        holder.itemQuantity.setText(newItemsModel.getItemQuantity());
        holder.itemName.setText(newItemsModel.getItemName());
        holder.itemCalories.setText(newItemsModel.getItemCalories());
        holder.servingSizeUnit.setAdapter(
                new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item,
                        servingMeasureName));

        holder.itemQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    int quantity = Integer.parseInt(s.toString());
                    String newCalorie = String.valueOf((Float.parseFloat(
                            newItemsModel.getItemCalories()) * quantity));
                    holder.itemCalories.setText(newCalorie);
                    newItemsModel.setCurrentCalories(holder.itemCalories.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        holder.servingSizeUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                float newCalories = newServingUnit(servingUnit, newItemsModel, position);
                holder.itemCalories.setText(String.valueOf(newCalories));
                newItemsModel.setItemCalories(holder.itemCalories.getText().toString());
                newItemsModel.setCurrentCalories(holder.itemCalories.getText().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void setItemList(ArrayList<FoodNutrientsModel> newItemsModels){
        this.foodNutrientsModelArrayList = newItemsModels;
        notifyDataSetChanged();
    }

    private float newServingUnit(List<NewItemsModel.ServingAltMeasures> servingUnitString, NewItemsModel newItemsModel, int position) {

        return (
                servingUnitString.get(position).getServingUnitGrams() /
                        Float.parseFloat(newItemsModel.getItemWeight())) *
                Float.parseFloat(newItemsModel.getItemCalories());
    }

    @Override
    public int getItemCount() {
        return foodNutrientsModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodItemImage;
        EditText itemQuantity;
        TextView itemName, itemCalories;
        Spinner servingSizeUnit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodItemImage = itemView.findViewById(R.id.food_item_image);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
            itemName = itemView.findViewById(R.id.item_name);
            itemCalories = itemView.findViewById(R.id.item_calories);
            servingSizeUnit = itemView.findViewById(R.id.serving_size_unit);
        }
    }
}
