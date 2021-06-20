package com.grace.calorieeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AltMeasure {

    @SerializedName("serving_weight")
    @Expose
    private Float servingWeight;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("seq")
    @Expose
    private Integer seq;
    @SerializedName("qty")
    @Expose
    private Integer qty;

    public AltMeasure() {
    }

    public Float getServingWeight() {
        return servingWeight;
    }

    public void setServingWeight(Float servingWeight) {
        this.servingWeight = servingWeight;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}
