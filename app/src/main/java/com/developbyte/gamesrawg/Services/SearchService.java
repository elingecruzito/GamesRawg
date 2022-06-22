package com.developbyte.gamesrawg.Services;

import com.developbyte.gamesrawg.Abstract.AbstractService;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Search.ISearch;
import com.developbyte.gamesrawg.Services.Interfaces.ISearchService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchService extends AbstractService implements ISearch.ISearchInformationHandler {

    private ISearch.ISearchInformationDelegate iSearchInformationDelegate;
    private RetrofitResponse retrofitResponse;
    private ISearchService cuentaService;
    private Map<String, String> data = new HashMap<>();

    public void setiSearchInformationDelegate(ISearch.ISearchInformationDelegate iSearchInformationDelegate) {
        this.iSearchInformationDelegate = iSearchInformationDelegate;
    }

    public void setCuentaService(RetrofitResponse retrofitResponse) {
        this.retrofitResponse = retrofitResponse;
        cuentaService = retrofitResponse.createRetroFit(RetrofitResponse.BASE_URL).create(ISearchService.class);
    }

    @Override
    public void searchGames(String query) {
        data.put(RetrofitResponse.LABEL_KEY, RetrofitResponse.VALUE_KEY);
        data.put("search", query);
        Call<GamesListModel> gamesListModelCall = cuentaService.getSearchListGames(data);
        gamesListModelCall.enqueue(new Callback<GamesListModel>() {
            @Override
            public void onResponse(Call<GamesListModel> call, Response<GamesListModel> response) {
                iSearchInformationDelegate.setSeachListGames(response.body());
            }

            @Override
            public void onFailure(Call<GamesListModel> call, Throwable t) {
                retrofitResponse.loadError(t);
            }
        });
        data.clear();
    }
}
