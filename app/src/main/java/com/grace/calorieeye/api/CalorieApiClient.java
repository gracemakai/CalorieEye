package com.grace.calorieeye.api;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalorieApiClient {
    static String BaseUrl = "https://trackapi.nutritionix.com";

    public static Retrofit getClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(chain -> {

            Request request = chain.request().newBuilder()
                    .header("x-app-id", "508091e4")
                    .header("x-app-key", "cfb4d2a7856f685dcc28931fdf026404")
                    .method("GET", null)
                    .build();

            return chain.proceed(request);
        });

        return new Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }


}
