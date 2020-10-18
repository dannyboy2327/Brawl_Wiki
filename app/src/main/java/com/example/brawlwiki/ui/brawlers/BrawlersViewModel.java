package com.example.brawlwiki.ui.brawlers;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;

public class BrawlersViewModel extends AndroidViewModel {

    private static final String TAG = BrawlersViewModel.class.getSimpleName();

    private BrawlersRepository mBrawlersRepository;
    private LiveData<List<Brawler>> mListLiveData;


    public BrawlersViewModel(Application application) {
        super(application);
        mBrawlersRepository = new BrawlersRepository(application);
        mListLiveData = mBrawlersRepository.getBrawlersList();
    }


    public void insert(List<Brawler> brawlerList) {
        mBrawlersRepository.insert(brawlerList);
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        return  mListLiveData;
    }

}