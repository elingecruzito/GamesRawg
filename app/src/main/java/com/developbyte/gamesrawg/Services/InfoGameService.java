package com.developbyte.gamesrawg.Services;

import com.developbyte.gamesrawg.Abstract.AbstractService;
import com.developbyte.gamesrawg.InfoGame.IInfoGame;
import com.developbyte.gamesrawg.Model.InfoGameModel;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoGameService extends AbstractService implements IInfoGame.IInfoGameInformationHandler{

    private IInfoGame.IInfoGameInformationDelegate iInfoGameInformationDelegate;
    private RetrofitResponse retrofitResponse;
    private IGameInfo cuentaService;
    private Map<String, String> data = new HashMap<>();

    public void setiInfoGameInformationDelegate(IInfoGame.IInfoGameInformationDelegate iInfoGameInformationDelegate) {
        this.iInfoGameInformationDelegate = iInfoGameInformationDelegate;
    }

    public void setCuentaService(RetrofitResponse retrofitResponse) {
        this.retrofitResponse = retrofitResponse;
        cuentaService = retrofitResponse.createRetroFit(RetrofitResponse.BASE_URL).create(IGameInfo.class);
    }

    @Override
    public void getInfoGame(int id) {
        data.put(RetrofitResponse.LABEL_KEY, RetrofitResponse.VALUE_KEY);

        Call<InfoGameModel> infoGameServiceCall = cuentaService.getGameList(id,data);
        infoGameServiceCall.enqueue(new Callback<InfoGameModel>() {
            @Override
            public void onResponse(Call<InfoGameModel> call, Response<InfoGameModel> response) {
                iInfoGameInformationDelegate.setInfoGame(response.body());
            }

            @Override
            public void onFailure(Call<InfoGameModel> call, Throwable t) {
                retrofitResponse.loadError(t);
            }
        });

        data.clear();
    }
}
