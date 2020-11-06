package com.brawl.brawlwiki.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brawl.brawlwiki.models.clubranking.ClubRanking;

import java.util.List;

@Dao
public interface ClubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClubList(ClubRanking clubRanking);

    @Query("SELECT * FROM club_ranking ORDER BY rank ASC")
    LiveData<List<ClubRanking>> getClubList();
}
