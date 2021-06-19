package com.grace.calorieeye.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.grace.calorieeye.api.CalorieApiClient;
import com.grace.calorieeye.api.CalorieApiInterface;
import com.grace.calorieeye.model.FoodNutrientsModel;
import com.grace.calorieeye.model.NewItemsModel;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewItemRepository {
    static String BaseUrl = "https://trackapi.nutritionix.com";

    MutableLiveData<ArrayList<FoodNutrientsModel>> newItemArrayListMutableLiveData;

    ArrayList<FoodNutrientsModel> itemsModelArrayList;

    public NewItemRepository() {

        newItemArrayListMutableLiveData = new MutableLiveData<>();
        itemsModelArrayList = new ArrayList<>();

    }

    public MutableLiveData<ArrayList<FoodNutrientsModel>> getNewItemArrayListMutableLiveData() {
        return newItemArrayListMutableLiveData;
    }

    public void queryFoodItemNutrients(String mealName) {

        Call<FoodNutrientsModel> call = getClient(mealName).getFoodNutrients();

        call.enqueue(new Callback<FoodNutrientsModel>() {
            @Override
            public void onResponse(Call<FoodNutrientsModel> call, Response<FoodNutrientsModel> response) {

                if (response.isSuccessful()) {
                    itemsModelArrayList.add(response.body());

                    newItemArrayListMutableLiveData.postValue(itemsModelArrayList);
                } else {
                    try {
                        Log.e(getClass().getSimpleName(), "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodNutrientsModel> call, Throwable t) {

                Log.e(getClass().getSimpleName(), "onFailure: ", t);
            }
        });

    }

    private CalorieApiInterface getClient(String mealName) {


        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "query=" + mealName);

        builder.addInterceptor(chain -> {

            Request request = chain.request().newBuilder()
                    .header("x-app-id", "508091e4")
                    .header("x-app-key", "cfb4d2a7856f685dcc28931fdf026404")
                    .method("POST", body)
                    .build();

            return chain.proceed(request);
        });


        return new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()
                .create(CalorieApiInterface.class);
    }
}
