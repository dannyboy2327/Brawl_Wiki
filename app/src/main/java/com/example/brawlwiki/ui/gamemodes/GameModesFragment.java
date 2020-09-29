package com.example.brawlwiki.ui.gamemodes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.brawlwiki.R;

public class GameModesFragment extends Fragment {

    private static final String LOG_TAG = GameModesFragment.class.getSimpleName();

    private GameModesViewModel mGameModesViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {

        mGameModesViewModel = new ViewModelProvider(this).get(GameModesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_game_modes, container, false);

        mGameModesViewModel.getGameModes();

        return root;
    }
}
