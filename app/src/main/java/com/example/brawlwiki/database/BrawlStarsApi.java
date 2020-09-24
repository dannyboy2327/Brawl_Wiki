package com.example.brawlwiki.database;

import com.example.brawlwiki.models.clubranking.ClubRankingList;
import com.example.brawlwiki.models.players.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BrawlStarsApi {

    @Headers({
            "Accept: application/json",
            "authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOi" +
                    "JIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYT" +
                    "FlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiO" +
                    "iJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z" +
                    "2FtZWFwaSIsImp0aSI6IjllOTE2ZjhmLTcyMTUtN" +
                    "GJjMC04ODJiLWQ4MGRlYWQzYmZlOSIsImlhdCI6M" +
                    "TYwMDU3MTg4OSwic3ViIjoiZGV2ZWxvcGVyL2VjZ" +
                    "DA3MzhhLTI4M2UtNTNlNS0xZWVhLTU0ODE0YmY3Y" +
                    "WFjOSIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sI" +
                    "mxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9za" +
                    "Wx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY" +
                    "2lkcnMiOlsiNzIuMTM0LjE5OS4xMzgiXSwidHlwZ" +
                    "SI6ImNsaWVudCJ9XX0.1mOkoNtbw_R3QNGE_LWzB" +
                    "MplrGOuof4e4e14ccYWEvWdlZPHlOkmMFvT1wS5n" +
                    "kUJO6t6elgTZ4YdbqMe6YZOJw"
    })
    @GET("v1/players/%23G8U29RL")
    Call<Player> getPlayer();

    @GET("v1/rankings/global/players?limit=100")
    Call<ClubRankingList> getClubList();
}
