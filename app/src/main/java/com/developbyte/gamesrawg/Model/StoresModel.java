package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class StoresModel {

    @SerializedName("id")
    private int id;
    @SerializedName("url")
    private String url;
    @SerializedName("store")
    private StoreModel store;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public StoreModel getStore() {
        return store;
    }
}
