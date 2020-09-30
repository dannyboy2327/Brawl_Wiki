package com.example.brawlwiki.database;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;

@Dao
public interface BrawlerDao {

    @Insert
    void insert(Brawler brawler);

    @Update
    void update(Brawler brawler);

    @Query("SELECT * FROM brawler_table ORDER BY brawler_id DESC")
    MutableLiveData<List<Brawler>> getAllBrawlers();
}
