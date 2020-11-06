package com.brawl.brawlwiki.ui.clubs;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.brawl.brawlwiki.models.clubranking.ClubMemberList;
import com.brawl.brawlwiki.models.clubranking.ClubRanking;

import java.util.List;

public class ClubsViewModel extends AndroidViewModel {

    //private static final String TAG = ClubsViewModel.class.getSimpleName();

    private ClubsRepository mClubsRepository;
    private LiveData<List<ClubRanking>> mListLiveData;

    public ClubsViewModel(Application application) {
        super(application);
        mClubsRepository = new ClubsRepository(application);
        mListLiveData = mClubsRepository.getClubList();
    }

    public void insertClubList(ClubMemberList clubMemberList) {
        mClubsRepository.insertClubList(clubMemberList);
    }

    public LiveData<List<ClubRanking>> getClubList() {
        return mListLiveData;
    }
}
