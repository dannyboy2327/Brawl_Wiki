package com.example.brawlwiki.models.clubRanking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ItemClub implements Serializable {

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("badgeId")
    @Expose
    private Integer badgeId;
    @SerializedName("trophies")
    @Expose
    private Integer trophies;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("memberCount")
    @Expose
    private Integer memberCount;
    private final static long serialVersionUID = 3800509838070575829L;

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

    public Integer getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Integer badgeId) {
        this.badgeId = badgeId;
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

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }
}
