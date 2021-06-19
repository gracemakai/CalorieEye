package com.grace.calorieeye.view;


import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.grace.calorieeye.R;
import com.grace.calorieeye.adapter.NewItemRecyclerAdapter;
import com.grace.calorieeye.model.FoodNutrientsModel;
import com.grace.calorieeye.model.NewItemsModel;
import com.grace.calorieeye.model.SearchItemModel;
import com.grace.calorieeye.model.SearchSuggestionModel;
import com.grace.calorieeye.viewmodel.NewItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewItemDialogFragment extends Fragment {

    FloatingSearchView newItemSearchView;
    RecyclerView newItemRecyclerView;
    Button clearItemsBtn, logItemsBtn;
    View view;

    NewItemRecyclerAdapter recyclerAdapter;
    NewItemViewModel newItemViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newItemViewModel = new ViewModelProvider(this).get(NewItemViewModel.class);

        newItemViewModel.getSearchItemArrayListMutableLiveData()
                .observe(this, searchItemObserver);

        newItemViewModel.getFoodNutrientsModelsArrayListMutableLiveData()
                .observe(this, foodNutrientObserver);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.new_item_dialog, container, false);

        initViews();

        return view;
    }

    private void initViews() {
        newItemSearchView = view.findViewById(R.id.new_item_searchView);
        newItemRecyclerView = view.findViewById(R.id.new_item_dialog_recyclerview);
        clearItemsBtn = view.findViewById(R.id.clear_items_dialog);
        logItemsBtn = view.findViewById(R.id.log_items_dialog);

        recyclerAdapter = new NewItemRecyclerAdapter(getContext());
        newItemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newItemRecyclerView.setAdapter(recyclerAdapter);

        newItemSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {

            if (!newQuery.equals("")) {
                newItemViewModel.populateSearchList(newQuery);
                newItemSearchView.showProgress();
            }else {
                newItemSearchView.clearSuggestions();
            }
        });

        newItemSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                newItemViewModel.getFoodItemNutrients(searchSuggestion.getBody());
                newItemSearchView.clearSuggestions();
                newItemSearchView.clearQuery();
                searchSuggestion.getBody();
                newItemSearchView.clearFocus();
            }

            @Override
            public void onSearchAction(String currentQuery) {

            }
        });

    }

    Observer<ArrayList<SearchItemModel>> searchItemObserver = new Observer<ArrayList<SearchItemModel>>() {
        @Override
        public void onChanged(ArrayList<SearchItemModel> searchItemModels) {

            List<SearchSuggestionModel> suggestions = new ArrayList<>();
            for (int i = 0; i < searchItemModels.size(); i++){

                for (int j = 0; j < searchItemModels.get(i).getCommon().size(); j++){
                    SearchSuggestionModel searchSuggestionModel = new SearchSuggestionModel(
                            searchItemModels.get(i).getCommon().get(j).getFoodName());
                    suggestions.add(searchSuggestionModel);
                }
            }

            newItemSearchView.swapSuggestions(suggestions);
            newItemSearchView.hideProgress();
        }
    };

    Observer<ArrayList<FoodNutrientsModel>> foodNutrientObserver = new Observer<ArrayList<FoodNutrientsModel>>() {
        @Override
        public void onChanged(ArrayList<FoodNutrientsModel> foodNutrientsModels) {

            recyclerAdapter.setItemList(foodNutrientsModels);

        }
    };

}
