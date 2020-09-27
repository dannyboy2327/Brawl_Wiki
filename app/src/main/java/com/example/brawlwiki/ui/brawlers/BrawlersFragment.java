package com.example.brawlwiki.ui.brawlers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.brawlwiki.R;


public class BrawlersFragment extends Fragment {

    private static final String LOG_TAG = BrawlersFragment.class.getSimpleName();

    private BrawlersViewModel mBrawlersViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBrawlersViewModel = new ViewModelProvider(this).get(BrawlersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_brawlers, container, false);

        mBrawlersViewModel.getBrawlers();

        return root;
    }
}