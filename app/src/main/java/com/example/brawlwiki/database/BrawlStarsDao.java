package com.example.brawlwiki.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.StarPower;

import java.util.List;

@Dao
public interface BrawlStarsDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Brawler brawler);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStarPowers(List<StarPower> starPowerList);

    @Update
    void update(List<Brawler> brawlerList);

    @Query("SELECT * FROM brawler ORDER BY id_brawler DESC")
    LiveData<List<Brawler>> getAllBrawlers();
}
