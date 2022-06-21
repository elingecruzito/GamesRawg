package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class PlataformModel {

    @SerializedName("id")
    private int id;
    @SerializedName("platform")
    private int platform;
    @SerializedName("name")
    private String name;
    @SerializedName("image_background")
    private String image_background;

    public int getId() {
        return id;
    }

    public int getPlatform() {
        return platform;
    }

    public String getName() {
        return name;
    }

    public String getImage_background() {
        return image_background;
    }
}
