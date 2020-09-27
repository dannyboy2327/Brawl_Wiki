package com.example.brawlwiki.ui.clubs;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;
import com.example.brawlwiki.ui.brawlers.BrawlersViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubsViewModel extends ViewModel {

    private static final String TAG = ClubsViewModel.class.getSimpleName();

    MutableLiveData<ClubMemberList> mClubMemberListMutableLiveData = new MutableLiveData<>();

    public ClubsViewModel() {
    }

    public void getClubList() {

        BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
        Call<ClubMemberList> call = brawlStarsApi.getClubList();
        call.enqueue(new Callback<ClubMemberList>() {
            @Override
            public void onResponse(Call<ClubMemberList> call, Response<ClubMemberList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                Log.d(TAG, "onResponse: " + response.body().getItems().size());

            }

            @Override
            public void onFailure(Call<ClubMemberList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}
