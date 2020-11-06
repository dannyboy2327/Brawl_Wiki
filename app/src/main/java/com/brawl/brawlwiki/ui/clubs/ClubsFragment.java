package com.brawl.brawlwiki.ui.clubs;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.brawl.brawlwiki.adapters.ClubsAdapter;
import com.brawl.brawlwiki.R;
import com.brawl.brawlwiki.databinding.FragmentClubsBinding;
import com.brawl.brawlwiki.models.clubranking.ClubMemberList;
import com.brawl.brawlwiki.models.clubranking.ClubRanking;
import com.brawl.brawlwiki.network.ApiClient;
import com.brawl.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClubsFragment extends Fragment {

    //private static final String TAG = ClubsFragment.class.getSimpleName();

    private final BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
    private ClubsViewModel mClubsViewModel;
    private FragmentClubsBinding mFragmentClubsBinding;
    private boolean isConnected;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mClubsViewModel = new ViewModelProvider(this).get(ClubsViewModel.class);
        mFragmentClubsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_clubs, container, false);
        View root = mFragmentClubsBinding.getRoot();

        getActiveNetwork();

        if (isConnected) {
            getClubMemberList();
        }


        mClubsViewModel.getClubList().observe(getViewLifecycleOwner(), new Observer<List<ClubRanking>>() {
            @Override
            public void onChanged(List<ClubRanking> clubRankingList) {
                if (!(clubRankingList == null)) {
                    createClubAdapter(clubRankingList);
                }
            }
        });

        return root;
    }

    private void getActiveNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        //Log.d(TAG, "getActiveNetwork: " + isConnected);
    }

    private void createClubAdapter(List<ClubRanking> clubRankingList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mFragmentClubsBinding.rvClubs.setLayoutManager(linearLayoutManager);
        mFragmentClubsBinding.rvClubs.setHasFixedSize(true);
        ClubsAdapter clubsAdapter= new ClubsAdapter(getContext(), clubRankingList);
        mFragmentClubsBinding.rvClubs.setAdapter(clubsAdapter);
    }

    private void getClubMemberList() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        brawlStarsApi.getClubList(getResources().getString(R.string.bearer) + sharedPreferences.getString(getResources().getString(R.string.my_token), "")).enqueue(new Callback<ClubMemberList>() {
            @Override
            public void onResponse(@NonNull Call<ClubMemberList> call, @NonNull Response<ClubMemberList> response) {
                if (!response.isSuccessful()) {
                    //Log.d(TAG, "onResponse not successful: " + response.code());
                    Toast.makeText(getContext(), getResources().getString(R.string.toast_error) + response.code(), Toast.LENGTH_LONG).show();
                    getActivity().finish();
                }

                mClubsViewModel.insertClubList(response.body());
                assert response.body() != null;
                createClubAdapter(response.body().getClubRankingList());
            }

            @Override
            public void onFailure(@NonNull Call<ClubMemberList> call, @NonNull Throwable t) {
                //Log.d(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
    }
}
