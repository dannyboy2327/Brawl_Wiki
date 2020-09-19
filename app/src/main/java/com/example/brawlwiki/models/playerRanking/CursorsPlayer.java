package com.example.brawlwiki.models.playerRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CursorsPlayer implements Serializable {

    @SerializedName("after")
    @Expose
    private String after;
    private final static long serialVersionUID = 7174950584080477436L;

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
