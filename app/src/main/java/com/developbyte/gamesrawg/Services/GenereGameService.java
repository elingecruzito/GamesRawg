package com.developbyte.gamesrawg.Services;

import com.developbyte.gamesrawg.Abstract.AbstractService;
import com.developbyte.gamesrawg.ListGames.IListGames;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Services.Interfaces.IGenereGame;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenereGameService extends AbstractService implements IListGames.IListGamesInformationHandler{

    private IListGames.IListGamesInformationDelegate iListGamesInformationDelegate;
    private RetrofitResponse retrofitResponse;
    private IGenereGame cuentaService;
    private Map<String, String> data = new HashMap<>();

    public void setiListGamesInformationDelegate(IListGames.IListGamesInformationDelegate iListGamesInformationDelegate) {
        this.iListGamesInformationDelegate = iListGamesInformationDelegate;
    }

    public void setCuentaService(RetrofitResponse retrofitResponse) {
        this.retrofitResponse = retrofitResponse;
        cuentaService = retrofitResponse.createRetroFit(RetrofitResponse.BASE_URL).create(IGenereGame.class);
    }

    @Override
    public void getGames(int id) {
        data.put(RetrofitResponse.LABEL_KEY, RetrofitResponse.VALUE_KEY);
        data.put("genres", id+"");

        Call<GamesListModel> gamesListModelCall = cuentaService.getGameList(data);
        gamesListModelCall.enqueue(new Callback<GamesListModel>() {
            @Override
            public void onResponse(Call<GamesListModel> call, Response<GamesListModel> response) {
                iListGamesInformationDelegate.setGames(response.body());
            }

            @Override
            public void onFailure(Call<GamesListModel> call, Throwable t) {
                retrofitResponse.loadError(t);
            }
        });
        data.clear();
    }
}
