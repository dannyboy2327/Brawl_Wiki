package com.brawl.brawlwiki.network;

import com.brawl.brawlwiki.models.brawlers.BrawlerList;
import com.brawl.brawlwiki.models.clubranking.ClubMemberList;
import com.brawl.brawlwiki.models.playerranking.PlayerRankingList;
import com.brawl.brawlwiki.models.profile.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface BrawlStarsApi {

    //Get request for players personal in game data
    @GET("v1/players/{tag}")
    Call<Player> getPlayer(
            @Header("authorization") String token,
            @Path("tag") String tag
    );

    //Get request for a list of top clubs and their ranks
    @GET("v1/rankings/global/clubs?before=eyJwb3MiOjEwMH0&limit=100")
    Call<ClubMemberList> getClubList(
            @Header("authorization") String token
    );

    //Get request for a list of top players and their ranks
    @GET("v1/rankings/global/players?before=eyJwb3MiOjEwMH0&limit=100")
    Call<PlayerRankingList> getTopPlayerList(
            @Header("authorization") String token
    );

    //Get request for all brawlers in game
    @GET("v1/brawlers")
    Call<BrawlerList> getBrawlers(
            @Header("authorization") String token
    );
}
