package com.example.brawlwiki.ui.clubs;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.clubranking.Item;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;
import com.example.brawlwiki.ui.brawlers.BrawlersViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubsViewModel extends AndroidViewModel {

    private static final String TAG = ClubsViewModel.class.getSimpleName();

    private ClubsRepository mClubsRepository;
    private LiveData<List<Item>> mListLiveData;

    public ClubsViewModel(Application application) {
        super(application);
        mClubsRepository = new ClubsRepository(application);
        mListLiveData = mClubsRepository.getClubList();
    }

    public void insertClubList(ClubMemberList clubMemberList) {
        mClubsRepository.insertClubList(clubMemberList);
    }

    public LiveData<List<Item>> getClubList() {
        return mListLiveData;
    }
}
