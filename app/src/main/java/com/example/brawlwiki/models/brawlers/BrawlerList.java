package com.example.brawlwiki.models.brawlers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BrawlerList implements Serializable {

    @SerializedName("items")
    @Expose
    private List<Brawler> mBrawlerList = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<Brawler> getBrawlerList() {
        return mBrawlerList;
    }

    public void setBrawlerList(List<Brawler> brawlerList) {
        mBrawlerList = brawlerList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
