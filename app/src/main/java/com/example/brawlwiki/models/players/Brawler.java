package com.example.brawlwiki.models.players;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Brawler implements Serializable {

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
    private List<StarPower> starPowers = null;
    @SerializedName("gadgets")
    @Expose
    private List<Gadget> gadgets = null;

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

    public List<StarPower> getStarPowers() {
        return starPowers;
    }

    public void setStarPowers(List<StarPower> starPowers) {
        this.starPowers = starPowers;
    }

    public List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }
}
