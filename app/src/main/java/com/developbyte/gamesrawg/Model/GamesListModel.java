package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GamesListModel {
    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<GameModel> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GameModel> getResults() {
        return results;
    }

    public void setResults(List<GameModel> results) {
        this.results = results;
    }




}
