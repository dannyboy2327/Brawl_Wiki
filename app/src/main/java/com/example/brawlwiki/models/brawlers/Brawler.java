package com.example.brawlwiki.models.brawlers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Brawler implements Serializable {

    @SerializedName("mItemBrawlers")
    @Expose
    private List<ItemBrawler> mItemBrawlers = null;
    @SerializedName("mPagingBrawler")
    @Expose
    private PagingBrawler mPagingBrawler;
    private final static long serialVersionUID = 6604053561495373878L;

    public List<ItemBrawler> getItemBrawlers() {
        return mItemBrawlers;
    }

    public void setItemBrawlers(List<ItemBrawler> itemBrawlers) {
        this.mItemBrawlers = itemBrawlers;
    }

    public PagingBrawler getPagingBrawler() {
        return mPagingBrawler;
    }

    public void setPagingBrawler(PagingBrawler pagingBrawler) {
        this.mPagingBrawler = pagingBrawler;
    }
}
