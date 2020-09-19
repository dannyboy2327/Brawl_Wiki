package com.example.brawlwiki.models.playerRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class IconPlayer implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    private final static long serialVersionUID = -2015030168435806739L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
