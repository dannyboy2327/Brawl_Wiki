package com.example.brawlwiki.ui.brawlers;

import android.os.Bundle;
import android.os.CountDownTimer;
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
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.brawlwiki.R;
import com.example.brawlwiki.adapters.BrawlersAdapter;
import com.example.brawlwiki.databinding.FragmentBrawlersBinding;
import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.BrawlerList;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BrawlersFragment extends Fragment {

    private static final String TAG = BrawlersFragment.class.getSimpleName();

    private BrawlStarsApi brawlStarsApi = ApiClient.getBrawlListClient().create(BrawlStarsApi.class);
    private BrawlersViewModel mBrawlersViewModel;
    private FragmentBrawlersBinding mFragmentBrawlersBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBrawlersViewModel = new ViewModelProvider(this).get(BrawlersViewModel.class);
        mFragmentBrawlersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_brawlers, container, false);
        View root = mFragmentBrawlersBinding.getRoot();

        getBrawlerList();

        mBrawlersViewModel.getBrawlersList().observe(getViewLifecycleOwner(), new Observer<List<Brawler>>() {
            @Override
            public void onChanged(List<Brawler> brawlers) {
                //Log.d(TAG, "onChanged: " + brawlers.size());
                createBrawlersAdapter(brawlers);
            }
        });

        return root;
    }

    private void createBrawlersAdapter(List<Brawler> brawlers) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mFragmentBrawlersBinding.rvBrawlers.setLayoutManager(gridLayoutManager);
        mFragmentBrawlersBinding.rvBrawlers.setHasFixedSize(true);
        BrawlersAdapter brawlersAdapter = new BrawlersAdapter(getContext(), brawlers);
        mFragmentBrawlersBinding.rvBrawlers.setAdapter(brawlersAdapter);
    }


    private void getBrawlerList() {
        brawlStarsApi.getBrawlers().enqueue(new Callback<BrawlerList>() {
            @Override
            public void onResponse(@NonNull Call<BrawlerList> call, @NonNull Response<BrawlerList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                assert response.body() != null;
                List<Brawler> brawlerList = response.body().getBrawlerList();
                Log.d(TAG, "onResponse: " + brawlerList.size());
                mBrawlersViewModel.insert(brawlerList);
            }

            @Override
            public void onFailure(@NonNull Call<BrawlerList> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}