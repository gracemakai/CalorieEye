package com.grace.calorieeye.api;

import com.grace.calorieeye.model.FoodNutrientsModel;
import com.grace.calorieeye.model.SearchItemModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CalorieApiInterface {

    @GET("/v2/search/instant?")
    Call<SearchItemModel> getSearchItem(@Query("query") String meal);

    @POST("/v2/natural/nutrients")
    Call<FoodNutrientsModel> getFoodNutrients();

}
