package com.developbyte.gamesrawg.Services;

import android.util.Log;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitResponse {

    public static final String BASE_URL = "https://api.rawg.io/api/";
    public static final String LABEL_KEY = "key";
    public static final String VALUE_KEY = "833fe86345884c2c8f98c2b54653a190";


    public Retrofit createRetroFit(String url){
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void loadError(Throwable t){
        Log.e("Error -> ", t.getMessage());
    }
}
