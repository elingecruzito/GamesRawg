package com.developbyte.gamesrawg.Services;

import android.util.Log;
import android.widget.Toast;

import com.developbyte.gamesrawg.Abstract.AbstractService;
import com.developbyte.gamesrawg.Home.IHome;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Model.GeneresListModel;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeService extends AbstractService implements IHome.IHomeInformationHandler {

    private IHome.IHomeInformationDelegate iHomeInformationDelegate;
    private RetrofitResponse retrofitResponse;
    private IHomeService cuentaService;
    private Map<String, String> data = new HashMap<>();

    public void setiHomeInformationDelegate(IHome.IHomeInformationDelegate iHomeInformationDelegate) {
        this.iHomeInformationDelegate = iHomeInformationDelegate;
    }

    public void setCuentaService(RetrofitResponse retrofitResponse) {
        this.retrofitResponse = retrofitResponse;
        cuentaService = retrofitResponse.createRetroFit(RetrofitResponse.BASE_URL).create(IHomeService.class);
    }

    @Override
    public void getAllGeneres() {
        data.put(RetrofitResponse.LABEL_KEY, RetrofitResponse.VALUE_KEY);

        Call<GeneresListModel> generesListModelCall = cuentaService.getGeneresList(data);
        generesListModelCall.enqueue(new Callback<GeneresListModel>() {
            @Override
            public void onResponse(Call<GeneresListModel> call, Response<GeneresListModel> response) {
                iHomeInformationDelegate.setAllGeneres(response.body());
            }

            @Override
            public void onFailure(Call<GeneresListModel> call, Throwable t) {
                retrofitResponse.loadError(t);
            }
        });
        data.clear();
    }

    @Override
    public void getRecomendateGames() {
        data.put(RetrofitResponse.LABEL_KEY, RetrofitResponse.VALUE_KEY);
        data.put("ordering", "-released");
        data.put("metacritic", "80,100");

        Call<GamesListModel> gamesListModelCall = cuentaService.getGameList(data);
        gamesListModelCall.enqueue(new Callback<GamesListModel>() {
            @Override
            public void onResponse(Call<GamesListModel> call, Response<GamesListModel> response) {
                iHomeInformationDelegate.setRecomendateGames(response.body());
            }

            @Override
            public void onFailure(Call<GamesListModel> call, Throwable t) {
                retrofitResponse.loadError(t);
            }
        });
        data.clear();
    }

    @Override
    public void getNewGames() {
        data.put(RetrofitResponse.LABEL_KEY, RetrofitResponse.VALUE_KEY);
        data.put("ordering", "-created");

        Call<GamesListModel> gamesListModelCall = cuentaService.getNewGameList(data);
        gamesListModelCall.enqueue(new Callback<GamesListModel>() {
            @Override
            public void onResponse(Call<GamesListModel> call, Response<GamesListModel> response) {
                iHomeInformationDelegate.setNewGames(response.body());
            }

            @Override
            public void onFailure(Call<GamesListModel> call, Throwable t) {
                retrofitResponse.loadError(t);
            }
        });

        data.clear();
    }

}
