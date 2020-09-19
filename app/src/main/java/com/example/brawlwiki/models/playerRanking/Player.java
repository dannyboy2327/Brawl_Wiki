package com.example.brawlwiki.models.playerRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

    @SerializedName("mItemPlayers")
    @Expose
    private List<ItemPlayer> mItemPlayers = null;
    @SerializedName("mPagingPlayer")
    @Expose
    private PagingPlayer mPagingPlayer;
    private final static long serialVersionUID = -635590497707102339L;

    public List<ItemPlayer> getItemPlayers() {
        return mItemPlayers;
    }

    public void setItemPlayers(List<ItemPlayer> itemPlayers) {
        this.mItemPlayers = itemPlayers;
    }

    public PagingPlayer getPagingPlayer() {
        return mPagingPlayer;
    }

    public void setPagingPlayer(PagingPlayer pagingPlayer) {
        this.mPagingPlayer = pagingPlayer;
    }
}
