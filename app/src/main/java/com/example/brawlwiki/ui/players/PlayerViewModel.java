package com.example.brawlwiki.ui.players;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.playerranking.PlayerRankingList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerViewModel extends ViewModel {

    private static final String TAG = PlayerViewModel.class.getSimpleName();

    MutableLiveData<PlayerRankingList> mPlayerRankingListMutableLiveData = new MutableLiveData<>();

    public PlayerViewModel() {
    }

    public  void getTopPlayers() {
        BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
        Call<PlayerRankingList> call = brawlStarsApi.getTopPlayerList();
        call.enqueue(new Callback<PlayerRankingList>() {
            @Override
            public void onResponse(Call<PlayerRankingList> call, Response<PlayerRankingList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                Log.d(TAG, "onResponse: " + response.body().getItems().size());
            }

            @Override
            public void onFailure(Call<PlayerRankingList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}