package com.example.brawlwiki.ui.maps;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.maps.MapList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsViewModel extends ViewModel {

    private static final String TAG = MapsViewModel.class.getSimpleName();

    MutableLiveData<MapList> mMapListMutableLiveData = new MutableLiveData<>();

    public MapsViewModel() {}

    public void getGameModes() {
        BrawlStarsApi brawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
        Call<MapList> call = brawlStarsApi.getGameModes();
        call.enqueue(new Callback<MapList>() {
            @Override
            public void onResponse(Call<MapList> call, Response<MapList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                Log.d(TAG, "onResponse: " + response.body().getList().size());
            }

            @Override
            public void onFailure(Call<MapList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}
