package com.example.brawlwiki.models.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BrawlerStats implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("power")
    @Expose
    private Integer power;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("trophies")
    @Expose
    private Integer trophies;
    @SerializedName("highestTrophies")
    @Expose
    private Integer highestTrophies;
    @SerializedName("mStarPowerStats")
    @Expose
    private List<StarPowerStats> mStarPowerStats = null;
    @SerializedName("mGadgetStats")
    @Expose
    private List<GadgetStats> mGadgetStats = null;
    private final static long serialVersionUID = 3870019613409421714L;

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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getTrophies() {
        return trophies;
    }

    public void setTrophies(Integer trophies) {
        this.trophies = trophies;
    }

    public Integer getHighestTrophies() {
        return highestTrophies;
    }

    public void setHighestTrophies(Integer highestTrophies) {
        this.highestTrophies = highestTrophies;
    }

    public List<StarPowerStats> getStarPowerStats() {
        return mStarPowerStats;
    }

    public void setStarPowerStats(List<StarPowerStats> starPowerStats) {
        this.mStarPowerStats = starPowerStats;
    }

    public List<GadgetStats> getGadgetStats() {
        return mGadgetStats;
    }

    public void setGadgetStats(List<GadgetStats> gadgetStats) {
        this.mGadgetStats = gadgetStats;
    }
}
