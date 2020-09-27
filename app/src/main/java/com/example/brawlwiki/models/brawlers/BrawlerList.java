package com.example.brawlwiki.models.brawlers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BrawlerList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("list")
    @Expose
    private List<Brawler> mBrawlerList = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Brawler> getBrawlerList() {
        return mBrawlerList;
    }

    public void set(List<Brawler> brawlerList) {
        this.mBrawlerList = brawlerList;
    }

}
