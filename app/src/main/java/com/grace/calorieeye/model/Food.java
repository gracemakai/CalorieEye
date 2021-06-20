package com.grace.calorieeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Food {

    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("brand_name")
    @Expose
    private Object brandName;
    @SerializedName("serving_qty")
    @Expose
    private Integer servingQty;
    @SerializedName("serving_unit")
    @Expose
    private String servingUnit;
    @SerializedName("serving_weight_grams")
    @Expose
    private Float servingWeightGrams;
    @SerializedName("nf_calories")
    @Expose
    private Float nfCalories;
    @SerializedName("nf_total_fat")
    @Expose
    private Float nfTotalFat;
    @SerializedName("nf_saturated_fat")
    @Expose
    private Float nfSaturatedFat;
    @SerializedName("nf_cholesterol")
    @Expose
    private Float nfCholesterol;
    @SerializedName("nf_sodium")
    @Expose
    private Float nfSodium;
    @SerializedName("nf_total_carbohydrate")
    @Expose
    private Float nfTotalCarbohydrate;
    @SerializedName("nf_dietary_fiber")
    @Expose
    private Float nfDietaryFiber;
    @SerializedName("nf_sugars")
    @Expose
    private Float nfSugars;
    @SerializedName("nf_protein")
    @Expose
    private Float nfProtein;
    @SerializedName("nf_potassium")
    @Expose
    private Float nfPotassium;
    @SerializedName("nf_p")
    @Expose
    private Float nfP;
    @SerializedName("full_nutrients")
    @Expose
    private List<FullNutrient> fullNutrients = null;
    @SerializedName("nix_brand_name")
    @Expose
    private Object nixBrandName;
    @SerializedName("nix_brand_id")
    @Expose
    private Object nixBrandId;
    @SerializedName("nix_item_name")
    @Expose
    private Object nixItemName;
    @SerializedName("nix_item_id")
    @Expose
    private Object nixItemId;
    @SerializedName("upc")
    @Expose
    private Object upc;
    @SerializedName("consumed_at")
    @Expose
    private String consumedAt;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("source")
    @Expose
    private Integer source;
    @SerializedName("ndb_no")
    @Expose
    private Integer ndbNo;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("alt_measures")
    @Expose
    private List<AltMeasure> altMeasures = null;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("meal_type")
    @Expose
    private Integer mealType;
    @SerializedName("photo")
    @Expose
    private Photo photo;

    public Food() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Object getBrandName() {
        return brandName;
    }

    public void setBrandName(Object brandName) {
        this.brandName = brandName;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    public Float getServingWeightGrams() {
        return servingWeightGrams;
    }

    public void setServingWeightGrams(Float servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    public Float getNfCalories() {
        return nfCalories;
    }

    public void setNfCalories(Float nfCalories) {
        this.nfCalories = nfCalories;
    }

    public Float getNfTotalFat() {
        return nfTotalFat;
    }

    public void setNfTotalFat(Float nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    public Float getNfSaturatedFat() {
        return nfSaturatedFat;
    }

    public void setNfSaturatedFat(Float nfSaturatedFat) {
        this.nfSaturatedFat = nfSaturatedFat;
    }

    public Float getNfCholesterol() {
        return nfCholesterol;
    }

    public void setNfCholesterol(Float nfCholesterol) {
        this.nfCholesterol = nfCholesterol;
    }

    public Float getNfSodium() {
        return nfSodium;
    }

    public void setNfSodium(Float nfSodium) {
        this.nfSodium = nfSodium;
    }

    public Float getNfTotalCarbohydrate() {
        return nfTotalCarbohydrate;
    }

    public void setNfTotalCarbohydrate(Float nfTotalCarbohydrate) {
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
    }

    public Float getNfDietaryFiber() {
        return nfDietaryFiber;
    }

    public void setNfDietaryFiber(Float nfDietaryFiber) {
        this.nfDietaryFiber = nfDietaryFiber;
    }

    public Float getNfSugars() {
        return nfSugars;
    }

    public void setNfSugars(Float nfSugars) {
        this.nfSugars = nfSugars;
    }

    public Float getNfProtein() {
        return nfProtein;
    }

    public void setNfProtein(Float nfProtein) {
        this.nfProtein = nfProtein;
    }

    public Float getNfPotassium() {
        return nfPotassium;
    }

    public void setNfPotassium(Float nfPotassium) {
        this.nfPotassium = nfPotassium;
    }

    public Float getNfP() {
        return nfP;
    }

    public void setNfP(Float nfP) {
        this.nfP = nfP;
    }

    public List<FullNutrient> getFullNutrients() {
        return fullNutrients;
    }

    public void setFullNutrients(List<FullNutrient> fullNutrients) {
        this.fullNutrients = fullNutrients;
    }

    public Object getNixBrandName() {
        return nixBrandName;
    }

    public void setNixBrandName(Object nixBrandName) {
        this.nixBrandName = nixBrandName;
    }

    public Object getNixBrandId() {
        return nixBrandId;
    }

    public void setNixBrandId(Object nixBrandId) {
        this.nixBrandId = nixBrandId;
    }

    public Object getNixItemName() {
        return nixItemName;
    }

    public void setNixItemName(Object nixItemName) {
        this.nixItemName = nixItemName;
    }

    public Object getNixItemId() {
        return nixItemId;
    }

    public void setNixItemId(Object nixItemId) {
        this.nixItemId = nixItemId;
    }

    public Object getUpc() {
        return upc;
    }

    public void setUpc(Object upc) {
        this.upc = upc;
    }

    public String getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(String consumedAt) {
        this.consumedAt = consumedAt;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(Integer ndbNo) {
        this.ndbNo = ndbNo;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public List<AltMeasure> getAltMeasures() {
        return altMeasures;
    }

    public void setAltMeasures(List<AltMeasure> altMeasures) {
        this.altMeasures = altMeasures;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public Integer getMealType() {
        return mealType;
    }

    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

}
