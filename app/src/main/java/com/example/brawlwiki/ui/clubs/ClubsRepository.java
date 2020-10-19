package com.example.brawlwiki.ui.clubs;

import android.app.Application;
import android.util.Log;


import androidx.lifecycle.LiveData;

import com.example.brawlwiki.database.AppExecutors;
import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.ClubDao;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.clubranking.ClubRanking;

import java.util.List;


public class ClubsRepository {

    private static final String TAG = ClubsRepository.class.getSimpleName();

    private ClubDao mClubDao;
    private ClubMemberList mClubMemberList;
    private LiveData<List<ClubRanking>> mListLiveData;

    public ClubsRepository (Application application) {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(application);
        mClubDao = brawlStarsDatabase.ClubDao();
        mListLiveData = mClubDao.getClubList();
    }

    public void insertClubList(ClubMemberList clubMemberList) {
        mClubMemberList = clubMemberList;
        //Log.d(TAG, "insertClubList: " + mClubMemberList.getClubRankingList().size());

        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                for (ClubRanking clubRanking : mClubMemberList.getClubRankingList()) {
                    mClubDao.insertClubList(clubRanking);
                    //Log.d(TAG, "run: " + "\n" + item.getTag() + "\n" + item.getName() + "\n" + item.getRank() + "\n" + item.getTrophies() + "\n"  + item.getMemberCount() + "\n"+ item.getBadgeId());
                }
            }
        });
    }

    public LiveData<List<ClubRanking>> getClubList() {
        return mListLiveData;
    }

}
