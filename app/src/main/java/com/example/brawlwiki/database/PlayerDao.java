package com.example.brawlwiki.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.brawlwiki.models.playerranking.PlayerItem;

import java.util.List;

@Dao
public interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlayer(PlayerItem playerItem);

    @Query("SELECT * FROM player ORDER BY rank ASC")
    LiveData<List<PlayerItem>> getAllPlayers();
}
