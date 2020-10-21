package com.example.brawlwiki.ui.home.profile;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.daos.ProfileDao;
import com.example.brawlwiki.models.profile.Player;

public class ProfileRepository {

    private ProfileDao mProfileDao;
    private LiveData<Player> mPlayerLiveData;

    public ProfileRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mProfileDao = brawlStarsDatabase.ProfileDao();
        mPlayerLiveData = mProfileDao.getPlayer();
    }

    public LiveData<Player> getPlayer() {
        return mPlayerLiveData;
    }
}
