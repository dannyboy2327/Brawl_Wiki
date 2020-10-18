package com.example.brawlwiki.models.brawlers;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "brawlers")
public class Brawler implements Serializable {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo
    @SerializedName("name")
    @Expose
    private String name;

    @ColumnInfo
    @SerializedName("starPowers")
    @Expose
    private List<StarPower> starPowers = null;

    @ColumnInfo
    @SerializedName("gadgets")
    @Expose
    private List<Gadget> gadgets = null;

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

}
