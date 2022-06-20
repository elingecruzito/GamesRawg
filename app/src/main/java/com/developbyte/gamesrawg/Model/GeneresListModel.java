package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneresListModel {

    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<Results> results;

    public int getCount() {
        return count;
    }

    public List<Results> getResults() {
        return results;
    }

    public class Results{

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("image_background")
        private String imageBackground;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImageBackground() {
            return imageBackground;
        }
    }

}
