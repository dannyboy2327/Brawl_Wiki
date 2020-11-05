package com.example.brawlwiki.models.playerranking;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "player_ranking")
public class PlayerRanking implements Serializable {

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
    @SerializedName("nameColor")
    @Expose
    private String nameColor;

    @ColumnInfo
    @SerializedName("icon")
    @Expose
    private PlayerRankingIcon playerRankingIcon;

    @ColumnInfo()
    @SerializedName("trophies")
    @Expose
    private Integer trophies;

    @ColumnInfo
    @SerializedName("rank")
    @Expose
    private Integer rank;

    @ColumnInfo
    @SerializedName("club")
    @Expose
    private PlayerRankingClub playerRankingClub;

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

    public PlayerRankingIcon getPlayerRankingIcon() {
        return playerRankingIcon;
    }

    public void setPlayerRankingIcon(PlayerRankingIcon playerRankingIcon) {
        this.playerRankingIcon = playerRankingIcon;
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

    public PlayerRankingClub getPlayerRankingClub() {
        return playerRankingClub;
    }

    public void setPlayerRankingClub(PlayerRankingClub playerRankingClub) {
        this.playerRankingClub = playerRankingClub;
    }
}
