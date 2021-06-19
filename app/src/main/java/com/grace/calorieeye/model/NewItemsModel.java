package com.grace.calorieeye.model;

import android.graphics.drawable.Drawable;

import java.util.List;

public class NewItemsModel {
    String itemImageResource;
    String itemQuantity, itemName, itemCalories, currentCalories, itemWeight;
    List<ServingAltMeasures> servingAltMeasures;


    public NewItemsModel() {
    }

    public NewItemsModel(String itemImageResource, String itemQuantity, String itemName,
                         String itemCalories, String itemWeight,
                         List<ServingAltMeasures> servingAltMeasures) {
        this.itemImageResource = itemImageResource;
        this.itemQuantity = itemQuantity;
        this.itemName = itemName;
        this.itemCalories = itemCalories;
        this.itemWeight = itemWeight;
        this.servingAltMeasures = servingAltMeasures;
    }

    public String getItemImageResource() {
        return itemImageResource;
    }

    public void setItemImageResource(String itemImageResource) {
        this.itemImageResource = itemImageResource;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCalories() {
        return itemCalories;
    }

    public void setItemCalories(String itemCalories) {
        this.itemCalories = itemCalories;
    }

    public String getCurrentCalories() {
        return currentCalories;
    }

    public void setCurrentCalories(String currentCalories) {
        this.currentCalories = currentCalories;
    }

    public List<ServingAltMeasures> getServingAltMeasures() {
        return servingAltMeasures;
    }

    public void setServingAltMeasures(List<ServingAltMeasures> servingAltMeasures) {
        this.servingAltMeasures = servingAltMeasures;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public static class ServingAltMeasures {
        String servingUnit;
        Float servingUnitGrams;

        public ServingAltMeasures(String servingUnit, Float servingUnitGrams) {
            this.servingUnit = servingUnit;
            this.servingUnitGrams = servingUnitGrams;
        }

        public String getServingUnit() {
            return servingUnit;
        }

        public void setServingUnit(String servingUnit) {
            this.servingUnit = servingUnit;
        }

        public Float getServingUnitGrams() {
            return servingUnitGrams;
        }

        public void setServingUnitGrams(Float servingUnitGrams) {
            this.servingUnitGrams = servingUnitGrams;
        }
    }
}
