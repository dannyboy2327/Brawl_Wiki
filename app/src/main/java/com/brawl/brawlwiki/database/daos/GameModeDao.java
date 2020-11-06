package com.brawl.brawlwiki.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brawl.brawlwiki.models.gamemodes.GameMode;

import java.util.List;

@Dao
public interface GameModeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGameMode(GameMode gameMode);

    @Query("SELECT * FROM `game mode` ORDER BY id ASC")
    LiveData<List<GameMode>> getAllGameModes();
}
