package com.example.brawlwiki.ui.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.brawlwiki.R;
import com.example.brawlwiki.TokenLoginActivity;
import com.example.brawlwiki.databinding.FragmentSettingsBinding;

import java.net.URL;


public class SettingsFragment extends Fragment {

    //private static final String TAG = SettingsFragment.class.getSimpleName();

    private FragmentSettingsBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        View view = mBinding.getRoot();

        mBinding.tvSettingsProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFragment();
            }
        });

        mBinding.tvSettingsAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAboutFragment();
            }
        });

        mBinding.tvSettingsRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGooglePlayStore();
            }
        });

        return view;
    }

    private void goToGooglePlayStore() {
        Uri googleUri = Uri.parse("market://details?id=com.brawl.brawlwiki");
        Intent intent = new Intent(Intent.ACTION_VIEW, googleUri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.brawl.brawlwiki");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(webIntent);
        }
    }

    private void goToFragment() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String myTag = sharedPreferences.getString(getResources().getString(R.string.my_tag), "");
        String myToken = sharedPreferences.getString(getResources().getString(R.string.my_token), "");
        //Log.d(TAG, "goToFragment: " + myTag);
        if (myTag.equals("") && myToken.equals("")) {
            Toast.makeText(getContext(), getResources().getString(R.string.settings_token_reminder), Toast.LENGTH_LONG).show();
            goToLoginActivity();

        } else {

            if (myTag.equals("")) {
                Toast.makeText(getContext(), getResources().getString(R.string.settings_tag_missing), Toast.LENGTH_LONG).show();
            } else if(myToken.equals("")) {
                Toast.makeText(getContext(), getResources().getString(R.string.settings_token_missing), Toast.LENGTH_LONG).show();
            }

            Navigation.findNavController(getView()).navigate(R.id.nav_profile_settings);
        }

    }

    private void goToLoginActivity() {
        Intent intent = new Intent(getActivity().getApplicationContext(), TokenLoginActivity.class);
        startActivity(intent);
    }

    private void goToAboutFragment() {
        Navigation.findNavController(getView()).navigate(R.id.nav_about);
    }

}