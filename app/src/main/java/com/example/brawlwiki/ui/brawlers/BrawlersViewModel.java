package com.example.brawlwiki.ui.brawlers;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrawlersViewModel extends ViewModel {

    private static final String TAG = BrawlersViewModel.class.getSimpleName();

    MutableLiveData<BrawlerList> mBrawlerListMutableLiveData = new MutableLiveData<>();

    public BrawlersViewModel() { }

    public void getBrawlers() {

        BrawlStarsApi brawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
        Call<BrawlerList> call = brawlStarsApi.getBrawlers();
        call.enqueue(new Callback<BrawlerList>() {
            @Override
            public void onResponse(Call<BrawlerList> call, Response<BrawlerList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }
                Log.d(TAG, "onResponse: " + response.body().getBrawlerList().get(0).getName());
            }

            @Override
            public void onFailure(Call<BrawlerList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

}