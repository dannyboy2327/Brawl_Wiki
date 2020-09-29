package com.example.brawlwiki.network;

import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.gamemodes.GamesModeList;
import com.example.brawlwiki.models.gamemodes.maps.MapsList;
import com.example.brawlwiki.models.playerranking.PlayerRankingList;
import com.example.brawlwiki.models.players.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BrawlStarsApi {

    //Get request for players personal in game data
    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })
    @GET("v1/players/%23G8U29RL")
    Call<Player> getPlayer();

    //Get request for a list of top clubs and their ranks
    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })
    @GET("v1/rankings/global/players?limit=100")
    Call<ClubMemberList> getClubList();

    //Get request for a list of top players and their ranks
    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })
    @GET("v1/rankings/global/players?limit=100")
    Call<PlayerRankingList> getTopPlayerList();

    //Get request for all Game Modes in game
    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })
    @GET("api/gamemodes.json")
    Call<GamesModeList> getGameModes();

    //Get request for all Maps in game
    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })
    @GET("api/maps.json")
    Call<MapsList> getMaps();

    //Get request for all brawlers in game
    @Headers({
            "Accept: application/json",
            "authorization: Bearer " + ApiClient.API_KEY
    })
    @GET("api/brawlers.json")
    Call<BrawlerList> getBrawlers();
}
