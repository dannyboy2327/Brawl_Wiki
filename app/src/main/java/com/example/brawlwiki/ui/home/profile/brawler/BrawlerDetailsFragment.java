package com.example.brawlwiki.ui.home.profile.brawler;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brawlwiki.R;
import com.example.brawlwiki.adapters.BrawlerGadgetsAdapter;
import com.example.brawlwiki.adapters.BrawlerStarPowersAdapter;
import com.example.brawlwiki.databinding.FragmentBrawlerDetailsBinding;
import com.example.brawlwiki.models.profile.BrawlerStat;
import com.squareup.picasso.Picasso;


public class BrawlerDetailsFragment extends Fragment {

    private static final String TAG = BrawlerDetailsFragment.class.getSimpleName();

    private FragmentBrawlerDetailsBinding mBinding;
    private boolean isConnected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_brawler_details, container, false);
        View root = mBinding.getRoot();


        BrawlerStat brawlerStat = getBrawlerStat();
        //Log.d(TAG, "onCreateView: " + "\n" + brawlerStat.getName() + "\n" + brawlerStat.getTrophies() + "\n" + brawlerStat.getRank());
        setBrawlerDetails(brawlerStat);
        setBrawlerImage(brawlerStat);
        setBrawlerRankIcon(brawlerStat);
        setBrawlerDescription(brawlerStat);
        setBrawlerStarPowers(brawlerStat);
        setBrawlerGadgets(brawlerStat);

        return root;
    }

    private BrawlerStat getBrawlerStat() {
        assert getArguments() != null;
        return (BrawlerStat) getArguments().getSerializable("brawler_stat");
    }

    private void setBrawlerDetails(BrawlerStat brawlerStat) {
        mBinding.tvDetailsBrawlerName.setText(brawlerStat.getName());
        mBinding.tvDetailsBrawlerHighestTrophies.setText(Integer.toString(brawlerStat.getHighestTrophies()));
        mBinding.tvDetailsBrawlerRank.setText(Integer.toString(brawlerStat.getRank()));
        mBinding.tvDetailsBrawlerPowerLevel.setText(Integer.toString(brawlerStat.getPower()));
        mBinding.tvDetailsBrawlerTrophies.setText(Integer.toString(brawlerStat.getTrophies()));

    }

    private void setBrawlerGadgets(BrawlerStat brawlerStat) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.rvDetailsGadget.setLayoutManager(linearLayoutManager);
        mBinding.rvDetailsGadget.setHasFixedSize(true);
        BrawlerGadgetsAdapter brawlerGadgetsAdapter = new BrawlerGadgetsAdapter(getContext(), brawlerStat.getBrawlerStatGadgetList());
        mBinding.rvDetailsGadget.setAdapter(brawlerGadgetsAdapter);
    }

    private void setBrawlerStarPowers(BrawlerStat brawlerStat) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.rvDetailsStarPower.setLayoutManager(linearLayoutManager);
        mBinding.rvDetailsStarPower.setHasFixedSize(true);
        BrawlerStarPowersAdapter brawlerStarPowersAdapter = new BrawlerStarPowersAdapter(getContext(), brawlerStat.getBrawlerStatStarPowerList());
        mBinding.rvDetailsStarPower.setAdapter(brawlerStarPowersAdapter);
    }

    private void setBrawlerDescription(BrawlerStat brawlerStat) {

        switch (brawlerStat.getName()) {
            case "SHELLY":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_shelly);
                break;
            case "COLT":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_colt);
                break;
            case "BULL":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_bull);
                break;
            case "BROCK":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_brock);
                break;
            case "RICO":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_rico);
                break;
            case "SPIKE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_spike);
                break;
            case "BARLEY":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_barley);
                break;
            case "JESSIE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_jessie);
                break;
            case "NITA":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_nita);
                break;
            case "DYNAMIKE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_dynamike);
                break;
            case "EL PRIMO":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_primo);
                break;
            case "MORTIS":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_mortis);
                break;
            case "CROW":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_crow);
                break;
            case "POCO":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_poco);
                break;
            case "BO":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_bo);
                break;
            case "PIPER":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_piper);
                break;
            case "PAM":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_pam);
                break;
            case "TARA":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_tara);
                break;
            case "DARRYL":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_darryl);
                break;
            case "PENNY":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_penny);
                break;
            case "FRANK":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_frank);
                break;
            case "GENE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_gene);
                break;
            case "TICK":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_tick);
                break;
            case "LEON":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_leon);
                break;
            case "ROSA":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_rosa);
                break;
            case "CARL":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_carl);
                break;
            case "BIBI":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_bibi);
                break;
            case "8-BIT":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_bit);
                break;
            case "SANDY":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_sandy);
                break;
            case "BEA":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_bea);
                break;
            case "EMZ":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_emz);
                break;
            case "MR. P":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_mrp);
                break;
            case "MAX":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_max);
                break;
            case "JACKY":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_jacky);
                break;
            case "GALE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_gale);
                break;
            case "NANI":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_nani);
                break;
            case "SPROUT":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_sprout);
                break;
            case "SURGE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_surge);
                break;
            case "COLETTE":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_colette);
                break;
            case "AMBER":
                mBinding.tvDetailsBrawlerDescription.setText(R.string.description_amber);
                break;
            default:

        }
    }

    private void setBrawlerRankIcon(BrawlerStat brawlerStat) {

        int rank = brawlerStat.getRank();

        if (rank < 5) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_one);
        } else if (rank <= 9) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_two);
        } else if (rank <= 14) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_three);
        } else if (rank <= 19) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_four);
        } else if (rank <= 24) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_five);
        } else if (rank <= 29) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_six);
        } else if (rank <= 34) {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_seven);
        } else {
            mBinding.ivDetailsBrawlerRankIcon.setImageResource(R.drawable.profile_rank_eight);
        }
    }

    private void setBrawlerImage(BrawlerStat brawlerStat) {

        switch (brawlerStat.getId()) {
            case 16000000:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_shelly);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_shelly);
                break;
            case 16000001:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_colt);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_colt);
                break;
            case 16000002:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_bull);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_bull);
                break;
            case 16000003:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_brock);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_brock);
                break;
            case 16000004:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_rico);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_rico);
                break;
            case 16000005:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_spike);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_spike);
                break;
            case 16000006:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_barley);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_barley);
                break;
            case 16000007:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_jessie);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_jessie);
                break;
            case 16000008:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_nita);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_nita);
                break;
            case 16000009:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_dynamike);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_dynamike);
                break;
            case 16000010:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_primo);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_primo);
                break;
            case 16000011:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_mortis);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_mortis);
                break;
            case 16000012:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_crow);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_crow);
                break;
            case 16000013:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_poco);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_poco);
                break;
            case 16000014:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_bo);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_bo);
                break;
            case 16000015:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_piper);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_piper);
                break;
            case 16000016:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_pam);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_pam);
                break;
            case 16000017:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_tara);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_tara);
                break;
            case 16000018:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_darryl);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_darryl);
                break;
            case 16000019:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_penny);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_penny);
                break;
            case 16000020:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_frank);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_frank);
                break;
            case 16000021:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_gene);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_gene);
                break;
            case 16000022:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_tick);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_tick);
                break;
            case 16000023:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_leon);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_leon);
                break;
            case 16000024:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_rosa);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_rosa);
                break;
            case 16000025:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_carl);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_carl);
                break;
            case 16000026:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_bibi);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_bibi);
                break;
            case 16000027:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_bit);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_bit);
                break;
            case 16000028:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_sandy);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_sandy);
                break;
            case 16000029:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_bea);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_bea);
                break;
            case 16000030:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_emz);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_emz);
                break;
            case 16000031:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_mrp);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_mrp);
                break;
            case 16000032:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_max);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_max);
                break;
            case 16000034:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_jacky);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_jacky);
                break;
            case 16000035:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_gale);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_gale);
                break;
            case 16000036:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_nani);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_nani);
                break;
            case 16000037:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_sprout);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_sprout);
                break;
            case 16000038:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_surge);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_surge);
                break;
            case 16000039:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_colette);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_colette);
                break;
            case 16000040:
                mBinding.ivDetailsBrawlerImage.setImageResource(R.drawable.figure_amber);
                mBinding.ivDetailsBrawlerIcon.setImageResource(R.drawable.player_amber);
                break;
            default:
        }
    }
}