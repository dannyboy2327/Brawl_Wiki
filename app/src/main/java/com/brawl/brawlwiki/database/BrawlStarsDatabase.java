package com.brawl.brawlwiki.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.brawl.brawlwiki.database.converters.BrawlerStatConverter;
import com.brawl.brawlwiki.database.converters.ClubConverter;
import com.brawl.brawlwiki.database.converters.GadgetConverter;
import com.brawl.brawlwiki.database.converters.IconConverter;
import com.brawl.brawlwiki.database.converters.PlayerClubConverter;
import com.brawl.brawlwiki.database.converters.PlayerIconConverter;
import com.brawl.brawlwiki.database.converters.StarPowerConverter;
import com.brawl.brawlwiki.database.daos.BrawlersDao;
import com.brawl.brawlwiki.database.daos.ClubDao;
import com.brawl.brawlwiki.database.daos.GameModeDao;
import com.brawl.brawlwiki.database.daos.PlayerDao;
import com.brawl.brawlwiki.database.daos.ProfileDao;
import com.brawl.brawlwiki.models.brawlers.Brawler;
import com.brawl.brawlwiki.models.clubranking.ClubRanking;
import com.brawl.brawlwiki.models.gamemodes.GameMode;
import com.brawl.brawlwiki.models.playerranking.PlayerRanking;
import com.brawl.brawlwiki.models.profile.Player;

@Database(entities = {Brawler.class, ClubRanking.class, PlayerRanking.class, GameMode.class, Player.class}, version = 10)
@TypeConverters({
        StarPowerConverter.class, GadgetConverter.class, IconConverter.class, ClubConverter.class,
        PlayerClubConverter.class, PlayerIconConverter.class, BrawlerStatConverter.class
})
public abstract class BrawlStarsDatabase extends RoomDatabase {

    private static BrawlStarsDatabase instance;

    public abstract BrawlersDao BrawlersDao();
    public abstract ClubDao ClubDao();
    public abstract PlayerDao PlayerDao();
    public abstract GameModeDao GameModeDao();
    public abstract ProfileDao ProfileDao();

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
