package com.example.brawlwiki.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.brawlwiki.models.clubranking.Item;

import java.util.List;

@Dao
public interface ClubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClubList(Item item);

    @Query("SELECT * FROM club")
    LiveData<List<Item>> getClubList();
}
