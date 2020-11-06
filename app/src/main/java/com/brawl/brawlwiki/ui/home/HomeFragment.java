package com.brawl.brawlwiki.ui.home;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import com.brawl.brawlwiki.R;
import com.brawl.brawlwiki.databinding.FragmentHomeBinding;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.analytics.FirebaseAnalytics;


public class HomeFragment extends Fragment {

    //private static final String TAG = HomeFragment.class.getSimpleName();

    private FragmentHomeBinding mBinding;
    private SimpleExoPlayer mSimpleExoPlayer;
    private boolean playWhenReady = false;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    private static FirebaseAnalytics firebaseAnalytics;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View root = mBinding.getRoot();

        firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());

        setTagToEditText();
        onSearchProfileClick();

        return root;
    }

    private void setTagToEditText() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        if (!sharedPreferences.getString(getResources().getString(R.string.my_tag), "").isEmpty()) {
            String tag = getResources().getString(R.string.hash_tag) + sharedPreferences.getString(getResources().getString(R.string.my_tag), "").substring(1);
            mBinding.editTextTag.setText(tag);
        }
    }

    private void onSearchProfileClick() {
        mBinding.imageButtonSearchPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = getResources().getString(R.string.percentage) + mBinding.editTextTag.getText().toString().substring(1);
                //Log.d(TAG, "onClick: " + tag);
                setTagToSharePreferences(tag);

                Bundle bundle = new Bundle();
                bundle.putString(getResources().getString(R.string.bundle_tag), tag);

                secondNavNavigateToSettings();

                Navigation.findNavController(v).navigate(R.id.nav_profile, bundle);
                firebaseAnalytics.logEvent(getString(R.string.firebase_tag_key), bundle);
            }
        });
    }

    private void secondNavNavigateToSettings() {
        boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        int orientation = getResources().getConfiguration().orientation;
        if (isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_secondary_host_fragment);
            navController.navigate(R.id.nav_settings);
        }
    }

    private void setTagToSharePreferences(String tag) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getResources().getString(R.string.my_tag), tag);
        editor.apply();
    }

    /**
     * Private method initializePlayer to create  SimpleExoPlayer object
     */

    private void initializePlayer() {
        mSimpleExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
        mBinding.exoPlayerTutorial.setPlayer(mSimpleExoPlayer);
        Uri uri = RawResourceDataSource.buildRawResourceUri(R.raw.tutorial);
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
        mBinding.exoPlayerTutorial.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
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