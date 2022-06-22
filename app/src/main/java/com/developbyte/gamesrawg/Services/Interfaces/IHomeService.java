package com.developbyte.gamesrawg.Services.Interfaces;

import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Model.GeneresListModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface IHomeService {

    @GET("genres")
    Call<GeneresListModel> getGeneresList(@QueryMap Map<String, String> options);

    @GET("games")
    Call<GamesListModel> getGameList(@QueryMap Map<String, String> options);

    @GET("games")
    Call<GamesListModel> getNewGameList(@QueryMap Map<String, String> options);
}
