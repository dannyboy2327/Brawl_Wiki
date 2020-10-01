package com.example.brawlwiki.ui.brawlers;

import android.app.Application;
import android.util.Log;

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

public class BrawlersRepository  {

    private static final String TAG = BrawlersRepository.class.getSimpleName();

    private BrawlStarsDao mBrawlStarsDao;
    private LiveData<List<Brawler>> mAllBrawlers;
    private BrawlStarsApi mBrawlStarsApi;
    private MutableLiveData<List<Brawler>> brawlerListLiveData = new MutableLiveData<>();

    public BrawlersRepository(Application application) {
        BrawlStarsDatabase database = BrawlStarsDatabase.getInstance(application);
        mBrawlStarsDao = database.BrawlStarsDao();
        mAllBrawlers = mBrawlStarsDao.getAllBrawlers();
        mBrawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        Call<BrawlerList> call = mBrawlStarsApi.getBrawlers();
        call.enqueue(new Callback<BrawlerList>() {
            @Override
            public void onResponse(Call<BrawlerList> call, Response<BrawlerList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }
                Log.d(TAG, "onResponse: " + response.body().getBrawlerList().size());
                brawlerListLiveData.setValue(response.body().getBrawlerList());
            }

            @Override
            public void onFailure(Call<BrawlerList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return brawlerListLiveData;
    }


    /**
     * Inserts a list of brawler objects data into the database in a background thread
     *
     * @param brawlerList
     */

    public void insert(final List<Brawler> brawlerList) {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void update(List<Brawler> brawlerList) {

    }

    public LiveData<List<Brawler>> getAllBrawlers() {
        return mAllBrawlers;
    }
}
