package com.brawl.brawlwiki.ui.players;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.brawl.brawlwiki.database.AppExecutors;
import com.brawl.brawlwiki.database.BrawlStarsDatabase;
import com.brawl.brawlwiki.database.daos.PlayerDao;
import com.brawl.brawlwiki.models.playerranking.PlayerRanking;
import com.brawl.brawlwiki.models.playerranking.PlayerRankingList;

import java.util.List;

public class PlayerRepository {

    //private static final String TAG = PlayerRepository.class.getSimpleName();

    private PlayerDao mPlayerDao;
    private PlayerRankingList mPlayerRankingList;
    private LiveData<List<PlayerRanking>> mListLiveData;

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
                for (PlayerRanking playerRanking : mPlayerRankingList.getPlayerRankingList()) {
                    //Log.d(TAG, "run: " + playerItem.getName() + "\n" + playerItem.getRank() + "\n" + playerItem.getTrophies());
                    mPlayerDao.insertPlayer(playerRanking);
                }
            }
        });
    }

    public LiveData<List<PlayerRanking>> getAllPlayers() {
        return mListLiveData;
    }
}
