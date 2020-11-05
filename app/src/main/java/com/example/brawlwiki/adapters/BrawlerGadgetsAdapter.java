package com.example.brawlwiki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlwiki.R;
import com.example.brawlwiki.models.profile.BrawlerStatGadget;

import java.util.List;

public class BrawlerGadgetsAdapter extends RecyclerView.Adapter<BrawlerGadgetsAdapter.BrawlerGadgetsViewHolder> {

    private Context mContext;
    private List<BrawlerStatGadget> mBrawlerStatGadgetList;

    public BrawlerGadgetsAdapter(Context context, List<BrawlerStatGadget> brawlerStatGadgetList) {
        mContext = context;
        mBrawlerStatGadgetList = brawlerStatGadgetList;
    }

    @NonNull
    @Override
    public BrawlerGadgetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gadget_list_item, parent, false);
        return new BrawlerGadgetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrawlerGadgetsViewHolder holder, int position) {
        BrawlerStatGadget brawlerStatGadget = this.mBrawlerStatGadgetList.get(position);
        String star_powers_unlocked = "Haven't unlocked any star powers!";

        if (mBrawlerStatGadgetList.size() == 0) {
            holder.mGadgetNameTextView.setText(star_powers_unlocked);
        } else {
            holder.mGadgetNameTextView.setText(brawlerStatGadget.getName());
        }

        switch (brawlerStatGadget.getId()) {

            //Shelly Fast Forward
            case 23000255:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_shelly_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_shelly_one);
                break;
            //Shelly Clay Pigeons
            case 23000288:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_shelly_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_shelly_two);
                break;
            //Colt Speedloader
            case 23000273:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_colt_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_colt_one);
                break;
            //Bull T-bone Injector
            case 23000272:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bull_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bull_one);
                break;
            //Bull Stomper
            case 23000310:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bull_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bull_two);
                break;
            //Brock Rocket Laces
            case 23000245:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_brock_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_brock_one);
                break;
            //Rico Multiball Launcher
            case 23000246:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_rico_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_rico_one);
                break;
            //Spike Popping Pincushion
            case 23000247:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_spike_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_spike_one);
                break;
            //Barley Sticky Syrup Mixer
            case 23000250:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_barley_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_barley_one);
                break;
            //Barley Herbal Tonic
            case 23000293:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_barley_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_barley_two);
                break;
            //Jessie Spark Plug
            case 23000251:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_jessie_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_jessie_one);
                break;
            //Jessie Recoil Spring
            case 23000295:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_jessie_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_jessie_two);
                break;
            //Nita Bear Paws
            case 23000249:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_nita_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_nita_one);
                break;
            //Dynamike Fidget Spinner
            case 23000258:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_dynamike_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_dynamike_one);
                break;
            //Dynamike Satchel Charge
            case 23000294:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_dynamike_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_dynamike_two);
                break;
            //Primo Suplex Supplement
            case 23000264:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_primo_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_primo_one);
                break;
            //Primo Asteroid Belt
            case 23000292:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_primo_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_primo_two);
                break;
            //Mortis Combo Spinner
            case 23000265:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_mortis_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_mortis_one);
                break;
            //Mortis Survival Shovel
            case 23000290:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_mortis_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_mortis_two);
                break;
            //Crow Defense Booster
            case 23000243:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_crow_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_crow_one);
                break;
            //Crow Slowing Toxin
            case 23000286:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_crow_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_crow_two);
                break;
            //Poco Tuning Fork
            case 23000267:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_poco_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_poco_one);
                break;
            //Bo Super Totem
            case 23000263:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bo_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bo_one);
                break;
            //Bo Tripwire
            case 23000289:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bo_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bo_two);
                break;
            //Piper Auto Aimer
            case 23000268:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_piper_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_piper_one);
                break;
            //Piper Homemade Recipe
            case 23000291:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_piper_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_piper_two);
                break;
            //Pam Pulse Modulator
            case 23000257:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_pam_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_pam_one);
                break;
            //Tara Psychic Enhancer
            case 23000266:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_tara_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_tara_one);
                break;
            //Darryl Recoiling Rotator
            case 23000260:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_darryl_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_darryl_one);
                break;
            //Darryl Tar Barrel
            case 23000313:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_darryl_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_darryl_two);
                break;
            //Penny Pocket Detonator
            case 23000248:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_penny_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_penny_one);
                break;
            //Penny Captain's compass
            case 23000287:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_penny_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_penny_two);
                break;
            //Frank Active Noise Canceling
            case 23000261:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_frank_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_frank_one);
                break;
            //Gene Lamp Blowout
            case 23000252:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_gene_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_gene_one);
                break;
            //Tick Backup Mine
            case 23000253:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_tick_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_tick_one);
                break;
            //Leon Clone Projector
            case 23000276:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_leon_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_leon_one);
                break;
            //Rosa Grow Light
            case 23000242:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_rosa_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_rosa_one);
                break;
            //Carl Heat Ejector
            case 23000262:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_carl_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_carl_one);
                break;
            //Bibi Vitamin Booster
            case 23000275:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bibi_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bibi_one);
                break;
            //Bit Cheat Cartridge
            case 23000259:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bit_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bit_one);
                break;
            //Sandy Sleep Simulator
            case 23000270:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_sandy_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_sandy_one);
                break;
            //Bea Honey Molasses
            case 23000271:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bea_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bea_one);
                break;
            //Bea Rattled Hive
            case 23000312:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_bea_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_bea_two);
                break;
            //Emz Friendzoner
            case 23000274:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_emz_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_emz_one);
                break;
            //Mr. P Service Bell
            case 23000269:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_mrp_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_mrp_one);
                break;
            //Max Phase Shifter
            case 23000254:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_max_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_max_one);
                break;
            //Max Sneaky Sneakers
            case 23000311:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_max_two);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_max_two);
                break;
            //Jacky Pneumatic Booster
            case 23000256:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_jacky_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_jacky_one);
                break;
            //Gale Spring Ejector
            case 23000277:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_gale_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_gale_one);
                break;
            //Nani Warp Blast
            case 23000278:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_nani_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_nani_one);
                break;
            //Sprout Garden Mulcher
            case 23000244:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_sprout_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_sprout_one);
                break;
            //Surge Power Surge
            case 23000285:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_surge_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_surge_one);
                break;
            //Colette Na-ah!
            case 23000302:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_colette_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_colette_one);
                break;
            //Amber Fire Starters
            case 23000309:
                holder.mGadgetBadgeImageView.setImageResource(R.drawable.gadget_amber_one);
                holder.mGadgetDescriptionTextView.setText(R.string.gadget_amber_one);
                break;
            default:

        }
    }

    @Override
    public int getItemCount() {
        return mBrawlerStatGadgetList.size();
    }

    public static class BrawlerGadgetsViewHolder extends RecyclerView.ViewHolder {

        private TextView mGadgetNameTextView;
        private ImageView mGadgetBadgeImageView;
        private TextView mGadgetDescriptionTextView;

        public BrawlerGadgetsViewHolder(@NonNull View itemView) {
            super(itemView);

            mGadgetNameTextView = itemView.findViewById(R.id.tv_details_gadget_name);
            mGadgetBadgeImageView = itemView.findViewById(R.id.iv_details_gadget_badge);
            mGadgetDescriptionTextView = itemView.findViewById(R.id.tv_details_gadget_description);
        }
    }
}
