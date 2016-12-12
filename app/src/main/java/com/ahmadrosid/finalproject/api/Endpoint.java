package com.ahmadrosid.finalproject.api;

import com.ahmadrosid.finalproject.BuildConfig;

/**
 * Created by ocittwo on 12/11/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class Endpoint {

    private static final String MAIN_URL = "https://api.themoviedb.org/";
    private static final String API_VERSION = "3/";
    private static final String API_KEY = "?api_key=" + BuildConfig.MOVIE_DB_API_KEY;
    private static final String URL = MAIN_URL + API_VERSION;

    private static final String SIZE_500 = "w500";
    private static final String SIZE_300 = "w300";
    private static final String MAIN_IMAGE_URL = "https://image.tmdb.org/t/p/";

    public static final String URL_IMAGE_500 = MAIN_IMAGE_URL + SIZE_500;
    public static final String DISCOVER = URL + "discover/movie" + API_KEY;

    public static final String VIDIO(String id) {
        return URL + "movie/" + id + "/videos" + API_KEY ;
    }

    public static final String URL_IMAGE_300 = MAIN_IMAGE_URL + SIZE_300;

}
