package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class GenresModel {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image_background")
    private String image_background;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage_background() {
        return image_background;
    }
}
