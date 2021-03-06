package com.example.brawlwiki.ui.players;

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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.brawlwiki.R;
import com.example.brawlwiki.adapters.PlayersAdapter;
import com.example.brawlwiki.databinding.FragmentPlayersBinding;
import com.example.brawlwiki.models.playerranking.PlayerRanking;
import com.example.brawlwiki.models.playerranking.PlayerRankingList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerFragment extends Fragment {

    //private static final String TAG = PlayerFragment.class.getSimpleName();

    private final BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
    private PlayerViewModel mPlayerViewModel;
    private FragmentPlayersBinding mBinding;
    private boolean isConnected;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPlayerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_players, container, false);
        View root = mBinding.getRoot();

        getActiveNetwork();

        if (isConnected) {
            getPlayerRankingList();
        }


        mPlayerViewModel.getAllPlayers().observe(getViewLifecycleOwner(), new Observer<List<PlayerRanking>>() {
            @Override
            public void onChanged(List<PlayerRanking> playerRankingList) {
                //Log.d(TAG, "onChanged: " + playerRankingList.size());
                if (!(playerRankingList == null)) {
                    createPlayersAdapter(playerRankingList);
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


    private void createPlayersAdapter(List<PlayerRanking> playerRankingList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.rvPlayers.setLayoutManager(linearLayoutManager);
        mBinding.rvPlayers.setHasFixedSize(true);
        PlayersAdapter playersAdapter = new PlayersAdapter(getContext(), playerRankingList);
        mBinding.rvPlayers.setAdapter(playersAdapter);
    }

    private void getPlayerRankingList() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        brawlStarsApi.getTopPlayerList(getResources().getString(R.string.bearer) + sharedPreferences.getString(getResources().getString(R.string.my_token), "")).enqueue(new Callback<PlayerRankingList>() {
            @Override
            public void onResponse(@NonNull Call<PlayerRankingList> call, @NonNull Response<PlayerRankingList> response) {
                if (!response.isSuccessful()) {
                    //Log.d(TAG, "onResponse not successful: " + response.code());
                    Toast.makeText(getContext(), getResources().getString(R.string.toast_error) + response.code(), Toast.LENGTH_LONG).show();
                    getActivity().finish();
                }
                mPlayerViewModel.insertPlayerList(response.body());
                assert response.body() != null;
                createPlayersAdapter(response.body().getPlayerRankingList());
            }

            @Override
            public void onFailure(@NonNull Call<PlayerRankingList> call, @NonNull Throwable t) {
                //Log.d(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
    }
}