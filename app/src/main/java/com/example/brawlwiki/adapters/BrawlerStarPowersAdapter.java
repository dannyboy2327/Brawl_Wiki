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
import com.example.brawlwiki.models.profile.BrawlerStatStarPower;

import java.util.List;

public class BrawlerStarPowersAdapter extends RecyclerView.Adapter<BrawlerStarPowersAdapter.BrawlerStarPowersViewHolder> {

    private Context mContext;
    private List<BrawlerStatStarPower> mBrawlerStatStarPowerList;

    public BrawlerStarPowersAdapter(Context context, List<BrawlerStatStarPower> brawlerStatStarPowerList) {
        mContext = context;
        mBrawlerStatStarPowerList = brawlerStatStarPowerList;
    }

    @NonNull
    @Override
    public BrawlerStarPowersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.star_power_list_item, parent, false);
        return new BrawlerStarPowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrawlerStarPowersViewHolder holder, int position) {
        BrawlerStatStarPower brawlerStatStarPower = this.mBrawlerStatStarPowerList.get(position);
        String not_unlocked = "Haven't unlocked any star powers!";

        if (brawlerStatStarPower.getName() == null) {
            holder.mStarPowerNameTextView.setText(not_unlocked);
        } else {
            holder.mStarPowerNameTextView.setText(brawlerStatStarPower.getName());
        }

        switch (brawlerStatStarPower.getId()) {

            //Shelly Shell Shock
            case 23000076:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_shelly_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_shelly_one);
                break;
            //Shelly Band-Aid
            case 23000135:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_shelly_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_shelly_two);
                break;
            //Colt Slick Boots
            case 23000077:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_colt_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_colt_one);
                break;
            //Colt Magnum Special
            case 23000138:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_colt_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_colt_two);
                break;
            //Bull Berserker
            case 23000078:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bull_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bull_one);
                break;
            //Bull Tough Guy
            case 23000137:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bull_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bull_two);
                break;
            //Brock Incendiary
            case 23000079:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_brock_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_brock_one);
                break;
            //Brock Rocket No. 4
            case 23000150:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_brock_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_brock_two);
                break;
            //Rico Super Bouncy
            case 23000080:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_rico_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_rico_one);
                break;
            //Rico Robo Retreat
            case 23000156:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_rico_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_rico_two);
                break;
            //Spike Fertilize
            case 23000081:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_spike_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_spike_one);
                break;
            //Spike Curveball
            case 23000151:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_spike_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_spike_two);
                break;
            //Barley Medical Use
            case 23000082:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_barley_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_barley_one);
                break;
            //Barley Extra Noxious
            case 23000158:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_barley_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_barley_two);
                break;
            //Jessie Energize
            case 23000083:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_jessie_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_jessie_one);
                break;
            //Jessie Shocky
            case 23000149:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_jessie_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_jessie_two);
                break;
            //Nita Bear With Me
            case 23000084:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_nita_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_nita_one);
                break;
            //Nita Hyper Bear
            case 23000136:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_nita_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_nita_two);
                break;
            //Dynamike Dyna-jump
            case 23000085:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_dynamike_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_dynamike_one);
                break;
            //Dynamike Demolition
            case 23000155:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_dynamike_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_dynamike_two);
                break;
            //Primo El Fuego
            case 23000086:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_primo_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_primo_one);
                break;
            //Primo Meteor Rush
            case 23000140:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_primo_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_primo_two);
                break;
            //Mortis Creepy Harvest
            case 23000087:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_mortis_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_mortis_one);
                break;
            //Mortis Coiled Snake
            case 23000154:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_mortis_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_mortis_two);
                break;
            //Crow Extra Toxic
            case 23000088:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_crow_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_crow_one);
                break;
            //Crow Carrion Crow
            case 23000143:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_crow_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_crow_two);
                break;
            //Poco Da Capo
            case 23000089:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_poco_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_poco_one);
                break;
            //Poco Screeching Solo
            case 23000144:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_poco_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_poco_two);
                break;
            //Bo Circling Eagle
            case 23000090:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bo_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bo_one);
                break;
            //Bo Snare A Bear
            case 23000148:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bo_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bo_two);
                break;
            //Piper Ambush
            case 23000091:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_piper_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_piper_one);
                break;
            //Piper Snappy Sniping
            case 23000152:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_piper_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_piper_two);
                break;
            //Pam Mamas Hug
            case 23000092:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_pam_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_pam_one);
                break;
            //Pam Mamas squeeze
            case 23000139:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_pam_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_pam_two);
                break;
            //Tara Black Portal
            case 23000093:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_tara_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_tara_one);
                break;
            //Tara Healing Shade
            case 23000160:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_tara_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_tara_two);
                break;
            //Darryl Steel Hoops
            case 23000094:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_darryl_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_darryl_one);
                break;
            //Darryl Rolling Reload
            case 23000157:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_darryl_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_darryl_two);
                break;
            //Penny Last Blast
            case 23000099:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_penny_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_penny_one);
                break;
            //Penny Balls Of Fire
            case 23000142:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_penny_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_penny_two);
                break;
            //Frank Power Grab
            case 23000104:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_frank_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_frank_one);
                break;
            //Frank Sponge
            case 23000153:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_frank_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_frank_two);
                break;
            //Gene Magic Puffs
            case 23000109:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_gene_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_gene_one);
                break;
            //Gene Spirit Slap
            case 23000159:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_gene_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_gene_two);
                break;
            //Tick Well Oiled
            case 23000114:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_tick_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_tick_one);
                break;
            //Tick Automa-tick Reload
            case 23000161:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_tick_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_tick_two);
                break;
            //Leon Smoke Trails
            case 23000119:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_leon_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_leon_one);

                break;
            //Leon Invisiheal
            case 23000141:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_leon_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_leon_two);
                break;
            //Rosa Plant Life
            case 23000124:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_rosa_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_rosa_one);
                break;
            //Rosa Thorny Gloves
            case 23000147:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_rosa_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_rosa_two);
                break;
            //Carl Power Throw
            case 23000129:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_carl_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_carl_one);
                break;
            //Carl Protective Pirouette
            case 23000145:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_carl_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_carl_two);
                break;
            //Bibi Home Run
            case 23000134:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bibi_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bibi_one);
                break;
            //Bii Batting Stance
            case 23000146:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bibi_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bibi_two);
                break;
            //Bit Boosted Booster
            case 23000168:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bit_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bit_one);
                break;
            //Bit Plugged In
            case 23000181:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bit_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bit_two);
                break;
            //Sandy Rude Sands
            case 23000186:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_sandy_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_sandy_one);
                break;
            //Sandy Healing Winds
            case 23000187:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_sandy_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_sandy_two);
                break;
            //Bea Insta Reload
            case 23000192:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bea_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bea_one);
                break;
            //Bea Honey Coat
            case 23000193:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_bea_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_bea_two);
                break;
            //Emz Bad Karma
            case 23000198:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_emz_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_emz_one);
                break;
            //Emz Hype
            case 23000199:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_emz_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_emz_two);
                break;
            //Mr. P Handle With Care
            case 23000204:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_mrp_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_mrp_one);
                break;
            //Mr. P Revolving Door
            case 23000205:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_mrp_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_mrp_two);
                break;
            //Max Super Charged
            case 23000210:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_max_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_max_one);
                break;
            //Max Run N Gun
            case 23000211:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_max_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_max_two);
                break;
            //Jacky Counter Crush
            case 23000222:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_jacky_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_jacky_one);
                break;
            //Jacky Hardy Hard Hat
            case 23000223:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_jacky_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_jacky_two);
                break;
            //Gale Blustery Blow
            case 23000228:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_gale_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_gale_one);
                break;
            //Gale Freezing Snow
            case 23000229:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_gale_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_gale_two);
                break;
            //Nani AutoFocus
            case 23000234:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_nani_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_nani_one);
                break;
            //Nani Tempered Steel
            case 23000235:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_nani_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_nani_two);
                break;
            //Sprout Overgrowth
            case 23000240:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_sprout_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_sprout_one);
                break;
            //Sprout Photosynthesis
            case 23000241:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_sprout_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_sprout_two);
                break;
            //Surge TO The Max
            case 23000283:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_surge_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_surge_one);
                break;
            //Surge Serve Ice Cold
            case 23000284:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_surge_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_surge_two);
                break;
            //Colette Push It
            case 23000300:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_colette_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_colette_one);
                break;
            //Colette Mass Tax
            case 23000301:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_colette_two);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_colette_two);
                break;
            //Amber Wild Flames
            case 23000307:
                holder.mStarPowerBadgeImageView.setImageResource(R.drawable.star_amber_one);
                holder.mStarPowerDescriptionTextView.setText(R.string.star_amber_one);
                break;
            default:

        }
    }

    @Override
    public int getItemCount() {
        return mBrawlerStatStarPowerList.size();
    }

    public static class BrawlerStarPowersViewHolder extends RecyclerView.ViewHolder {

        private TextView mStarPowerNameTextView;
        private ImageView mStarPowerBadgeImageView;
        private TextView mStarPowerDescriptionTextView;

        public BrawlerStarPowersViewHolder(@NonNull View itemView) {
            super(itemView);

            mStarPowerNameTextView = itemView.findViewById(R.id.tv_details_star_power_name);
            mStarPowerBadgeImageView = itemView.findViewById(R.id.iv_details_star_power_badge);
            mStarPowerDescriptionTextView = itemView.findViewById(R.id.tv_details_start_power_description);
        }
    }
}
