package com.example.brawlwiki.ui.brawlers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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

    //private static final String TAG = BrawlersFragment.class.getSimpleName();

    private final BrawlStarsApi brawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
    private BrawlersViewModel mBrawlersViewModel;
    private FragmentBrawlersBinding mFragmentBrawlersBinding;
    private boolean isConnected;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBrawlersViewModel = new ViewModelProvider(this).get(BrawlersViewModel.class);
        mFragmentBrawlersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_brawlers, container, false);
        View root = mFragmentBrawlersBinding.getRoot();

        getActiveNetwork();

        if (isConnected) {
            getBrawlerList();
        }

        mBrawlersViewModel.getBrawlersList().observe(getViewLifecycleOwner(), new Observer<List<Brawler>>() {
            @Override
            public void onChanged(List<Brawler> brawlers) {
                if (!(brawlers == null)) {
                    createBrawlersAdapter(brawlers);
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

    private void createBrawlersAdapter(List<Brawler> brawlers) {
        int orientation = getOrientation();
        boolean isTablet = getResources().getBoolean(R.bool.isTablet);

        if (!isTablet && orientation == Configuration.ORIENTATION_PORTRAIT) {
            mFragmentBrawlersBinding.rvBrawlers.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else if (isTablet && orientation == Configuration.ORIENTATION_PORTRAIT) {
            mFragmentBrawlersBinding.rvBrawlers.setLayoutManager(new GridLayoutManager(getContext(), 4));
        } else if ((isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE) || (!isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE)) {
            mFragmentBrawlersBinding.rvBrawlers.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        mFragmentBrawlersBinding.rvBrawlers.setHasFixedSize(true);
        BrawlersAdapter brawlersAdapter = new BrawlersAdapter(getContext(), brawlers);
        mFragmentBrawlersBinding.rvBrawlers.setAdapter(brawlersAdapter);
    }

    private int getOrientation() {
        return getActivity().getResources().getConfiguration().orientation;
    }

    private void getBrawlerList() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        brawlStarsApi.getBrawlers(getResources().getString(R.string.bearer) + sharedPreferences.getString(getResources().getString(R.string.my_token), "")).enqueue(new Callback<BrawlerList>() {
            @Override
            public void onResponse(@NonNull  Call<BrawlerList> call, @NonNull Response<BrawlerList> response) {
                if (!response.isSuccessful()) {
                    //Log.d(TAG, "onResponse not successful: " + response.code());
                    Toast.makeText(getContext(), getResources().getString(R.string.toast_error) + response.code(), Toast.LENGTH_LONG).show();
                    getActivity().finish();
                }
                assert response.body() != null;
                mBrawlersViewModel.insert(response.body().getBrawlerList());
                createBrawlersAdapter(response.body().getBrawlerList());
            }

            @Override
            public void onFailure(@NonNull Call<BrawlerList> call, @NonNull Throwable t) {
                //Log.d(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
    }
}