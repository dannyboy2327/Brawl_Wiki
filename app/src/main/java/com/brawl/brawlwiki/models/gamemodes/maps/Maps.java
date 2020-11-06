package com.brawl.brawlwiki.models.gamemodes.maps;

import com.brawl.brawlwiki.models.gamemodes.GameMode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Maps implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("new")
    @Expose
    private Boolean _new;
    @SerializedName("disabled")
    @Expose
    private Boolean disabled;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("credit")
    @Expose
    private Object credit;
    @SerializedName("environment")
    @Expose
    private Environment environment;
    @SerializedName("gameMode")
    @Expose
    private GameMode gameMode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getNew() {
        return _new;
    }

    public void setNew(Boolean _new) {
        this._new = _new;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getCredit() {
        return credit;
    }

    public void setCredit(Object credit) {
        this.credit = credit;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
}
