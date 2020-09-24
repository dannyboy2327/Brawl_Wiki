package com.example.brawlwiki.models.players;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameColor")
    @Expose
    private String nameColor;
    @SerializedName("icon")
    @Expose
    private Icon icon;
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
    @SerializedName("club")
    @Expose
    private Club club;
    @SerializedName("brawlers")
    @Expose
    private List<Brawler> brawlers = null;

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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Brawler> getBrawlers() {
        return brawlers;
    }

    public void setBrawlers(List<Brawler> brawlers) {
        this.brawlers = brawlers;
    }
}
