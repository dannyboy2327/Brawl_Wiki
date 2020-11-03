package com.example.brawlwiki.ui.settings.settingsoptions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        setPlayerTag();

        setStatusOfToken();

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

    private void setPlayerTag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tag = sharedPreferences.getString("MyTag", "");
        if (!tag.equals("")) {
            mBinding.tvPlayerTag.setText("#" + sharedPreferences.getString("MyTag", "").substring(1));
        } else {
            mBinding.tvPlayerTag.setText("No tag is set.");
        }
    }

    private void setStatusOfToken() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String token = sharedPreferences.getString("MyToken", "");
        if (token.equals("")) {
            mBinding.tvPlayerToken.setText("No token is set.");
        } else {
            mBinding.tvPlayerToken.setText("Token is set.");
        }
    }

    private void deletePlayerToken() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String token = sharedPreferences.getString("MyToken", "");

        if (token.equals("")) {
            Toast.makeText(getContext(), "No token has been set", Toast.LENGTH_SHORT).show();
        } else {
            sharedPreferences.edit().remove("MyToken").apply();
            goToTokenLoginActivity();
        }

    }

    private void goToTokenLoginActivity() {
        Intent intent = new Intent(getContext(), TokenLoginActivity.class);
        startActivity(intent);
    }

    private void deletePlayerTag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tag = sharedPreferences.getString("MyTag", "");

        if (tag.equals("")) {
            Toast.makeText(getContext(), "No tag has been set", Toast.LENGTH_SHORT).show();
        }
         else {
            sharedPreferences.edit().remove("MyTag").apply();

            boolean isTablet = getResources().getBoolean(R.bool.isTablet);
            int orientation = getResources().getConfiguration().orientation;
            if (isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_home);
                Navigation.findNavController(getView()).navigate(R.id.nav_settings);
            } else {
                Navigation.findNavController(getView()).navigate(R.id.nav_home);
            }
        }
    }
}