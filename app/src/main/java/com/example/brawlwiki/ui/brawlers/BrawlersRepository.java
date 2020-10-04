package com.example.brawlwiki.ui.brawlers;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDao;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrawlersRepository {

    private static final String TAG = BrawlersRepository.class.getSimpleName();
    private BrawlStarsApi mBrawlStarsApi;
    private BrawlStarsDao mBrawlStarsDao;
    private MutableLiveData<List<Brawler>> brawlerListLiveData = new MutableLiveData<>();

    public BrawlersRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mBrawlStarsDao = brawlStarsDatabase.BrawlStarsDao();
        mBrawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        mBrawlStarsApi.getBrawlers().enqueue(new Callback<BrawlerList>() {
            @Override
            public void onResponse(@NonNull Call<BrawlerList> call, @NonNull Response<BrawlerList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                assert response.body() != null;
                brawlerListLiveData.setValue(response.body().getBrawlerList());
            }

            @Override
            public void onFailure(@NonNull  Call<BrawlerList> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return brawlerListLiveData;
    }


    /**
     * Inserts a brawler's data into the database in a background thread
     *
     * @param brawler
     */

    public void insert(final Brawler brawler) {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                mBrawlStarsDao.insert(brawler);
            }
        });
    }


}
