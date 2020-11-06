package com.brawl.brawlwiki.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brawl.brawlwiki.models.profile.Player;


@Dao
public interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProfile(Player player);

    @Query("SELECT * FROM player ")
    LiveData<Player> getPlayer();

    @Query("SELECT * FROM player")
    Player getPlayerSync();
}
