package com.example.brawlwiki.ui.gamemodes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.daos.GameModeDao;
import com.example.brawlwiki.models.gamemodes.GameMode;

import java.util.List;

public class GameModesRepository {

    private GameModeDao mGameModeDao;
    private List<GameMode> mGameModeList;
    private LiveData<List<GameMode>> mListLiveData;

    public GameModesRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mGameModeDao = brawlStarsDatabase.GameModeDao();
        mListLiveData = mGameModeDao.getAllGameModes();
    }


    public void insertGameMode(List<GameMode> gameModeList) {
        mGameModeList = gameModeList;

        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                for (GameMode gameMode : mGameModeList) {
                    mGameModeDao.insertGameMode(gameMode);
                }
            }
        });
    }

    public LiveData<List<GameMode>> getGameModes() {
        return mListLiveData;
    }
}
