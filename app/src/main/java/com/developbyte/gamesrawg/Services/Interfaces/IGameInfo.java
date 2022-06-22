package com.developbyte.gamesrawg.Services.Interfaces;

import com.developbyte.gamesrawg.Model.InfoGameModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface IGameInfo {

    @GET("games/{id}")
    Call<InfoGameModel> getGameList(@Path("id") int id, @QueryMap Map<String, String> options);

}
