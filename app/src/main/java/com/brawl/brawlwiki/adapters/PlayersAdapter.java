package com.brawl.brawlwiki.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brawl.brawlwiki.R;
import com.brawl.brawlwiki.models.playerranking.PlayerRanking;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {

    private static final String TAG = PlayersAdapter.class.getSimpleName();

    private List<PlayerRanking> mPlayerRankingList;
    private Context mContext;

    public PlayersAdapter(Context context, List<PlayerRanking> playerRankingList) {
        mContext = context;
        mPlayerRankingList = playerRankingList;
    }


    @NonNull
    @Override
    public PlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_list_item, parent, false);
        return new PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersViewHolder holder, int position) {
        PlayerRanking playerRanking = mPlayerRankingList.get(position);
        holder.mPlayerRankTextView.setText(String.valueOf(playerRanking.getRank()));
        holder.mPlayerNameTextView.setText(playerRanking.getName());
        holder.mPlayerNameTextView.setTextColor(Color.parseColor("#" + playerRanking.getNameColor().substring(2)));
        holder.mPlayerTrophiesTextView.setText(String.valueOf(playerRanking.getTrophies()));

        switch (playerRanking.getPlayerRankingIcon().getId()) {
            //blue skull
            case 28000000:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_skull);
                break;
            //robot
            case 28000001:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_robot);
                break;
            //slime
            case 28000002:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_slime);
                break;
            //shelly
            case 28000003:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_shelly);
                break;
            //colt
            case 28000004:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_colt);
                break;
            //brock
            case 28000005:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_brock);
                break;
            //jessie
            case 28000006:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_jessie);
                break;
            //nita
            case 28000007:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_nita);
                break;
            //dynamike
            case 28000008:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_dynamike);
                break;
            //el primo
            case 28000009:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_primo);
                break;
            //bull
            case 28000010:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bull);
                break;
            //rico
            case 28000011:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_rico);
                break;
            //barley
            case 28000012:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_barley);
                break;
            //poco
            case 28000013:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_poco);
                break;
            //mortis
            case 28000014:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_mortis);
                break;
            //bo
            case 28000015:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bo);
                break;
            //spike
            case 28000016:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_spike);
                break;
            //crow
            case 28000017:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_crow);
                break;
            //piper
            case 28000018:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_piper);
                break;
            //bandit
            case 28000019:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bandit);
                break;
            //star
            case 28000020:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_star);
                break;
            //crown
            case 28000021:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_crown);
                break;
            //bottle
            case 28000022:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bottle);
                break;
            //red skull
            case 28000023:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_red_skull);
                break;
            //1st trophy
            case 28000024:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_first_trophy);
                break;
            //2nd trophy
            case 28000025:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_second_trophy);
                break;
            //3rd trophy
            case 28000026:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_third_trophy);
                break;
            //4th trophy
            case 28000027:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_fourth_trophy);
                break;
            //pam
            case 28000028:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_pam);
                break;
            //tara
            case 28000029:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_tara);
                break;
            //5th trophy
            case 28000030:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_fifth_trophy);
                break;
            //6th trophy
            case 28000031:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_sixth_trophy);
                break;
            //7th trophy
            case 28000032:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_seventh_trophy);
                break;
            //8th trophy
            case 28000033:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_eigth_trophy);
                break;
            //darryl
            case 28000034:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_darryl);
                break;
            //penny
            case 28000035:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_penny);
                break;
            //frank
            case 28000036:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_frank);
                break;
            //leon
            case 28000037:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_leon);
                break;
            //gene
            case 28000038:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_gene);
                break;
            //carl
            case 28000039:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_carl);
                break;
            //rosa
            case 28000040:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_rosa);
                break;
            //bibi
            case 28000041:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bibi);
                break;
            //tick
            case 28000042:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_tick);
                break;
            //8-bit
            case 28000043:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bit);
                break;
            //sandy
            case 28000044:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_sandy);
                break;
            //emz
            case 28000045:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_emz);
                break;
            //bea
            case 28000046:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_bea);
                break;
            //max
            case 28000047:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_max);
                break;
            //mrp
            case 28000048:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_mrp);
                break;
            //jacky
            case 28000049:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_jacky);
                break;
            //sprout
            case 28000050:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_sprout);
                break;
            //surge
            case 28000051:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_surge);
                break;
            //nani
            case 28000052:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_nani);
                break;
            //surge
            case 28000053:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_surge);
                break;
            //colette
            case 28000054:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_colette);
                break;
            //amber
            case 28000055:
                holder.mPlayerIconImageView.setImageResource(R.drawable.player_amber);
                break;
            default:
        }

    }

    @Override
    public int getItemCount() {
        return mPlayerRankingList.size();
    }

    public static class PlayersViewHolder extends RecyclerView.ViewHolder {

        private TextView mPlayerRankTextView;
        private ImageView mPlayerIconImageView;
        private TextView mPlayerNameTextView;
        private TextView mPlayerTrophiesTextView;

        public PlayersViewHolder(@NonNull View itemView) {
            super(itemView);

            mPlayerRankTextView = itemView.findViewById(R.id.tv_player_rank);
            mPlayerIconImageView = itemView.findViewById(R.id.iv_player_icon);
            mPlayerNameTextView = itemView.findViewById(R.id.tv_player_name);
            mPlayerTrophiesTextView = itemView.findViewById(R.id.tv_player_trophies);
        }
    }
}
