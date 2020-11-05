package com.example.brawlwiki.ui.home.profile;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.brawlwiki.models.profile.Player;

public class ProfileViewModel extends AndroidViewModel {

    //private static final String TAG = ProfileViewModel.class.getSimpleName();
    private ProfileRepository mProfileRepository;
    private LiveData<Player> mPlayerLiveData;

    public ProfileViewModel(Application application){
        super(application);
        mProfileRepository = new ProfileRepository(application);
        mPlayerLiveData = mProfileRepository.getPlayer();
    }

    public void insertProfile(Player player) {
        mProfileRepository.insertProfile(player);
    }

    public LiveData<Player> getPlayer() {
        return mPlayerLiveData;
    }

}