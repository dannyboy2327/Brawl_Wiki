package com.example.brawlwiki.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.brawlwiki.models.brawlers.Brawler;

import com.example.brawlwiki.models.brawlers.BrawlerWithStarPowers;
import com.example.brawlwiki.models.brawlers.Gadget;
import com.example.brawlwiki.models.brawlers.StarPower;

import java.util.List;

@Dao
public interface BrawlStarsDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Brawler brawler);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStarPowers(List<StarPower> starPowerList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGadgets(List<Gadget> gadgetList);

    @Query("SELECT * FROM brawler ORDER BY id_brawler ASC")
    LiveData<List<Brawler>> getBrawlers();

}
