package com.example.brawlwiki.models.brawlers;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "brawler_table")
public class Brawler implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "brawler_id")
    @SerializedName("id")
    @Expose
    private Integer id;

    @Ignore
    @SerializedName("avatarId")
    @Expose
    private Integer avatarId;

    @ColumnInfo(name = "brawler_name")
    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("hash")
    @Expose
    private String hash;

    @Ignore
    @SerializedName("path")
    @Expose
    private String path;

    @Ignore
    @SerializedName("released")
    @Expose
    private Boolean released;

    @Ignore
    @SerializedName("version")
    @Expose
    private Integer version;

    @Ignore
    @SerializedName("link")
    @Expose
    private String link;

    @ColumnInfo(name = "brawler_url_one")
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @ColumnInfo(name = "brawler_url_2")
    @SerializedName("imageUrl2")
    @Expose
    private String imageUrl2;

    @ColumnInfo(name = "brawler_class")
    @SerializedName("class")
    @Expose
    private String _class;

    @ColumnInfo(name = "brawler_rarity")
    @SerializedName("rarity")
    @Expose
    private String rarity;

    @Ignore
    @SerializedName("unlock")
    @Expose
    private Integer unlock;

    @ColumnInfo(name = "brawler_description")
    @SerializedName("description")
    @Expose
    private String description;

    @ColumnInfo(name = "brawler_star_power")
    @SerializedName("starPowers")
    @Expose
    private List<StarPower> starPowers = null;

    @ColumnInfo(name = "brawlers_gadgets")
    @SerializedName("gadgets")
    @Expose
    private List<Gadget> gadgets = null;

    @Ignore
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;

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

    public List<StarPower> getStarPowers() {
        return starPowers;
    }

    public void setStarPowers(List<StarPower> starPowers) {
        this.starPowers = starPowers;
    }

    public List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
