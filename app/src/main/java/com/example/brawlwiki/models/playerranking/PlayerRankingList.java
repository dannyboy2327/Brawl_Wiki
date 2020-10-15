package com.example.brawlwiki.models.playerranking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PlayerRankingList implements Serializable {

    @SerializedName("items")
    @Expose
    private List<PlayerItem> playerItems = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<PlayerItem> getPlayerItems() {
        return playerItems;
    }

    public void setPlayerItems(List<PlayerItem> playerItems) {
        this.playerItems = playerItems;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
