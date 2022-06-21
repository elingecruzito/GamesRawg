package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

public class PlataformsModel {

    @SerializedName("platform")
    private PlataformModel plataform;

    @SerializedName("requirements")
    private RequirementsModel requirements;

    public PlataformModel getPlataform() {
        return plataform;
    }

    public RequirementsModel getRequirements() {
        return requirements;
    }
}
