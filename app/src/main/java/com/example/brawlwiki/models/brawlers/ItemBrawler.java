package com.example.brawlwiki.models.brawlers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ItemBrawler implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mStarPowerBrawlers")
    @Expose
    private List<StarPowerBrawler> mStarPowerBrawlers = null;
    @SerializedName("mGadgetBrawlers")
    @Expose
    private List<GadgetBrawler> mGadgetBrawlers = null;
    private final static long serialVersionUID = 4034051542296479105L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StarPowerBrawler> getStarPowerBrawlers() {
        return mStarPowerBrawlers;
    }

    public void setStarPowerBrawlers(List<StarPowerBrawler> starPowerBrawlers) {
        this.mStarPowerBrawlers = starPowerBrawlers;
    }

    public List<GadgetBrawler> getGadgetBrawlers() {
        return mGadgetBrawlers;
    }

    public void setGadgetBrawlers(List<GadgetBrawler> gadgetBrawlers) {
        this.mGadgetBrawlers = gadgetBrawlers;
    }
}
