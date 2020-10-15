package com.example.brawlwiki.ui.players;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.PlayerDao;
import com.example.brawlwiki.models.playerranking.PlayerItem;
import com.example.brawlwiki.models.playerranking.PlayerRankingList;

import java.util.List;

public class PlayerRepository {

    private static final String TAG = PlayerRepository.class.getSimpleName();

    private PlayerDao mPlayerDao;
    private PlayerRankingList mPlayerRankingList;
    private LiveData<List<PlayerItem>> mListLiveData;

    public PlayerRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mPlayerDao = brawlStarsDatabase.PlayerDao();
        mListLiveData = mPlayerDao.getAllPlayers();
    }


    public void insertPlayerList(PlayerRankingList playerRankingList) {
        mPlayerRankingList = playerRankingList;

        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                for (PlayerItem playerItem : mPlayerRankingList.getPlayerItems()) {
                    //Log.d(TAG, "run: " + playerItem.getName() + "\n" + playerItem.getRank() + "\n" + playerItem.getTrophies());
                    mPlayerDao.insertPlayer(playerItem);
                }
            }
        });
    }

    public LiveData<List<PlayerItem>> getAllPlayers() {
        return mListLiveData;
    }
}
