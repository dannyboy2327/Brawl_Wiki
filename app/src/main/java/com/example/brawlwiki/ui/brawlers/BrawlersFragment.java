package com.example.brawlwiki.ui.brawlers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.brawlwiki.R;
import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.BrawlerList;

import java.util.List;


public class BrawlersFragment extends Fragment {

    private static final String TAG = BrawlersFragment.class.getSimpleName();

    private BrawlersViewModel mBrawlersViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBrawlersViewModel = new ViewModelProvider(this).get(BrawlersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_brawlers, container, false);

        mBrawlersViewModel.getBrawlersList().observe(getViewLifecycleOwner(), new Observer<List<Brawler>>() {
            @Override
            public void onChanged(List<Brawler> brawlerList) {
                Log.d(TAG, "onChanged: " + mBrawlersViewModel.getBrawlersList().getValue().get(0).getName());
                for (int i = 0; i < mBrawlersViewModel.getBrawlersList().getValue().size(); i++) {
                    Brawler brawler = new Brawler(brawlerList.get(i).getId(), brawlerList.get(i).getName(),
                            brawlerList.get(i).getImageUrl(), brawlerList.get(i).getImageUrl2(),
                            brawlerList.get(i).getBrawler_class(), brawlerList.get(i).getRarity(),
                            brawlerList.get(i).getDescription());
                    mBrawlersViewModel.insert(brawler);
                }
            }
        });
        return root;
    }
}