package com.example.brawlwiki.models.brawlers;

import android.support.v4.app.INotificationSideChannel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "gadget")
public class Gadget implements Serializable {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id_gadget;

    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("path")
    @Expose
    private String path;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @Ignore
    @SerializedName("released")
    @Expose
    private Boolean released;

    @ForeignKey(
            entity = Brawler.class,
            parentColumns = "id_brawler",
            childColumns = "id_fBrawler",
            onDelete = CASCADE
    )
    public Integer id_fBrawler;

    public Integer getId_gadget() {
        return id_gadget;
    }

    public void setId_gadget(Integer id_gadget) {
        this.id_gadget = id_gadget;
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

    public Integer getId_fBrawler() {
        return id_fBrawler;
    }

    public void setId_fBrawler(Integer id_fBrawler) {
        this.id_fBrawler = id_fBrawler;
    }
}
