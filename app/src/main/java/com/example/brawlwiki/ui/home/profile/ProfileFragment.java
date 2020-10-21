package com.example.brawlwiki.ui.home.profile;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brawlwiki.R;
import com.example.brawlwiki.databinding.FragmentProfileBinding;
import com.example.brawlwiki.models.profile.Player;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private ProfileViewModel mProfileViewModel;
    private FragmentProfileBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mProfileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View root = mBinding.getRoot();

        mProfileViewModel.getPlayer().observe(getViewLifecycleOwner(), new Observer<Player>() {
            @Override
            public void onChanged(Player player) {
                //Log.d(TAG, "onChanged: " + player.getName() + "\n" + player.getTrophies());
                applyProfileData(player);
            }
        });

        return root;
    }

    private void applyProfileData(Player player) {
    }

}