package com.grace.calorieeye.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.grace.calorieeye.R;
import com.grace.calorieeye.api.CalorieApiClient;
import com.grace.calorieeye.api.CalorieApiInterface;
import com.grace.calorieeye.model.FoodNutrientsModel;
import com.grace.calorieeye.model.NewItemsModel;
import com.grace.calorieeye.model.SearchItemModel;
import com.grace.calorieeye.repository.NewItemRepository;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewItemViewModel extends ViewModel {

    MutableLiveData<ArrayList<SearchItemModel>> searchItemArrayListMutableLiveData;
    MutableLiveData<ArrayList<FoodNutrientsModel>> foodNutrientsModelsArrayListMutableLiveData;

    ArrayList<SearchItemModel> searchItemModelArrayList;
    ArrayList<FoodNutrientsModel> foodNutrientsModels;

    Thread thread;
    CalorieApiInterface apiInterface;
    NewItemRepository newItemRepository;


    public NewItemViewModel() {
        searchItemArrayListMutableLiveData = new MutableLiveData<>();
        foodNutrientsModelsArrayListMutableLiveData = new MutableLiveData<>();
        foodNutrientsModels = new ArrayList<>();
        newItemRepository = new NewItemRepository();
        foodNutrientsModelsArrayListMutableLiveData = newItemRepository
                .getNewItemArrayListMutableLiveData();

    }


    public LiveData<ArrayList<SearchItemModel>> getSearchItemArrayListMutableLiveData() {
        return searchItemArrayListMutableLiveData;
    }

    public LiveData<ArrayList<FoodNutrientsModel>> getFoodNutrientsModelsArrayListMutableLiveData() {
        return foodNutrientsModelsArrayListMutableLiveData;
    }

    public void populateSearchList(String mealName) {

        Runnable fetchSuggestionsRunnable = () -> querySearchSuggestions(mealName);

        startThread(fetchSuggestionsRunnable);
    }

    public void getFoodItemNutrients(String mealName){
        Runnable fetchFoodItemNutrients = () -> newItemRepository.queryFoodItemNutrients(mealName);
        startThread(fetchFoodItemNutrients);
    }

    private void startThread(Runnable runnable){
        if (thread != null){
            thread.interrupt();
        }
        thread = new Thread(runnable);
        thread.start();
    }

    private void querySearchSuggestions(String meal) {

        searchItemModelArrayList = new ArrayList<>();
        apiInterface = CalorieApiClient.getClient().create(CalorieApiInterface.class);

        Call<SearchItemModel> call = apiInterface.getSearchItem(meal);

        call.enqueue(new Callback<SearchItemModel>() {
            @Override
            public void onResponse(Call<SearchItemModel> call, Response<SearchItemModel> response) {

                if (response.isSuccessful()){
                searchItemModelArrayList.add(response.body());
                Log.i(getClass().getSimpleName(), "onResponse: " + response.body().getCommon());

                searchItemArrayListMutableLiveData.postValue(searchItemModelArrayList);
                } else {
                    try {
                        Log.e(getClass().getSimpleName(), "onResponse: Unsuccessfull  " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchItemModel> call, Throwable t) {
                Log.e(getClass().getSimpleName(), "onFailure: ", t);
            }
        });
    }



}
