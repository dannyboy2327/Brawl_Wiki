package com.example.brawlwiki.ui.players;

import android.os.Bundle;
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

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlayerFragment extends Fragment {

    private static final String LOG_TAG = PlayerFragment.class.getSimpleName();

    private PlayerViewModel mPlayerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPlayerViewModel =
                ViewModelProviders.of(this).get(PlayerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_players, container, false);
        final TextView textView = root.findViewById(R.id.text_players);
        mPlayerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.brawlstars.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BrawlStarsApi brawlStarsApi = retrofit.create(BrawlStarsApi.class);


        return root;
    }
}