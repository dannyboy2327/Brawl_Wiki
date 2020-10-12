package com.example.brawlwiki.ui.brawlers;

import android.os.Bundle;
import android.os.CountDownTimer;
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
import com.example.brawlwiki.models.brawlers.Brawler;

import java.util.List;


public class BrawlersFragment extends Fragment {

    private static final String TAG = BrawlersFragment.class.getSimpleName();

    private BrawlersViewModel mBrawlersViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBrawlersViewModel = new ViewModelProvider(this).get(BrawlersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_brawlers, container, false);
        mBrawlersViewModel.getBrawlersList().observe(getViewLifecycleOwner(), new Observer<List<Brawler>>() {
            @Override
            public void onChanged(List<Brawler> brawlerList) {
                Log.d(TAG, "onChanged: " + mBrawlersViewModel.getBrawlersList().getValue().get(0).getName());
               // mBrawlersViewModel.insert(brawlerList);

               List<Brawler> brawlerList1 =  mBrawlersViewModel.getBrawlers();
                Log.d(TAG, "onChanged: " + brawlerList1.size());
            }
        });

        return root;
    }
}