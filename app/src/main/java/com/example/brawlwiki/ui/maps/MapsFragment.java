package com.example.brawlwiki.ui.maps;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.brawlwiki.R;
import com.example.brawlwiki.network.BrawlStarsApi;
import com.example.brawlwiki.models.maps.MapList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsFragment extends Fragment {

    private static final String LOG_TAG = MapsFragment.class.getSimpleName();

    private MapsViewModel mMapsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {

        mMapsViewModel = new ViewModelProvider(this).get(MapsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maps, container, false);

        mMapsViewModel.getGameModes();

        return root;
    }
}
