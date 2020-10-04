package com.example.brawlwiki.ui.brawlers;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;

public class BrawlersViewModel extends AndroidViewModel {

    private static final String TAG = BrawlersViewModel.class.getSimpleName();
    private BrawlersRepository mBrawlersRepository;
    private MutableLiveData<List<Brawler>> mAllBrawlers;
    private LiveData<List<Brawler>> brawlerListLiveData;


    public BrawlersViewModel(Application application) {
        super(application);
        mBrawlersRepository = new BrawlersRepository(application);
        brawlerListLiveData = mBrawlersRepository.getBrawlersList();
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        return brawlerListLiveData;
    }


    public void insert(Brawler brawler) {
        mBrawlersRepository.insert(brawler);
    }

}