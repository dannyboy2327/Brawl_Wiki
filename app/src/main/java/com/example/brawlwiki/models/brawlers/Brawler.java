package com.example.brawlwiki.models.brawlers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Brawler implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatarId")
    @Expose
    private Integer avatarId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("released")
    @Expose
    private Boolean released;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("imageUrl2")
    @Expose
    private String imageUrl2;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("unlock")
    @Expose
    private Integer unlock;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("starPowers")
    @Expose
    private java.util.List<StarPower> starPowers = null;
    @SerializedName("gadgets")
    @Expose
    private java.util.List<Gadget> gadgets = null;
    @SerializedName("videos")
    @Expose
    private java.util.List<Video> videos = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getReleased() {
        return released;
    }

    public void setReleased(Boolean released) {
        this.released = released;
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

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Integer getUnlock() {
        return unlock;
    }

    public void setUnlock(Integer unlock) {
        this.unlock = unlock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.List<StarPower> getStarPowers() {
        return starPowers;
    }

    public void setStarPowers(java.util.List<StarPower> starPowers) {
        this.starPowers = starPowers;
    }

    public java.util.List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(java.util.List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public java.util.List<Video> getVideos() {
        return videos;
    }

    public void setVideos(java.util.List<Video> videos) {
        this.videos = videos;
    }
}
