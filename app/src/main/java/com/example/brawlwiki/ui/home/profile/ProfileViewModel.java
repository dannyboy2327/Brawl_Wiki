package com.example.brawlwiki.ui.home.profile;

import android.app.Application;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.profile.Player;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends AndroidViewModel {

    private static final String TAG = ProfileViewModel.class.getSimpleName();
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