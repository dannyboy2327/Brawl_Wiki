package com.example.brawlwiki.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.profile.Player;

public class HomeViewModel extends AndroidViewModel {

    private HomeRepository mHomeRepository;

    public HomeViewModel(Application application) {
        super(application);
        mHomeRepository = new HomeRepository(application);
    }

    public void insertProfile(Player player) {
        mHomeRepository.insertProfile(player);
    }

}