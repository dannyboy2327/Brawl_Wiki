package com.example.brawlwiki.models.playerranking;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "player")
public class PlayerItem implements Serializable {

    @NonNull
    @PrimaryKey
    @SerializedName("tag")
    @Expose
    private String tag;

    @ColumnInfo
    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("nameColor")
    @Expose
    private String nameColor;

    @Ignore
    @SerializedName("icon")
    @Expose
    private Icon icon;

    @ColumnInfo()
    @SerializedName("trophies")
    @Expose
    private Integer trophies;

    @ColumnInfo
    @SerializedName("rank")
    @Expose
    private Integer rank;

    @Ignore
    @SerializedName("club")
    @Expose
    private Club club;

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

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}