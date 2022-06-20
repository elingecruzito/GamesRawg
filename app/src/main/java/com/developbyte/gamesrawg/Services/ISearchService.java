package com.developbyte.gamesrawg.Services;

import com.developbyte.gamesrawg.Model.GamesListModel;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ISearchService {

    @GET("games")
    Call<GamesListModel> getSearchListGames(@QueryMap Map<String, String> options);

}
