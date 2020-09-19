package com.example.brawlwiki.models.clubRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Club implements Serializable {

    @SerializedName("mItemClubs")
    @Expose
    private List<ItemClub> mItemClubs = null;
    @SerializedName("mPagingClub")
    @Expose
    private PagingClub mPagingClub;
    private final static long serialVersionUID = -5616068172068972473L;

    public List<ItemClub> getItemClubs() {
        return mItemClubs;
    }

    public void setItemClubs(List<ItemClub> itemClubs) {
        this.mItemClubs = itemClubs;
    }

    public PagingClub getPagingClub() {
        return mPagingClub;
    }

    public void setPagingClub(PagingClub pagingClub) {
        this.mPagingClub = pagingClub;
    }
}
