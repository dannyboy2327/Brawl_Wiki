package com.example.brawlwiki.ui.settings.settingsoptions;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brawlwiki.R;
import com.example.brawlwiki.databinding.FragmentProfileSettingsBinding;


public class ProfileSettingsFragment extends Fragment {

    private FragmentProfileSettingsBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_settings, container, false);
        View root = mBinding.getRoot();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        mBinding.tvPlayerTag.setText("#" + sharedPreferences.getString("MyTag", "").substring(1));

        mBinding.btResetProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePlayerTag();
            }
        });

        return root;
    }

    private void deletePlayerTag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        sharedPreferences.edit().clear().apply();
    }
}