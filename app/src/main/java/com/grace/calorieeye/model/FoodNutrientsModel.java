package com.grace.calorieeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FoodNutrientsModel {

    @SerializedName("foods")
    @Expose
    private List<Food> foods = null;

    public FoodNutrientsModel() {
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }


}
