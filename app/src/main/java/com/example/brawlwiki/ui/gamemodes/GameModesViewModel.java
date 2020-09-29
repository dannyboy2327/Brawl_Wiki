package com.example.brawlwiki.ui.gamemodes;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.gamemodes.GamesModeList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameModesViewModel extends ViewModel {

    private static final String TAG = GameModesViewModel.class.getSimpleName();

    MutableLiveData<GamesModeList> mGameModesListMutableLiveData = new MutableLiveData<>();

    public GameModesViewModel() {}

    public void getGameModes() {
        BrawlStarsApi brawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
        Call<GamesModeList> call = brawlStarsApi.getGameModes();
        call.enqueue(new Callback<GamesModeList>() {
            @Override
            public void onResponse(Call<GamesModeList> call, Response<GamesModeList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                Log.d(TAG, "onResponse: " + response.body().getList().size());
            }

            @Override
            public void onFailure(Call<GamesModeList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}
