package com.brawl.brawlwiki.ui.settings.settingsoptions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brawl.brawlwiki.R;
import com.brawl.brawlwiki.TokenLoginActivity;
import com.brawl.brawlwiki.databinding.FragmentProfileSettingsBinding;


public class ProfileSettingsFragment extends Fragment {

    private FragmentProfileSettingsBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
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
        String tag = sharedPreferences.getString(getResources().getString(R.string.my_tag), "");
        if (!tag.equals("")) {
            String newTag = getResources().getString(R.string.hash_tag) + tag.substring(1);
            mBinding.tvPlayerTag.setText(newTag);
        } else {
            mBinding.tvPlayerTag.setText(getResources().getString(R.string.tag_not_set));
        }
    }

    private void setStatusOfToken() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String token = sharedPreferences.getString(getResources().getString(R.string.my_token), "");
        if (token.equals("")) {
            mBinding.tvPlayerToken.setText(getResources().getString(R.string.token_not_set));
        } else {
            mBinding.tvPlayerToken.setText(getResources().getString(R.string.token_is_set));
        }
    }

    private void deletePlayerToken() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String token = sharedPreferences.getString(getResources().getString(R.string.my_token), "");

        if (token.equals("")) {
            Toast.makeText(getContext(), getResources().getString(R.string.token_not_set), Toast.LENGTH_SHORT).show();
        } else {
            sharedPreferences.edit().remove(getResources().getString(R.string.my_token)).apply();
            goToTokenLoginActivity();
        }

    }

    private void goToTokenLoginActivity() {
        Intent intent = new Intent(getContext(), TokenLoginActivity.class);
        startActivity(intent);
    }

    private void deletePlayerTag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tag = sharedPreferences.getString(getResources().getString(R.string.my_tag), "");

        if (tag.equals("")) {
            Toast.makeText(getContext(), getResources().getString(R.string.tag_not_set), Toast.LENGTH_SHORT).show();
        }
         else {
            sharedPreferences.edit().remove(getResources().getString(R.string.my_tag)).apply();

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