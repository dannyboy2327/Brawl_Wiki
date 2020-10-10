package com.example.brawlwiki.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.StarPower;

@Database(entities = {Brawler.class, StarPower.class}, version = 1)
public abstract class BrawlStarsDatabase extends RoomDatabase {

    private static BrawlStarsDatabase instance;

    public abstract BrawlStarsDao BrawlStarsDao();

    public static synchronized BrawlStarsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BrawlStarsDatabase.class, "brawl_stars_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
