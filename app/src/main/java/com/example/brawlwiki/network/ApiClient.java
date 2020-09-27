package com.example.brawlwiki.network;

import com.example.brawlwiki.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsIm" +
            "tpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3Mi" +
            "OiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjllOTE" +
            "2ZjhmLTcyMTUtNGJjMC04ODJiLWQ4MGRlYWQzYmZlOSIsImlhdCI6MTYwMDU3MTg4OS" +
            "wic3ViIjoiZGV2ZWxvcGVyL2VjZDA3MzhhLTI4M2UtNTNlNS0xZWVhLTU0ODE0YmY3Y" +
            "WFjOSIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRl" +
            "dmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiNzI" +
            "uMTM0LjE5OS4xMzgiXSwidHlwZSI6ImNsaWVudCJ9XX0.1mOkoNtbw_R3QNGE_LWzBM" +
            "plrGOuof4e4e14ccYWEvWdlZPHlOkmMFvT1wS5nkUJO6t6elgTZ4YdbqMe6YZOJw";

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
