package com.brawl.brawlwiki.models.playerranking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PlayerRankingList implements Serializable {

    @SerializedName("items")
    @Expose
    private List<PlayerRanking> playerRankingList = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<PlayerRanking> getPlayerRankingList() {
        return playerRankingList;
    }

    public void setPlayerRankingList(List<PlayerRanking> playerRankingList) {
        this.playerRankingList = playerRankingList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
