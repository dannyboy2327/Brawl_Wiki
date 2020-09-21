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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.brawlwiki.R;
import com.example.brawlwiki.database.BrawlStarsApi;
import com.example.brawlwiki.models.clubRanking.Club;
import com.example.brawlwiki.models.clubRanking.ItemClub;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;

public class ClubsFragment extends Fragment {

    private static final String LOG_TAG = ClubsFragment.class.getSimpleName();

    private ClubsViewModel mClubsViewModel;
    private List<ItemClub> mItemClubList = new ArrayList<>();

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
        Call<Club> call = brawlStarsApi.getClubs();
        call.enqueue(new Callback<Club>() {
            @Override
            public void onResponse(Call<Club> call, Response<Club> response) {
                if (!response.isSuccessful()) {
                    Log.d(LOG_TAG, "onResponseNotSuccessful: " + response.code());
                    return;
                }

                Club club = response.body();
                club.getItemClubs();

                Log.d(LOG_TAG, "onResponse: " + club.getItemClubs().size());
            }

            @Override
            public void onFailure(Call<Club> call, Throwable t) {
                Log.d(LOG_TAG, "onFailure: " + t.getMessage());
            }
        });
        return root;
    }
}
