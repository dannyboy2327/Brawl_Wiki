package com.example.brawlwiki.ui.brawlers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;

public class BrawlersViewModel extends AndroidViewModel {

    private BrawlersRepository mRepository;
    private MutableLiveData<List<Brawler>> mAllBrawlers;
    private LiveData<List<Brawler>> brawlerListLiveData;


    public BrawlersViewModel(@NonNull Application application) {
        super(application);
        mRepository = new BrawlersRepository(application);
        brawlerListLiveData = mRepository.getBrawlersList();
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        return brawlerListLiveData;
    }


    public void insert(List<Brawler> brawlerList) {
        mRepository.insert(brawlerList);
    }



}