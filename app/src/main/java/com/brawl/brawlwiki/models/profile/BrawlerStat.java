package com.brawl.brawlwiki.models.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BrawlerStat implements Serializable {

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
    @SerializedName("starPowers")
    @Expose
    private List<BrawlerStatStarPower> brawlerStatStarPowerList = null;
    @SerializedName("gadgets")
    @Expose
    private List<BrawlerStatGadget> brawlerStatGadgetList = null;

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

    public List<BrawlerStatStarPower> getBrawlerStatStarPowerList() {
        return brawlerStatStarPowerList;
    }

    public void setBrawlerStatStarPowerList(List<BrawlerStatStarPower> brawlerStatStarPowerList) {
        this.brawlerStatStarPowerList = brawlerStatStarPowerList;
    }

    public List<BrawlerStatGadget> getBrawlerStatGadgetList() {
        return brawlerStatGadgetList;
    }

    public void setBrawlerStatGadgetList(List<BrawlerStatGadget> brawlerStatGadgetList) {
        this.brawlerStatGadgetList = brawlerStatGadgetList;
    }
}
