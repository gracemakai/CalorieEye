package com.grace.calorieeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FullNutrient {

@SerializedName("attr_id")
@Expose
private Integer attrId;
@SerializedName("value")
@Expose
private Double value;

public FullNutrient() {
}

public Integer getAttrId() {
    return attrId;
}

public void setAttrId(Integer attrId) {
    this.attrId = attrId;
}

public Double getValue() {
    return value;
}

public void setValue(Double value) {
    this.value = value;
}

}
