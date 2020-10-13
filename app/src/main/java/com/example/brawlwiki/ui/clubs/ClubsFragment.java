package com.example.brawlwiki.ui.clubs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.brawlwiki.R;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.clubranking.Item;
import com.example.brawlwiki.models.players.Club;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClubsFragment extends Fragment {

    private static final String TAG = ClubsFragment.class.getSimpleName();

    private BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
    private ClubsViewModel mClubsViewModel;
    private ClubMemberList mClubMemberList;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mClubsViewModel = new ViewModelProvider(this).get(ClubsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clubs, container, false);

        getClubMemberList();

        mClubsViewModel.getClubList().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {

            }
        });

        return root;
    }

    private void getClubMemberList() {
        brawlStarsApi.getClubList().enqueue(new Callback<ClubMemberList>() {
            @Override
            public void onResponse(Call<ClubMemberList> call, Response<ClubMemberList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }
                mClubMemberList = response.body();
                mClubsViewModel.insertClubList(mClubMemberList);
            }

            @Override
            public void onFailure(Call<ClubMemberList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
