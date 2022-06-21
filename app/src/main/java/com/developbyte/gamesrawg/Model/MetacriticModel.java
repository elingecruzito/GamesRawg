package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class MetacriticModel {

    @SerializedName("metascore")
    private int metascore;
    @SerializedName("url")
    private String url;
    @SerializedName("platform")
    private PlataformModel plataform;

    public int getMetascore() {
        return metascore;
    }

    public String getUrl() {
        return url;
    }

    public PlataformModel getPlataform() {
        return plataform;
    }
}
