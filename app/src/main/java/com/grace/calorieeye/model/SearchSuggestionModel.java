package com.grace.calorieeye.model;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

public class SearchSuggestionModel implements SearchSuggestion {

    String suggestion;

    public SearchSuggestionModel(String suggestion) {
        this.suggestion = suggestion.toLowerCase();
    }

    public SearchSuggestionModel(Parcel source) {
        this.suggestion = source.readString();
    }

    @Override
    public String getBody() {
        return suggestion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<SearchSuggestionModel> CREATOR = new Creator<SearchSuggestionModel>() {
        @Override
        public SearchSuggestionModel createFromParcel(Parcel source) {
            return new SearchSuggestionModel(source);
        }

        @Override
        public SearchSuggestionModel[] newArray(int size) {
            return new SearchSuggestionModel[0];
        }
    };
}
