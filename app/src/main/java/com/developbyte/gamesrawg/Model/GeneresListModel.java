package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneresListModel {

    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<GenresModel> results;

    public int getCount() {
        return count;
    }

    public List<GenresModel> getResults() {
        return results;
    }

}
