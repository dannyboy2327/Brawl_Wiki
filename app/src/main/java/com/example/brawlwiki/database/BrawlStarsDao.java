package com.example.brawlwiki.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;

@Dao
public interface BrawlStarsDao {

    @Insert
    void insert(Brawler brawler);

    @Update
    void update(List<Brawler> brawlerList);

    @Query("SELECT * FROM brawler ORDER BY id DESC")
    LiveData<List<Brawler>> getAllBrawlers();
}
