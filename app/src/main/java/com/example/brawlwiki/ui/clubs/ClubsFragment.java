package com.example.brawlwiki.ui.clubs;

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
import com.example.brawlwiki.database.BrawlStarsApi;
import com.example.brawlwiki.models.clubranking.ClubRankingList;
import com.example.brawlwiki.models.players.Player;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClubsFragment extends Fragment {

    private static final String LOG_TAG = ClubsFragment.class.getSimpleName();

    private ClubsViewModel mClubsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mClubsViewModel = ViewModelProviders.of(this).get(ClubsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clubs, container, false);
        final TextView textView = root.findViewById(R.id.text_clubs);
        mClubsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.brawlstars.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BrawlStarsApi brawlStarsApi = retrofit.create(BrawlStarsApi.class);
        Call<ClubRankingList> call = brawlStarsApi.getClubList();
        call.enqueue(new Callback<ClubRankingList>() {
            @Override
            public void onResponse(Call<ClubRankingList> call, Response<ClubRankingList> response) {
                if (!response.isSuccessful()) {
                    Log.d(LOG_TAG, "onResponse: " + response.code());
                }

                Log.d(LOG_TAG, "onResponse: " + response.body().getItems().size());
            }

            @Override
            public void onFailure(Call<ClubRankingList> call, Throwable t) {
                Log.d(LOG_TAG, "onResponse: " + t.getMessage());
            }
        });

        return root;
    }
}
