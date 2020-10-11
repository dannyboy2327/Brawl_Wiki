package com.example.brawlwiki.models.brawlers;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BrawlerWithGadgets {

    @Embedded
    public Brawler brawler;
    @Relation(
            parentColumn = "id_brawler",
            entityColumn = "id_fBrawler"
    )
    public List<Gadget> gadgetList;

    public BrawlerWithGadgets(Brawler brawler, List<Gadget> gadgetList) {
        this.brawler = brawler;
        this.gadgetList = gadgetList;
    }

}
