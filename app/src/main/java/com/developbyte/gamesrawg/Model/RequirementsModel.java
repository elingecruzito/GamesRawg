package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class RequirementsModel {

    @SerializedName("minimum")
    private String minimum;
    @SerializedName("recommended")
    private String recommended;

    public String getMinimum() {
        return minimum;
    }

    public String getRecommended() {
        return recommended;
    }
}
