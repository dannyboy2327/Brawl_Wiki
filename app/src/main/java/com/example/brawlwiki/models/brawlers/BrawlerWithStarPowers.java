package com.example.brawlwiki.models.brawlers;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BrawlerWithStarPowers {

    @Embedded
    public Brawler brawler;
    @Relation(
            parentColumn = "id_brawler",
            entityColumn = "id_fBrawler"
    )
    public List<StarPower> startPowerList;

    public BrawlerWithStarPowers(Brawler brawler, List<StarPower> starPowerList) {
        this.brawler = brawler;
        this.startPowerList = starPowerList;
    }
}
