package com.grace.calorieeye.model;

import java.util.List;

public class NewMealModel {
    String nameOfMeal, time, date, totalCalories, originalCalories, mealQuantity;
    List<FoodNutrientsModel> foodNutrientsModels;

    public NewMealModel(String nameOfMeal, String time, String date, String totalCalories,
                        String originalCalories, String mealQuantity,
                        List<FoodNutrientsModel> foodNutrientsModels) {
        this.nameOfMeal = nameOfMeal;
        this.time = time;
        this.date = date;
        this.totalCalories = totalCalories;
        this.originalCalories = originalCalories;
        this.mealQuantity = mealQuantity;
        this.foodNutrientsModels = foodNutrientsModels;
    }

    public NewMealModel() {
    }

    public String getNameOfMeal() {
        return nameOfMeal;
    }

    public void setNameOfMeal(String nameOfMeal) {
        this.nameOfMeal = nameOfMeal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(String totalCalories) {
        this.totalCalories = totalCalories;
    }

    public String getOriginalCalories() {
        return originalCalories;
    }

    public void setOriginalCalories(String originalCalories) {
        this.originalCalories = originalCalories;
    }

    public String getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(String mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    public List<FoodNutrientsModel> getFoodNutrientsModels() {
        return foodNutrientsModels;
    }

    public void setFoodNutrientsModels(List<FoodNutrientsModel> foodNutrientsModels) {
        this.foodNutrientsModels = foodNutrientsModels;
    }
}
