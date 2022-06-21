package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class TagsModel {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("language")
    private String language;
    @SerializedName("image_background")
    private String image_background;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getImage_background() {
        return image_background;
    }
}
