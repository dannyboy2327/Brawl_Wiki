package com.example.brawlwiki.ui.home;

import android.app.Application;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.daos.ProfileDao;
import com.example.brawlwiki.models.profile.Player;

public class HomeRepository {

    private ProfileDao mProfileDao;
    private Player mPlayer;

    public HomeRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mProfileDao = brawlStarsDatabase.ProfileDao();
    }


    public void insertProfile(Player player) {
        mPlayer = player;
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                mProfileDao.insertProfile(mPlayer);
            }
        });
    }
}
