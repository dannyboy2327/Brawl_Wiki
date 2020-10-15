package com.example.brawlwiki.ui.players;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.brawlwiki.models.playerranking.PlayerItem;
import com.example.brawlwiki.models.playerranking.PlayerRankingList;

import java.util.List;


public class PlayerViewModel extends AndroidViewModel {

    private PlayerRepository mPlayerRepository;
    private LiveData<List<PlayerItem>> mListLiveData;

    public PlayerViewModel(Application application) {
        super(application);
        mPlayerRepository = new PlayerRepository(application);
        mListLiveData = mPlayerRepository.getAllPlayers();
    }

    public void insertPlayerList(PlayerRankingList playerRankingList) {
        mPlayerRepository.insertPlayerList(playerRankingList);
    }

    public LiveData<List<PlayerItem>> getAllPlayers() {
        return mListLiveData;
    }
}