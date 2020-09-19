package com.example.brawlwiki.models.playerRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClubPlayer implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 1079533795749621023L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
