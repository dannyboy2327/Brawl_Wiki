package com.example.brawlwiki.network;

import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.maps.MapList;
import com.example.brawlwiki.models.players.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BrawlStarsApi {

    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })

    //Get request for players personal in game data
    @GET("v1/players/%23G8U29RL")
    Call<Player> getPlayer();

    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })

    @GET("v1/rankings/global/players?limit=100")
    Call<ClubMemberList> getClubList();

    //Get request for all Game Modes in game
    @GET("api/gamemodes.json")
    Call<MapList> getGameModes();

    //Get request for all brawlers in game
    @GET("api/brawlers.json")
    Call<BrawlerList> getBrawlers();
}
