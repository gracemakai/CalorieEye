package com.grace.calorieeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchItemModel {

    @SerializedName("common")
    @Expose
    private List<Common> common = null;
    @SerializedName("branded")
    @Expose
    private List<Branded> branded = null;

    public List<Common> getCommon() {
        return common;
    }

    public void setCommon(List<Common> common) {
        this.common = common;
    }

    public List<Branded> getBranded() {
        return branded;
    }

    public void setBranded(List<Branded> branded) {
        this.branded = branded;
    }

    public class Branded {

        @SerializedName("food_name")
        @Expose
        private String foodName;
        @SerializedName("serving_unit")
        @Expose
        private String servingUnit;
        @SerializedName("nix_brand_id")
        @Expose
        private String nixBrandId;
        @SerializedName("brand_name_item_name")
        @Expose
        private String brandNameItemName;
        @SerializedName("serving_qty")
        @Expose
        private Float servingQty;
        @SerializedName("nf_calories")
        @Expose
        private Integer nfCalories;
        @SerializedName("photo")
        @Expose
        private Photo__1 photo;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("region")
        @Expose
        private Integer region;
        @SerializedName("brand_type")
        @Expose
        private Integer brandType;
        @SerializedName("nix_item_id")
        @Expose
        private String nixItemId;
        @SerializedName("locale")
        @Expose
        private String locale;

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getServingUnit() {
            return servingUnit;
        }

        public void setServingUnit(String servingUnit) {
            this.servingUnit = servingUnit;
        }

        public String getNixBrandId() {
            return nixBrandId;
        }

        public void setNixBrandId(String nixBrandId) {
            this.nixBrandId = nixBrandId;
        }

        public String getBrandNameItemName() {
            return brandNameItemName;
        }

        public void setBrandNameItemName(String brandNameItemName) {
            this.brandNameItemName = brandNameItemName;
        }

        public Float getServingQty() {
            return servingQty;
        }

        public void setServingQty(Float servingQty) {
            this.servingQty = servingQty;
        }

        public Integer getNfCalories() {
            return nfCalories;
        }

        public void setNfCalories(Integer nfCalories) {
            this.nfCalories = nfCalories;
        }

        public Photo__1 getPhoto() {
            return photo;
        }

        public void setPhoto(Photo__1 photo) {
            this.photo = photo;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public Integer getRegion() {
            return region;
        }

        public void setRegion(Integer region) {
            this.region = region;
        }

        public Integer getBrandType() {
            return brandType;
        }

        public void setBrandType(Integer brandType) {
            this.brandType = brandType;
        }

        public String getNixItemId() {
            return nixItemId;
        }

        public void setNixItemId(String nixItemId) {
            this.nixItemId = nixItemId;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

    }

    public static class Common {

        @SerializedName("food_name")
        @Expose
        private String foodName;
        @SerializedName("serving_unit")
        @Expose
        private String servingUnit;
        @SerializedName("tag_name")
        @Expose
        private String tagName;
        @SerializedName("serving_qty")
        @Expose
        private Float servingQty;
        @SerializedName("common_type")
        @Expose
        private Object commonType;
        @SerializedName("tag_id")
        @Expose
        private String tagId;
        @SerializedName("photo")
        @Expose
        private Photo photo;
        @SerializedName("locale")
        @Expose
        private String locale;

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getServingUnit() {
            return servingUnit;
        }

        public void setServingUnit(String servingUnit) {
            this.servingUnit = servingUnit;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public Float getServingQty() {
            return servingQty;
        }

        public void setServingQty(Float servingQty) {
            this.servingQty = servingQty;
        }

        public Object getCommonType() {
            return commonType;
        }

        public void setCommonType(Object commonType) {
            this.commonType = commonType;
        }

        public String getTagId() {
            return tagId;
        }

        public void setTagId(String tagId) {
            this.tagId = tagId;
        }

        public Photo getPhoto() {
            return photo;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

    }

    public class Photo {

        @SerializedName("thumb")
        @Expose
        private String thumb;
        @SerializedName("highres")
        @Expose
        private Object highres;
        @SerializedName("is_user_uploaded")
        @Expose
        private Boolean isUserUploaded;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public Object getHighres() {
            return highres;
        }

        public void setHighres(Object highres) {
            this.highres = highres;
        }

        public Boolean getIsUserUploaded() {
            return isUserUploaded;
        }

        public void setIsUserUploaded(Boolean isUserUploaded) {
            this.isUserUploaded = isUserUploaded;
        }

    }

    public class Photo__1 {

        @SerializedName("thumb")
        @Expose
        private String thumb;
        @SerializedName("highres")
        @Expose
        private Object highres;
        @SerializedName("is_user_uploaded")
        @Expose
        private Boolean isUserUploaded;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public Object getHighres() {
            return highres;
        }

        public void setHighres(Object highres) {
            this.highres = highres;
        }

        public Boolean getIsUserUploaded() {
            return isUserUploaded;
        }

        public void setIsUserUploaded(Boolean isUserUploaded) {
            this.isUserUploaded = isUserUploaded;
        }

    }
}

