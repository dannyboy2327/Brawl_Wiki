package com.example.brawlwiki.ui.clubs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.brawlwiki.R;


public class ClubsFragment extends Fragment {

    private static final String LOG_TAG = ClubsFragment.class.getSimpleName();

    private ClubsViewModel mClubsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mClubsViewModel = new ViewModelProvider(this).get(ClubsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clubs, container, false);

        mClubsViewModel.getClubList();

        return root;
    }
}
