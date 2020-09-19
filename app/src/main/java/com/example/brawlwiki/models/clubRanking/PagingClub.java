package com.example.brawlwiki.models.clubRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PagingClub implements Serializable {

    @SerializedName("mCursorsClub")
    @Expose
    private CursorsClub mCursorsClub;
    private final static long serialVersionUID = 3846421576495772418L;

    public CursorsClub getCursorsClub() {
        return mCursorsClub;
    }

    public void setCursorsClub(CursorsClub cursorsClub) {
        this.mCursorsClub = cursorsClub;
    }
}
