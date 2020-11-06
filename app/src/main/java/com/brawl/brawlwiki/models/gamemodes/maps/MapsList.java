package com.brawl.brawlwiki.models.gamemodes.maps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MapsList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("list")
    @Expose
    private List<Maps> mMaps = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Maps> getList() {
        return mMaps;
    }

    public void setList(List<Maps> maps) {
        this.mMaps = maps;
    }

}
