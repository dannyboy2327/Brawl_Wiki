package com.example.brawlwiki.models.clubranking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ClubMemberList implements Serializable {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
