package com.grace.calorieeye.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.grace.calorieeye.helper.Common;
import com.grace.calorieeye.model.NewMealModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    MutableLiveData<ArrayList<NewMealModel>> mealsListMutableLiveData;

    ArrayList<NewMealModel> newMealModelArrayList;

    Thread thread;

    public HomeViewModel() {
        mealsListMutableLiveData = new MutableLiveData<>();
        newMealModelArrayList = new ArrayList<>();
    }

    public MutableLiveData<ArrayList<NewMealModel>> getMealsListMutableLiveData() {
        return mealsListMutableLiveData;
    }

    public void getMeals() {
        Runnable getAllMeals = this::queryAllMeals;

        startThread(getAllMeals);
    }

    private void queryAllMeals() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference(Common.DbReference)
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child(Common.MealReference);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d : snapshot.getChildren()) {
                    NewMealModel newMealModel = d.getValue(NewMealModel.class);
                    newMealModelArrayList.add(newMealModel);
                }

                Log.i(getClass().getSimpleName(), "onDataChange: " + newMealModelArrayList.toString());

                mealsListMutableLiveData.postValue(newMealModelArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(getClass().getSimpleName(), "onCancelled: " + error.getMessage());
            }
        });
    }

    private void startThread(Runnable runnable){
        if (thread != null){
            thread.interrupt();
        }
        thread = new Thread(runnable);
        thread.start();
    }

}
