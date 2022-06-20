package com.developbyte.gamesrawg.Services;

import com.developbyte.gamesrawg.Model.GeneresListModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface IGenereGame {

    @GET("games")
    Call<GeneresListModel> getGameList(@QueryMap Map<String, String> options);
}
