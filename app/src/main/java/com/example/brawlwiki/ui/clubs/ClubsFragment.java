package com.example.brawlwiki.ui.clubs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.brawlwiki.adapters.ClubsAdapter;
import com.example.brawlwiki.R;
import com.example.brawlwiki.databinding.FragmentClubsBinding;
import com.example.brawlwiki.models.clubranking.ClubMemberList;
import com.example.brawlwiki.models.clubranking.Item;
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
    private FragmentClubsBinding mFragmentClubsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mClubsViewModel = new ViewModelProvider(this).get(ClubsViewModel.class);
        mFragmentClubsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_clubs, container, false);
        View root = mFragmentClubsBinding.getRoot();

        getClubMemberList();

        mClubsViewModel.getClubList().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                createClubAdapter(items);
            }
        });

        return root;
    }

    private void createClubAdapter(List<Item> items) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mFragmentClubsBinding.rvClubs.setLayoutManager(linearLayoutManager);
        mFragmentClubsBinding.rvClubs.setHasFixedSize(true);
        ClubsAdapter clubsAdapter= new ClubsAdapter(getContext(), items);
        mFragmentClubsBinding.rvClubs.setAdapter(clubsAdapter);
    }

    private void getClubMemberList() {
        brawlStarsApi.getClubList().enqueue(new Callback<ClubMemberList>() {
            @Override
            public void onResponse(@NonNull Call<ClubMemberList> call, @NonNull Response<ClubMemberList> response) {
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
