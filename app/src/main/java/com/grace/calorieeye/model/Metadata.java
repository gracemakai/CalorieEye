package com.grace.calorieeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {
@SerializedName("is_raw_food")
@Expose
boolean rawFood;

public Metadata() {
}

public boolean isRawFood() {
    return rawFood;
}

public void setRawFood(boolean rawFood) {
    this.rawFood = rawFood;
}
}
