package com.example.brawlwiki.ui.brawlers;

import android.app.Application;
import android.util.Log;


import androidx.lifecycle.LiveData;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDao;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.BrawlerWithGadgets;
import com.example.brawlwiki.models.brawlers.BrawlerWithStarPowers;
import com.example.brawlwiki.models.brawlers.Gadget;
import com.example.brawlwiki.models.brawlers.StarPower;


import java.util.List;

public class BrawlersRepository {

    private static final String TAG = BrawlersRepository.class.getSimpleName();

    private BrawlStarsDao mBrawlStarsDao;
    private LiveData<List<Brawler>> mBrawlerLiveData;

    public BrawlersRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mBrawlStarsDao = brawlStarsDatabase.BrawlStarsDao();
        mBrawlerLiveData = mBrawlStarsDao.getBrawlers();
    }

    /**
     * Method to insert a brawler's own personal data as well a brawlers start powers and gadgets
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

    public LiveData<List<Brawler>> getBrawlersList() {
        return mBrawlerLiveData;
    }

}
