package com.example.brawlwiki.ui.clubs;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.clubranking.Item;

import java.util.List;

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
