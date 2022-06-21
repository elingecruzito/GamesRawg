package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfoGameModel {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("name_original")
    private String name_original;
    @SerializedName("metacritic")
    private int metacritic;
    @SerializedName("metacritic_platforms")
    private List<MetacriticModel> metacritic_plataforms;
    @SerializedName("released")
    private String released;
    @SerializedName("background_image")
    private String background_image;
    @SerializedName("background_image_additional")
    private String background_image_additional;
    @SerializedName("website")
    private String website;
    @SerializedName("metacritic_url")
    private String metacritic_url;
    @SerializedName("platforms")
    private List<PlataformsModel> plataforms;
    @SerializedName("stores")
    private List<StoresModel> stores;
    @SerializedName("developers")
    private List<DeveloperModel> developers;
    @SerializedName("genres")
    private List<GenresModel> genres;
    @SerializedName("tags")
    private List<TagsModel> tags;
    @SerializedName("publishers")
    private List<PublishersModel> publishers;
    @SerializedName("description_raw")
    private String description_raw;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getName_original() {
        return name_original;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public List<MetacriticModel> getMetacritic_plataforms() {
        return metacritic_plataforms;
    }

    public String getReleased() {
        return released;
    }

    public String getBackground_image() {
        return background_image;
    }

    public String getBackground_image_additional() {
        return background_image_additional;
    }

    public String getWebsite() {
        return website;
    }

    public String getMetacritic_url() {
        return metacritic_url;
    }

    public List<PlataformsModel> getPlataforms() {
        return plataforms;
    }

    public List<StoresModel> getStores() {
        return stores;
    }

    public List<DeveloperModel> getDevelopers() {
        return developers;
    }

    public List<GenresModel> getGenres() {
        return genres;
    }

    public List<TagsModel> getTags() {
        return tags;
    }

    public List<PublishersModel> getPublishers() {
        return publishers;
    }

    public String getDescription_raw() {
        return description_raw;
    }
}
