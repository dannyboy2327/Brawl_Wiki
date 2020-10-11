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
import com.example.brawlwiki.models.brawlers.BrawlerWithGadgets;
import com.example.brawlwiki.models.brawlers.BrawlerWithStarPowers;
import com.example.brawlwiki.models.brawlers.Gadget;
import com.example.brawlwiki.models.brawlers.StarPower;
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
     * @param brawlerList
     */

    public void insert(final List<Brawler> brawlerList) {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < brawlerList.size(); i++) {
                    BrawlerWithStarPowers brawlerWithStarPowers =
                            new BrawlerWithStarPowers(brawlerList.get(i), brawlerList.get(i).getStarPowers());
                    mBrawlStarsDao.insert(brawlerWithStarPowers.brawler);
                    Log.d(TAG, "Brawler Name: " + brawlerWithStarPowers.brawler.getName());
                    for (StarPower starPower : brawlerWithStarPowers.startPowerList) {
                        starPower.setId_fBrawler(brawlerWithStarPowers.brawler.getId_brawler());
                        Log.d(TAG, "StarPower ID: " + starPower.getId_fBrawler());
                    }
                    mBrawlStarsDao.insertStarPowers(brawlerWithStarPowers.startPowerList);

                    BrawlerWithGadgets brawlerWithGadgets = new BrawlerWithGadgets(brawlerList.get(i), brawlerList.get(i).getGadgets());
                    for (Gadget gadget : brawlerWithGadgets.gadgetList) {
                        gadget.setId_fBrawler(brawlerWithGadgets.brawler.getId_brawler());
                        Log.d(TAG, "Gadget ID: " + gadget.getId_fBrawler());
                    }
                    mBrawlStarsDao.insertGadgets(brawlerWithGadgets.gadgetList);
                }
            }
        });
    }


}
