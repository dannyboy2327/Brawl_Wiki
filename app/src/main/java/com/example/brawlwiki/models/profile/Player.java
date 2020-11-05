package com.example.brawlwiki.models.profile;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "player")
public class Player implements Serializable {

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
    private PlayerIcon playerIcon;

    @ColumnInfo
    @SerializedName("trophies")
    @Expose
    private Integer trophies;

    @ColumnInfo
    @SerializedName("highestTrophies")
    @Expose
    private Integer highestTrophies;

    @ColumnInfo
    @SerializedName("powerPlayPoints")
    @Expose
    private Integer powerPlayPoints;

    @ColumnInfo
    @SerializedName("highestPowerPlayPoints")
    @Expose
    private Integer highestPowerPlayPoints;

    @ColumnInfo
    @SerializedName("expLevel")
    @Expose
    private Integer expLevel;

    @ColumnInfo
    @SerializedName("expPoints")
    @Expose
    private Integer expPoints;

    @ColumnInfo
    @SerializedName("isQualifiedFromChampionshipChallenge")
    @Expose
    private Boolean isQualifiedFromChampionshipChallenge;

    @ColumnInfo
    @SerializedName("3vs3Victories")
    @Expose
    private Integer _3vs3Victories;

    @ColumnInfo
    @SerializedName("soloVictories")
    @Expose
    private Integer soloVictories;

    @ColumnInfo
    @SerializedName("duoVictories")
    @Expose
    private Integer duoVictories;

    @ColumnInfo
    @SerializedName("bestRoboRumbleTime")
    @Expose
    private Integer bestRoboRumbleTime;

    @ColumnInfo
    @SerializedName("bestTimeAsBigBrawler")
    @Expose
    private Integer bestTimeAsBigBrawler;

    @ColumnInfo
    @SerializedName("club")
    @Expose
    private PlayerClub playerClub;

    @ColumnInfo
    @SerializedName("brawlers")
    @Expose
    private List<BrawlerStat> brawlerStatList = null;

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

    public PlayerIcon getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(PlayerIcon playerIcon) {
        this.playerIcon = playerIcon;
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

    public Integer getPowerPlayPoints() {
        return powerPlayPoints;
    }

    public void setPowerPlayPoints(Integer powerPlayPoints) {
        this.powerPlayPoints = powerPlayPoints;
    }

    public Integer getHighestPowerPlayPoints() {
        return highestPowerPlayPoints;
    }

    public void setHighestPowerPlayPoints(Integer highestPowerPlayPoints) {
        this.highestPowerPlayPoints = highestPowerPlayPoints;
    }

    public Integer getExpLevel() {
        return expLevel;
    }

    public void setExpLevel(Integer expLevel) {
        this.expLevel = expLevel;
    }

    public Integer getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(Integer expPoints) {
        this.expPoints = expPoints;
    }

    public Boolean getIsQualifiedFromChampionshipChallenge() {
        return isQualifiedFromChampionshipChallenge;
    }

    public void setIsQualifiedFromChampionshipChallenge(Boolean isQualifiedFromChampionshipChallenge) {
        this.isQualifiedFromChampionshipChallenge = isQualifiedFromChampionshipChallenge;
    }

    public Integer get3vs3Victories() {
        return _3vs3Victories;
    }

    public void set3vs3Victories(Integer _3vs3Victories) {
        this._3vs3Victories = _3vs3Victories;
    }

    public Integer getSoloVictories() {
        return soloVictories;
    }

    public void setSoloVictories(Integer soloVictories) {
        this.soloVictories = soloVictories;
    }

    public Integer getDuoVictories() {
        return duoVictories;
    }

    public void setDuoVictories(Integer duoVictories) {
        this.duoVictories = duoVictories;
    }

    public Integer getBestRoboRumbleTime() {
        return bestRoboRumbleTime;
    }

    public void setBestRoboRumbleTime(Integer bestRoboRumbleTime) {
        this.bestRoboRumbleTime = bestRoboRumbleTime;
    }

    public Integer getBestTimeAsBigBrawler() {
        return bestTimeAsBigBrawler;
    }

    public void setBestTimeAsBigBrawler(Integer bestTimeAsBigBrawler) {
        this.bestTimeAsBigBrawler = bestTimeAsBigBrawler;
    }

    public PlayerClub getPlayerClub() {
        return playerClub;
    }

    public void setPlayerClub(PlayerClub playerClub) {
        this.playerClub = playerClub;
    }

    public List<BrawlerStat> getBrawlerStatList() {
        return brawlerStatList;
    }

    public void setBrawlerStatList(List<BrawlerStat> brawlerStatList) {
        this.brawlerStatList = brawlerStatList;
    }
}
