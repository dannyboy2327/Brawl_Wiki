package com.example.brawlwiki.models.playerRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ItemPlayer implements Serializable {

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameColor")
    @Expose
    private String nameColor;
    @SerializedName("mIconPlayer")
    @Expose
    private IconPlayer mIconPlayer;
    @SerializedName("trophies")
    @Expose
    private Integer trophies;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("mClubPlayer")
    @Expose
    private ClubPlayer mClubPlayer;

    private final static long serialVersionUID = -5472202228838775397L;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    public IconPlayer getIconPlayer() {
        return mIconPlayer;
    }

    public void setIconPlayer(IconPlayer iconPlayer) {
        this.mIconPlayer = iconPlayer;
    }

    public Integer getTrophies() {
        return trophies;
    }

    public void setTrophies(Integer trophies) {
        this.trophies = trophies;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public ClubPlayer getClubPlayer() {
        return mClubPlayer;
    }

    public void setClubPlayer(ClubPlayer clubPlayer) {
        this.mClubPlayer = clubPlayer;
    }
}
