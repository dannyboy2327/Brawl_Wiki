package com.example.brawlwiki.ui.brawlers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;

public class BrawlersViewModel extends ViewModel {

    private static final String TAG = BrawlersViewModel.class.getSimpleName();

    private BrawlersRepository mRepository = BrawlersRepository.getInstance();
    private MutableLiveData<List<Brawler>> mAllBrawlers;
    private LiveData<List<Brawler>> brawlerListLiveData;


    public BrawlersViewModel() {
        super();
        brawlerListLiveData = mRepository.getBrawlersList();
    }

    public LiveData<List<Brawler>> getBrawlersList() {
        return brawlerListLiveData;
    }


    public void insert(List<Brawler> brawlerList) {
        mRepository.insert(brawlerList);
    }

}