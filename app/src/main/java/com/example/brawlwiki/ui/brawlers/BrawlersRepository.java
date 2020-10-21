package com.example.brawlwiki.ui.brawlers;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.daos.BrawlersDao;
import com.example.brawlwiki.models.brawlers.Brawler;


import java.util.List;

public class BrawlersRepository {

    private static final String TAG = BrawlersRepository.class.getSimpleName();

    private BrawlersDao mBrawlersDao;
    private LiveData<List<Brawler>> mBrawlerLiveData;

    public BrawlersRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mBrawlersDao = brawlStarsDatabase.BrawlersDao();
        mBrawlerLiveData = mBrawlersDao.getBrawlers();
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

                for (Brawler brawler : brawlerList) {
                    mBrawlersDao.insertBrawler(brawler);
                }
            }
        });
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        return mBrawlerLiveData;
    }

}
