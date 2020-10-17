package com.example.brawlwiki.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.Gadget;
import com.example.brawlwiki.models.brawlers.StarPower;
import com.example.brawlwiki.models.clubranking.Item;
import com.example.brawlwiki.models.gamemodes.GameMode;
import com.example.brawlwiki.models.playerranking.PlayerItem;

@Database(entities = {Brawler.class, StarPower.class, Gadget.class, Item.class, PlayerItem.class, GameMode.class}, version = 3)
public abstract class BrawlStarsDatabase extends RoomDatabase {

    private static BrawlStarsDatabase instance;

    public abstract BrawlStarsDao BrawlStarsDao();
    public abstract ClubDao ClubDao();
    public abstract PlayerDao PlayerDao();
    public abstract GameModeDao GameModeDao();

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
