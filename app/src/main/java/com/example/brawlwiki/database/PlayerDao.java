package com.example.brawlwiki.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.brawlwiki.models.playerranking.PlayerRanking;

import java.util.List;

@Dao
public interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlayer(PlayerRanking playerRanking);

    @Query("SELECT * FROM player_ranking ORDER BY rank ASC")
    LiveData<List<PlayerRanking>> getAllPlayers();
}
