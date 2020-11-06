package com.brawl.brawlwiki.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brawl.brawlwiki.models.brawlers.Brawler;

import java.util.List;

@Dao
public interface BrawlersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBrawler(Brawler brawler);

    @Query("SELECT * FROM brawlers ORDER BY id ASC")
    LiveData<List<Brawler>> getBrawlers();
}
