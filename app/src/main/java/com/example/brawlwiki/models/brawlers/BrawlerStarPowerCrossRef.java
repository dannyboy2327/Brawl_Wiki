package com.example.brawlwiki.models.brawlers;

import androidx.room.Entity;

@Entity(primaryKeys = {"brawler_id", "star_power_id"})
public class BrawlerStarPowerCrossRef {
    private Integer brawlerId;
    private Integer starPowerId;
}
