package com.example.brawlwiki.models.brawlers;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity(tableName = "gadget_table")
public class Gadget implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "gadget_id")
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo(name = "gadget_name")
    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("path")
    @Expose
    private String path;

    @ColumnInfo(name = "gadget_description")
    @SerializedName("description")
    @Expose
    private String description;

    @ColumnInfo(name = "gadget_url")
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @Ignore
    @SerializedName("released")
    @Expose
    private Boolean released;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getReleased() {
        return released;
    }

    public void setReleased(Boolean released) {
        this.released = released;
    }
}