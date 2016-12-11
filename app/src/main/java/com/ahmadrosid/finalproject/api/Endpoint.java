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

    public static final String DISCOVER = URL + "discover/movie" + API_KEY;

}
