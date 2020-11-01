package com.example.brawlwiki.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BRAWL_STARS_BASE_URL = "https://api.brawlstars.com/";
    public static final String BRAWL_LIST_BASE_URL = "https://cdn.starlist.pro/";

    public static Retrofit getBrawlStarsClient() {
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BRAWL_STARS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getBrawlListClient() {
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BRAWL_LIST_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
