package com.example.brawlwiki.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlwiki.R;
import com.example.brawlwiki.models.brawlers.Brawler;
import com.example.brawlwiki.models.brawlers.StarPower;
import com.example.brawlwiki.models.profile.BrawlerStat;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BrawlersAdapter extends RecyclerView.Adapter<BrawlersAdapter.BrawlersViewHolder> {

    private static final String TAG = BrawlersAdapter.class.getSimpleName();

    private List<Brawler> mBrawlerList;
    private Context mContext;

    public BrawlersAdapter(Context context, List<Brawler> brawlerList) {
        mContext = context;
        mBrawlerList = brawlerList;
    }

    @NonNull
    @Override
    public BrawlersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brawlers_list_item, parent, false);
        return new BrawlersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrawlersViewHolder holder, int position) {
        Brawler brawler = mBrawlerList.get(position);
        holder.mBrawlerNameTextView.setText(brawler.getName());
        holder.mGadgetTextView.setText(Integer.toString(brawler.getGadgets().size()) + "/" + Integer.toString(brawler.getGadgets().size()));
        holder.mStarPowerTextView.setText(Integer.toString(brawler.getStarPowers().size()) + "/" + Integer.toString(brawler.getStarPowers().size()));

        switch (brawler.getId()) {
            case 16000000:
                Picasso.get().load(R.drawable.brawler_shelly).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000001:
                Picasso.get().load(R.drawable.brawler_colt).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000002:
                Picasso.get().load(R.drawable.brawler_bull).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000003:
                Picasso.get().load(R.drawable.brawler_brock).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000004:
                Picasso.get().load(R.drawable.brawler_rico).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.super_rare));
                break;
            case 16000005:
                Picasso.get().load(R.drawable.brawler_spike).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.legendary));
                break;
            case 16000006:
                Picasso.get().load(R.drawable.brawler_barley).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.rare));
                break;
            case 16000007:
                Picasso.get().load(R.drawable.brawler_jessie).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000008:
                Picasso.get().load(R.drawable.brawler_nita).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000009:
                Picasso.get().load(R.drawable.brawler_dynamike).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000010:
                Picasso.get().load(R.drawable.brawler_primo).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.rare));
                break;
            case 16000011:
                Picasso.get().load(R.drawable.brawler_mortis).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.mythic));
                break;
            case 16000012:
                Picasso.get().load(R.drawable.brawler_crow).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.legendary));
                break;
            case 16000013:
                Picasso.get().load(R.drawable.brawler_poco).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.rare));
                break;
            case 16000014:
                Picasso.get().load(R.drawable.brawler_bo).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000015:
                Picasso.get().load(R.drawable.brawler_piper).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.epic));
                break;
            case 16000016:
                Picasso.get().load(R.drawable.brawler_pam).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.epic));
                break;
            case 16000017:
                Picasso.get().load(R.drawable.brawler_tara).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.mythic));
                break;
            case 16000018:
                Picasso.get().load(R.drawable.brawler_darryl).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.super_rare));
                break;
            case 16000019:
                Picasso.get().load(R.drawable.brawler_penny).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.super_rare));
                break;
            case 16000020:
                Picasso.get().load(R.drawable.brawler_frank).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.epic));
                break;
            case 16000021:
                Picasso.get().load(R.drawable.brawler_gene).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.mythic));
                break;
            case 16000022:
                Picasso.get().load(R.drawable.brawler_tick).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000023:
                Picasso.get().load(R.drawable.brawler_leon).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.legendary));
                break;
            case 16000024:
                Picasso.get().load(R.drawable.brawler_rosa).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.rare));
                break;
            case 16000025:
                Picasso.get().load(R.drawable.brawler_carl).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.super_rare));
                break;
            case 16000026:
                Picasso.get().load(R.drawable.brawler_bibi).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.epic));
                break;
            case 16000027:
                Picasso.get().load(R.drawable.brawler_bit).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000028:
                Picasso.get().load(R.drawable.brawler_sandy).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.legendary));
                break;
            case 16000029:
                Picasso.get().load(R.drawable.brawler_bea).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.epic));
                break;
            case 16000030:
                Picasso.get().load(R.drawable.brawler_emz).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.trophy));
                break;
            case 16000031:
                Picasso.get().load(R.drawable.brawler_mrp).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.mythic));
                break;
            case 16000032:
                Picasso.get().load(R.drawable.brawler_max).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.mythic));
                break;
            case 16000034:
                Picasso.get().load(R.drawable.brawler_jacky).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.super_rare));
                break;
            case 16000035:
                Picasso.get().load(R.drawable.brawler_gale).into(holder.mBrawlerImageView);
                //holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.));
                break;
            case 16000036:
                Picasso.get().load(R.drawable.brawler_nani).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.epic));
                break;
            case 16000037:
                Picasso.get().load(R.drawable.brawler_sprout).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.mythic));
                break;
            case 16000038:
                Picasso.get().load(R.drawable.brawler_surge).into(holder.mBrawlerImageView);
                //holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.));
                break;
            case 16000039:
                Picasso.get().load(R.drawable.brawler_colette).into(holder.mBrawlerImageView);
                //holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.));
                break;
            case 16000040:
                Picasso.get().load(R.drawable.brawler_amber).into(holder.mBrawlerImageView);
                holder.mBrawlerImageView.setBackgroundColor(holder.mBrawlerImageView.getResources().getColor(R.color.legendary));
                break;
            default:
        }


    }

    @Override
    public int getItemCount() {
        return mBrawlerList.size();
    }

    public class BrawlersViewHolder extends RecyclerView.ViewHolder {

        private TextView mBrawlerNameTextView;
        private ImageView mBrawlerImageView;
        private TextView mGadgetTextView;
        private TextView mStarPowerTextView;

        public BrawlersViewHolder(@NonNull View itemView) {
            super(itemView);

            mBrawlerNameTextView = itemView.findViewById(R.id.tv_brawler_name);
            mBrawlerImageView = itemView.findViewById(R.id.iv_brawler_image);
            mGadgetTextView = itemView.findViewById(R.id.tv_brawler_gadget);
            mStarPowerTextView = itemView.findViewById(R.id.tv_brawler_star_power);
        }
    }
}
