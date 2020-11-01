package com.example.brawlwiki.ui.settings;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.brawlwiki.R;
import com.example.brawlwiki.TokenLoginActivity;
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

        mBinding.tvSettingsAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAboutFragment();
            }
        });

        return view;
    }

    private void goToFragment() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String myTag = sharedPreferences.getString("MyTag", "");
        String myToken = sharedPreferences.getString("MyToken", "");
        //Log.d(TAG, "goToFragment: " + myTag);
        if (myTag.equals("") && myToken.equals("")) {
            Toast.makeText(getContext(), "Please input your token to access brawl stars data.", Toast.LENGTH_LONG).show();
            goToLoginActivity();

        } else {

            if (myTag.equals("")) {
                Toast.makeText(getContext(), "Tag is missing. Please input your tag on home screen", Toast.LENGTH_LONG).show();
            } else if(myToken.equals("")) {
                Toast.makeText(getContext(), "Token is missing. Please input your token on initial screen", Toast.LENGTH_LONG).show();
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