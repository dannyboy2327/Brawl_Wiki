package com.example.brawlwiki.models.maps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MapList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("list")
    @Expose
    private List<Map> mMapList = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Map> getList() {
        return mMapList;
    }

    public void setList(List<Map> mapList) {
        this.mMapList = mapList;
    }
}
