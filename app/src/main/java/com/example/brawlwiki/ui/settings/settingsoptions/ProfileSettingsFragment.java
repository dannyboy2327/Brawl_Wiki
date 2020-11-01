package com.example.brawlwiki.ui.settings.settingsoptions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brawlwiki.R;
import com.example.brawlwiki.TokenLoginActivity;
import com.example.brawlwiki.databinding.FragmentProfileSettingsBinding;


public class ProfileSettingsFragment extends Fragment {

    private FragmentProfileSettingsBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_settings, container, false);
        View root = mBinding.getRoot();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tag = sharedPreferences.getString("MyTag", "");
        if (!tag.equals("")) {
            mBinding.tvPlayerTag.setText("#" + sharedPreferences.getString("MyTag", "").substring(1));
        } else {
            mBinding.tvPlayerTag.setText(sharedPreferences.getString("MyTag", ""));
        }
        mBinding.tvPlayerToken.setText(sharedPreferences.getString("MyToken", ""));

        mBinding.btResetTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePlayerTag();
            }
        });

        mBinding.btResetToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePlayerToken();
            }
        });

        return root;
    }

    private void deletePlayerToken() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        sharedPreferences.edit().remove("MyToken").apply();
        goToTokenLoginActivity();
    }

    private void goToTokenLoginActivity() {
        Intent intent = new Intent(getContext(), TokenLoginActivity.class);
        startActivity(intent);
    }

    private void deletePlayerTag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        sharedPreferences.edit().remove("MyTag").apply();
        Navigation.findNavController(getView()).navigate(R.id.nav_home);
    }
}