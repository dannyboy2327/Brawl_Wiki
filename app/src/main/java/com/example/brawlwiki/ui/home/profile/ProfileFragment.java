package com.example.brawlwiki.ui.home.profile;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.brawlwiki.R;
import com.example.brawlwiki.adapters.ProfileAdapter;
import com.example.brawlwiki.databinding.FragmentProfileBinding;
import com.example.brawlwiki.models.profile.BrawlerStat;
import com.example.brawlwiki.models.profile.Player;
import com.example.brawlwiki.network.ApiClient;
import com.example.brawlwiki.network.BrawlStarsApi;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private ProfileViewModel mProfileViewModel;
    private FragmentProfileBinding mBinding;
    private final BrawlStarsApi mBrawlStarsApi = ApiClient.getBrawlStarsClient().create(BrawlStarsApi.class);
    private boolean isConnected;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mProfileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View root = mBinding.getRoot();


        getActiveNetwork();

        if (isConnected) {
            String tag = getProfileTag();
            getProfileData(tag);
        }

        mProfileViewModel.getPlayer().observe(getViewLifecycleOwner(), new Observer<Player>() {
            @Override
            public void onChanged(Player player) {
                //Log.d(TAG, "onChanged: " + player.getName() + "\n" + player.getTrophies());
                if (!(player == null)) {
                    setProfileData(player);
                    setProfileIcon(player);
                    setProfileAdapter(player);
                }
            }
        });

        return root;
    }

    private void getActiveNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        //Log.d(TAG, "getActiveNetwork: " + isConnected);
    }

    private String getProfileTag() {
        //Log.d(TAG, "onCreateView: " + getArguments().getString("tag"));
        return getArguments().getString("tag");
    }

    private void getProfileData(String tag) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        mBrawlStarsApi.getPlayer("Bearer " + sharedPreferences.getString("MyToken", ""), tag).enqueue(new Callback<Player>() {
            @Override
            public void onResponse(@NonNull Call<Player> call, @NonNull Response<Player> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse not successful: " + response.code());
                }

                Log.d(TAG, "onResponse: ");
                assert response.body() != null;
                setProfileData(response.body());
                setProfileIcon(response.body());
                setProfileAdapter(response.body());
                mProfileViewModel.insertProfile(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Player> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setProfileData(Player player) {

        mBinding.tvProfileName.setText(player.getName());
        mBinding.tvProfileName.setTextColor(Color.parseColor("#" + player.getNameColor().substring(2)));
        mBinding.tvProfileTag.setText("#" + player.getTag().substring(1));

        mBinding.tvProfileLevel.setText(Integer.toString(player.getExpLevel()));
        mBinding.tvProfileExp.setText(Integer.toString(player.getExpPoints()));
        mBinding.tvProfileTrophies.setText(Integer.toString(player.getTrophies()));

        mBinding.tvProfileHighestTrophies.setText(Integer.toString(player.getHighestTrophies()));
        //mBinding.tvProfilePowerPlayPoints.setText(Integer.toString(player.getPowerPlayPoints()));
        mBinding.tvProfileHighestPowerPlayPoints.setText(Integer.toString(player.getHighestPowerPlayPoints()));

        mBinding.tvProfile3Vs3Victories.setText(Integer.toString(player.get3vs3Victories()));
        mBinding.tvProfileSoloVictories.setText(Integer.toString(player.getSoloVictories()));
        mBinding.tvProfileDuoVictories.setText(Integer.toString(player.getDuoVictories()));

        mBinding.tvProfileRoboRumbleTime.setText(Integer.toString(player.getBestRoboRumbleTime()));
        mBinding.tvProfileBigBrawlerTime.setText(Integer.toString(player.getBestTimeAsBigBrawler()));
        mBinding.tvProfileQualification.setText(player.getIsQualifiedFromChampionshipChallenge().toString());

    }

    private void setProfileIcon(Player player) {

        switch (player.getPlayerIcon().getId()) {
            case 28000000:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_skull);
                break;
            //robot
            case 28000001:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_robot);
                break;
            //slime
            case 28000002:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_slime);
                break;
            //shelly
            case 28000003:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_shelly);
                break;
            //colt
            case 28000004:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_colt);
                break;
            //brock
            case 28000005:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_brock);
                break;
            //jessie
            case 28000006:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_jessie);
                break;
            //nita
            case 28000007:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_nita);
                break;
            //dynamike
            case 28000008:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_dynamike);
                break;
            //el primo
            case 28000009:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_primo);
                break;
            //bull
            case 28000010:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bull);
                break;
            //rico
            case 28000011:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_rico);
                break;
            //barley
            case 28000012:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_barley);
                break;
            //poco
            case 28000013:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_poco);
                break;
            //mortis
            case 28000014:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_mortis);
                break;
            //bo
            case 28000015:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bo);
                break;
            //spike
            case 28000016:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_spike);
                break;
            //crow
            case 28000017:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_crow);
                break;
            //piper
            case 28000018:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_piper);
                break;
            //bandit
            case 28000019:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bandit);
                break;
            //star
            case 28000020:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_star);
                break;
            //crown
            case 28000021:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_crown);
                break;
            //bottle
            case 28000022:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bottle);
                break;
            //red skull
            case 28000023:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_red_skull);
                break;
            //1st trophy
            case 28000024:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_first_trophy);
                break;
            //2nd trophy
            case 28000025:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_second_trophy);
                break;
            //3rd trophy
            case 28000026:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_third_trophy);
                break;
            //4th trophy
            case 28000027:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_fourth_trophy);
                break;
            //pam
            case 28000028:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_pam);
                break;
            //tara
            case 28000029:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_tara);
                break;
            //5th trophy
            case 28000030:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_fifth_trophy);
                break;
            //6th trophy
            case 28000031:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_sixth_trophy);
                break;
            //7th trophy
            case 28000032:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_seventh_trophy);
                break;
            //8th trophy
            case 28000033:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_eigth_trophy);
                break;
            //darryl
            case 28000034:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_darryl);
                break;
            //penny
            case 28000035:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_penny);
                break;
            //frank
            case 28000036:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_frank);
                break;
            //leon
            case 28000037:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_leon);
                break;
            //gene
            case 28000038:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_gene);
                break;
            //carl
            case 28000039:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_carl);
                break;
            //rosa
            case 28000040:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_rosa);
                break;
            //bibi
            case 28000041:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bibi);
                break;
            //tick
            case 28000042:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_tick);
                break;
            //8-bit
            case 28000043:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bit);
                break;
            //sandy
            case 28000044:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_sandy);
                break;
            //emz
            case 28000045:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_emz);
                break;
            //bea
            case 28000046:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_bea);
                break;
            //max
            case 28000047:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_max);
                break;
            //mrp
            case 28000048:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_mrp);
                break;
            //jacky
            case 28000049:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_jacky);
                break;
            //sprout
            case 28000050:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_sprout);
                break;
            //surge
            case 28000051:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_surge);
                break;
            //nani
            case 28000052:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_nani);
                break;
            //surge
            case 28000053:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_surge);
                break;
            //colette
            case 28000054:
                mBinding.ivProfileIcon.setImageResource(R.drawable.player_colette);
                break;
            default:
        }
    }

    private void setProfileAdapter(Player player) {
        int orientation = getOrientation();
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            mBinding.rvProfile.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            mBinding.rvProfile.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        mBinding.rvProfile.setHasFixedSize(true);
        ProfileAdapter profileAdapter = new ProfileAdapter(getContext(), player.getBrawlerStatList(), new ProfileAdapter.BrawlerClickListener() {
            @Override
            public void onBrawlerClick(BrawlerStat brawlerStat) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("brawler_stat", brawlerStat);
                Navigation.findNavController(getView()).navigate(R.id.nav_brawler_details, bundle);
            }
        });

        mBinding.rvProfile.setAdapter(profileAdapter);
    }

    private int getOrientation() {
        return getActivity().getResources().getConfiguration().orientation;
    }

}