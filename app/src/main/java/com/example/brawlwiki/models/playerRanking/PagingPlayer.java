package com.example.brawlwiki.models.playerRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PagingPlayer implements Serializable {

    @SerializedName("mCursorsPlayer")
    @Expose
    private CursorsPlayer mCursorsPlayer;
    private final static long serialVersionUID = 3846421576495772418L;

    public CursorsPlayer getCursorsPlayer() {
        return mCursorsPlayer;
    }

    public void setCursorsPlayer(CursorsPlayer cursorsPlayer) {
        this.mCursorsPlayer = cursorsPlayer;
    }
}
