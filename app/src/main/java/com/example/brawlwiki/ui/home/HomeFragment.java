package com.example.brawlwiki.ui.home;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.brawlwiki.R;
import com.example.brawlwiki.network.BrawlStarsApi;
import com.example.brawlwiki.models.players.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private static final String LOG_TAG = HomeFragment.class.getSimpleName();

    private HomeViewModel homeViewModel;

    private AdView mAdView;

    private ImageButton mImageButton;

    private PlayerView mPlayerView;
    private SimpleExoPlayer mSimpleExoPlayer;
    private boolean playWhenReady = false;
    private int currentWindow = 0;
    private long playbackPosition = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mPlayerView = root.findViewById(R.id.exoPlayer_tutorial);

        mImageButton = root.findViewById(R.id.imageButton_search_player);
        //OnClickListener to swap Fragments
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //Displays Ad Banner for Home Fragment
        displayAdBannerView(root);

        return root;
    }


    /**
     * Loads an Ad for the home fragment
     *
     * @param root The root source of the layout for home fragment
     */

    private void displayAdBannerView(View root) {
        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = root.findViewById(R.id.adView_main_ad);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Private method initializePlayer to create  SimpleExoPlayer object
     */

    private void initializePlayer() {
        mSimpleExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
        mPlayerView.setPlayer(mSimpleExoPlayer);
        //String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.tutorial;
        Uri uri = Uri.parse("https://streamable.com/zg2dkg");
        MediaSource mediaSource = buildMediaSource(uri);
        mSimpleExoPlayer.setPlayWhenReady(playWhenReady);
        mSimpleExoPlayer.seekTo(currentWindow, playbackPosition);
        mSimpleExoPlayer.prepare(mediaSource, false, false);
    }

    /**
     *
     * @param uri This method takes a Uri as its parameter, containing the URI
     *            of the tutorial media.
     * @return    This returns the MediaSource object
     */

    private MediaSource buildMediaSource(Uri uri) {
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(getContext(), "exoplayer-tutorial");
        return  new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
    }



    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        mPlayerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    /**
     *  The releasePlayer method frees the player's resources and destroys it
     */

    private void releasePlayer() {
        if (mSimpleExoPlayer != null) {
            playWhenReady = mSimpleExoPlayer.getPlayWhenReady();
            playbackPosition = mSimpleExoPlayer.getCurrentPosition();
            currentWindow = mSimpleExoPlayer.getCurrentWindowIndex();
            mSimpleExoPlayer.release();
            mSimpleExoPlayer = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideSystemUi();
        if (Util.SDK_INT < 24 || mSimpleExoPlayer == null) {
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }
}