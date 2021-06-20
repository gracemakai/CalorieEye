package com.grace.calorieeye.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.grace.calorieeye.R;
import com.grace.calorieeye.adapter.HomeRecyclerAdapter;
import com.grace.calorieeye.model.NewMealModel;
import com.grace.calorieeye.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class HomeScreenFragment extends Fragment {

    View view;
    TextView date;
    RecyclerView mealsRecyclerView;
    FloatingActionButton newMealFab;
    Toolbar toolbar;

    HomeViewModel homeViewModel;
    HomeRecyclerAdapter homeRecyclerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeRecyclerAdapter = new HomeRecyclerAdapter(getContext());
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        homeViewModel.getMealsListMutableLiveData()
                .observe(this, mealsObserver);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home_screen, container, false);


        homeViewModel.getMeals();

        initViews();

        return view;
    }

    private void initViews() {
        date = view.findViewById(R.id.date);
        mealsRecyclerView = view.findViewById(R.id.meals_recyclerview);
        newMealFab = view.findViewById(R.id.new_meal_fab);
        toolbar = view.findViewById(R.id.home_toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        mealsRecyclerView.setAdapter(homeRecyclerAdapter);
        mealsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        newMealFab.setOnClickListener(v -> {
            newPage(new NewMealFragment());
        });
    }

    Observer<ArrayList<NewMealModel>> mealsObserver = new Observer<ArrayList<NewMealModel>>() {
        @Override
        public void onChanged(ArrayList<NewMealModel> newMealModels) {
            Log.i(getClass().getSimpleName(), "onChanged: Observer " + newMealModels.toString());
            homeRecyclerAdapter.setNewMealModelArrayList(newMealModels);
        }
    };

    private void newPage(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment)
                .addToBackStack("");
        fragmentTransaction.commit();
    }

}