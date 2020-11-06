package com.brawl.brawlwiki.models.gamemodes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "game mode")
public class GameMode implements Serializable {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo
    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("hash")
    @Expose
    private String hash;

    @Ignore
    @SerializedName("disabled")
    @Expose
    private Boolean disabled;

    @Ignore
    @SerializedName("version")
    @Expose
    private Integer version;

    @ColumnInfo
    @SerializedName("title")
    @Expose
    private String title;

    @Ignore
    @SerializedName("tutorial")
    @Expose
    private String tutorial;

    @ColumnInfo
    @SerializedName("description")
    @Expose
    private String description;

    @ColumnInfo
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;

    @Ignore
    @SerializedName("sort1")
    @Expose
    private Integer sort1;

    @Ignore
    @SerializedName("sort2")
    @Expose
    private Integer sort2;

    @Ignore
    @SerializedName("link")
    @Expose
    private String link;

    @ColumnInfo
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @ColumnInfo
    @SerializedName("imageUrl2")
    @Expose
    private String imageUrl2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getSort1() {
        return sort1;
    }

    public void setSort1(Integer sort1) {
        this.sort1 = sort1;
    }

    public Integer getSort2() {
        return sort2;
    }

    public void setSort2(Integer sort2) {
        this.sort2 = sort2;
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
}
