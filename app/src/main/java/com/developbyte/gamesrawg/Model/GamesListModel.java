package com.developbyte.gamesrawg.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GamesListModel {
    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<Games> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Games> getResults() {
        return results;
    }

    public void setResults(List<Games> results) {
        this.results = results;
    }

    public class Games{
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("released")
        private String released;
        @SerializedName("background_image")
        private String background_image;
        @SerializedName("rating")
        private Number rating;
        @SerializedName("rating_top")
        private int rating_top;
        @SerializedName("ratings_count")
        private int ratings_count;
        @SerializedName("platforms")
        private List<Platforms> platforms;
        @SerializedName("genres")
        private List<Genres> genres;
        @SerializedName("metacritic")
        private int metacritic;

        private String aux;


        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getReleased() {
            return released;
        }

        public String getBackground_image() {
            return background_image;
        }

        public Number getRating() {
            return rating;
        }

        public int getRating_top() {
            return rating_top;
        }

        public int getRatings_count() {
            return ratings_count;
        }

        public String getPlatforms() {
            aux = "";

            for (int i = 0; i < platforms.size(); i++){
                aux += platforms.get(i).getPlatform().getName();
                if( i < platforms.size() - 1){
                    aux += ", ";
                }
            }

            return aux;
        }

        public int getMetacritic() {
            return metacritic;
        }

        public String getGenres() {
            aux = "";
            for(int i = 0; i < genres.size(); i++){
                aux += genres.get(i).name + " ";
            }
            return aux;
        }

        public class Platforms{

            @SerializedName("platform")
            private Platform platform;

            public Platform getPlatform() {
                return platform;
            }

            public class Platform {
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
        }

        public class Genres{
            @SerializedName("id")
            private int id;

            @SerializedName("name")
            private String name;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }


}
