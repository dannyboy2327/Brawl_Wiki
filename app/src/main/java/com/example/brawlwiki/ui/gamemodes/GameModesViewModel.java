package com.example.brawlwiki.ui.gamemodes;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.gamemodes.GameMode;
import com.example.brawlwiki.models.gamemodes.GamesModeList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameModesViewModel extends AndroidViewModel {

    private static final String TAG = GameModesViewModel.class.getSimpleName();

    private GameModesRepository mGameModesRepository;
    private LiveData<List<GameMode>> mListLiveData;

    public GameModesViewModel(Application application) {
        super(application);
        mGameModesRepository = new GameModesRepository(application);
        mListLiveData = mGameModesRepository.getGameModes();
    }

    public void insertGameMode(List<GameMode> gameModeList) {
        mGameModesRepository.insertGameMode(gameModeList);
    }

    public LiveData<List<GameMode>> getGameModes() {
        return mListLiveData;
    }
}
