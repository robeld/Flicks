package com.codepath.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by robeld on 6/22/17.
 */

public class Config {
    //the base url for loading images
    String imageBaseUrl;
    //the poster size to use when fetching images, to be appended to url;
    String posterSize;
    //backdrop size to use when fetching images
    String backdropSize;

    public Config(JSONObject object) throws JSONException {
        //images JSON object for configuration
        JSONObject images = object.getJSONObject("images");
        //get the image base url
        imageBaseUrl = images.getString("secure_base_url");
        //get poster size array
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        //get poster size we want, w342 if it doesn't work
        posterSize = posterSizeOptions.optString(3, "w342");
        //parse backdrop size, w780 as fallback
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    //helper method for creating urls
    public String getImageUrl(String size, String path){
        return String.format("%s%s%s", imageBaseUrl, size, path); //concatenate all three
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}
