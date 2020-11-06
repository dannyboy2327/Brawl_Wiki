package com.brawl.brawlwiki.ui.brawlers;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.brawl.brawlwiki.database.AppExecutors;
import com.brawl.brawlwiki.database.BrawlStarsDatabase;
import com.brawl.brawlwiki.database.daos.BrawlersDao;
import com.brawl.brawlwiki.models.brawlers.Brawler;


import java.util.List;

public class BrawlersRepository {

    //private static final String TAG = BrawlersRepository.class.getSimpleName();

    private BrawlersDao mBrawlersDao;
    private LiveData<List<Brawler>> mBrawlerLiveData;

    public BrawlersRepository(Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mBrawlersDao = brawlStarsDatabase.BrawlersDao();
        mBrawlerLiveData = mBrawlersDao.getBrawlers();
    }

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
