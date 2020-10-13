package com.example.brawlwiki.models.clubranking;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "club")
public class Item implements Serializable {

    @NonNull
    @PrimaryKey
    @SerializedName("tag")
    @Expose
    private String tag;

    @ColumnInfo
    @SerializedName("name")
    @Expose
    private String name;

    @ColumnInfo
    @SerializedName("trophies")
    @Expose
    private Integer trophies;

    @ColumnInfo
    @SerializedName("rank")
    @Expose
    private Integer rank;

    @ColumnInfo
    @SerializedName("memberCount")
    @Expose
    private Integer memberCount;

    @ColumnInfo
    @SerializedName("badge")
    @Expose
    private Integer badgeId;

    public Item(@NonNull String tag, String name,  Integer trophies, Integer rank, Integer memberCount, Integer badgeId) {
        this.tag = tag;
        this.name = name;
        this.badgeId = badgeId;
        this.trophies = trophies;
        this.rank = rank;
        this.memberCount = memberCount;
    }

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
