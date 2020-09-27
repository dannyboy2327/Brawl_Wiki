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

        mMapsViewModel = ViewModelProviders.of(this).get(MapsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maps, container, false);
        final TextView textView = root.findViewById(R.id.text_maps);
        mMapsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cdn.starlist.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BrawlStarsApi brawlStarsApi = retrofit.create(BrawlStarsApi.class);
        Call<MapList> call = brawlStarsApi.getGameModes();
        call.enqueue(new Callback<MapList>() {
            @Override
            public void onResponse(Call<MapList> call, Response<MapList> response) {
                if (!response.isSuccessful()) {
                    Log.d(LOG_TAG, "onResponse not successful: " + response.code());
                }

                Log.d(LOG_TAG, "onResponse: " + response.body().getList().size());
            }

            @Override
            public void onFailure(Call<MapList> call, Throwable t) {
                Log.d(LOG_TAG, "onResponse failure: " + t.getMessage());
            }
        });
        return root;
    }
}
