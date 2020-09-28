package com.example.brawlwiki.ui.home.profile;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.players.Player;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = ProfileViewModel.class.getSimpleName();

    MutableLiveData<Player> mPlayerMutableLiveData = new MutableLiveData<>();

    public ProfileViewModel(){}

    public void getPlayerStats() {
        BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
        Call<Player> call = brawlStarsApi.getPlayer();
        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }
                Log.d(TAG, "onResponse: " +response.body().getName());
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}