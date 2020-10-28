package com.example.brawlwiki.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brawlwiki.R;
import com.example.brawlwiki.databinding.FragmentSettingsBinding;


public class SettingsFragment extends Fragment {

    private static final String TAG = SettingsFragment.class.getSimpleName();

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

        mBinding.tvSettingsNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNotificationsFragment();
            }
        });

        mBinding.tvSettingsAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAboutFragment();
            }
        });

        return view;
    }

    private void goToFragment() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String myTag = sharedPreferences.getString("MyTag", "");
        //Log.d(TAG, "goToFragment: " + myTag);
        if (myTag.equals("")) {
            Navigation.findNavController(getView()).navigate(R.id.nav_home);
        } else {
            Navigation.findNavController(getView()).navigate(R.id.nav_profile_settings);
        }

    }

    private void goToAboutFragment() {
        Navigation.findNavController(getView()).navigate(R.id.nav_about);
    }

    private void goToNotificationsFragment() {
        Navigation.findNavController(getView()).navigate(R.id.nav_notifications);
    }
}