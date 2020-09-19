package com.example.brawlwiki.models.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Stats implements Serializable {

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameColor")
    @Expose
    private String nameColor;
    @SerializedName("mIconStats")
    @Expose
    private IconStats mIconStats;
    @SerializedName("trophies")
    @Expose
    private Integer trophies;
    @SerializedName("highestTrophies")
    @Expose
    private Integer highestTrophies;
    @SerializedName("powerPlayPoints")
    @Expose
    private Integer powerPlayPoints;
    @SerializedName("highestPowerPlayPoints")
    @Expose
    private Integer highestPowerPlayPoints;
    @SerializedName("expLevel")
    @Expose
    private Integer expLevel;
    @SerializedName("expPoints")
    @Expose
    private Integer expPoints;
    @SerializedName("isQualifiedFromChampionshipChallenge")
    @Expose
    private Boolean isQualifiedFromChampionshipChallenge;
    @SerializedName("3vs3Victories")
    @Expose
    private Integer _3vs3Victories;
    @SerializedName("soloVictories")
    @Expose
    private Integer soloVictories;
    @SerializedName("duoVictories")
    @Expose
    private Integer duoVictories;
    @SerializedName("bestRoboRumbleTime")
    @Expose
    private Integer bestRoboRumbleTime;
    @SerializedName("bestTimeAsBigBrawler")
    @Expose
    private Integer bestTimeAsBigBrawler;
    @SerializedName("mClubStats")
    @Expose
    private ClubStats mClubStats;
    @SerializedName("mBrawlerStats")
    @Expose
    private List<BrawlerStats> mBrawlerStats = null;
    private final static long serialVersionUID = 8624222593677302755L;

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

    public IconStats getIconStats() {
        return mIconStats;
    }

    public void setIconStats(IconStats iconStats) {
        this.mIconStats = iconStats;
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

    public ClubStats getClubStats() {
        return mClubStats;
    }

    public void setClubStats(ClubStats clubStats) {
        this.mClubStats = clubStats;
    }

    public List<BrawlerStats> getBrawlerStats() {
        return mBrawlerStats;
    }

    public void setBrawlerStats(List<BrawlerStats> brawlerStats) {
        this.mBrawlerStats = brawlerStats;
    }
}
