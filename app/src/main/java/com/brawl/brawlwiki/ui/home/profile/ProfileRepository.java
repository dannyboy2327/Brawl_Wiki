package com.brawl.brawlwiki.ui.home.profile;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.brawl.brawlwiki.database.AppExecutors;
import com.brawl.brawlwiki.database.BrawlStarsDatabase;
import com.brawl.brawlwiki.database.daos.ProfileDao;
import com.brawl.brawlwiki.models.profile.Player;

public class ProfileRepository {

    private ProfileDao mProfileDao;
    private LiveData<Player> mPlayerLiveData;
    private Player mPlayer;

    public ProfileRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mProfileDao = brawlStarsDatabase.ProfileDao();
        mPlayerLiveData = mProfileDao.getPlayer();
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

    public LiveData<Player> getPlayer() {
        return mPlayerLiveData;
    }
}
