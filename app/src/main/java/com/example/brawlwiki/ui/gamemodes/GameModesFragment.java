package com.example.brawlwiki.ui.gamemodes;

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

import com.example.brawlwiki.R;
import com.example.brawlwiki.adapters.GameModesAdapter;
import com.example.brawlwiki.databinding.FragmentGameModesBinding;
import com.example.brawlwiki.models.gamemodes.GameMode;
import com.example.brawlwiki.models.gamemodes.GamesModeList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameModesFragment extends Fragment {

    private static final String TAG = GameModesFragment.class.getSimpleName();

    private GameModesViewModel mGameModesViewModel;
    private BrawlStarsApi mBrawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
    private FragmentGameModesBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {

        mGameModesViewModel = new ViewModelProvider(this).get(GameModesViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_modes, container, false);
        View root = mBinding.getRoot();

        getGameModesList();

        mGameModesViewModel.getGameModes().observe(getViewLifecycleOwner(), new Observer<List<GameMode>>() {
            @Override
            public void onChanged(List<GameMode> gameModes) {
                //Log.d(TAG, "onChanged: " + gameModes.size());
                createGameModesAdapter(gameModes);
            }
        });

        return root;
    }

    private void createGameModesAdapter(List<GameMode> gameModes) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.rvGameModes.setLayoutManager(linearLayoutManager);
        mBinding.rvGameModes.setHasFixedSize(true);
        GameModesAdapter gameModesAdapter = new GameModesAdapter(getContext(), gameModes);
        mBinding.rvGameModes.setAdapter(gameModesAdapter);
    }

    private void getGameModesList() {
        mBrawlStarsApi.getGameModes().enqueue(new Callback<GamesModeList>() {
            @Override
            public void onResponse(@NonNull Call<GamesModeList> call, @NonNull Response<GamesModeList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }
                assert response.body() != null;
                List<GameMode> gameModeList = response.body().getList();
                mGameModesViewModel.insertGameMode(gameModeList);
            }

            @Override
            public void onFailure(@NonNull Call<GamesModeList> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
