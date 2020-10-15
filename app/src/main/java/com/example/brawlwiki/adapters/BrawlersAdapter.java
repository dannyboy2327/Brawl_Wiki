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
        Brawler brawler = this.mBrawlerList.get(position);

        holder.mBrawlerNameTextView.setText(brawler.getName());
        Picasso.get().load(brawler.getImageUrl()).into(holder.mBrawlerImageView);
        holder.mGadgetTextView.setText("2/2");
        holder.mStarPowerTextView.setText("2/2");
    }

    @Override
    public int getItemCount() {
        return mBrawlerList.size();
    }

    public class BrawlersViewHolder extends RecyclerView.ViewHolder {

        private TextView mBrawlerNameTextView;
        private ImageView mBrawlerImageView;
        private ImageView mGadgetImageView;
        private TextView mGadgetTextView;
        private ImageView mStarPowerImageView;
        private TextView mStarPowerTextView;

        public BrawlersViewHolder(@NonNull View itemView) {
            super(itemView);

            mBrawlerNameTextView = itemView.findViewById(R.id.tv_brawler_name);
            mBrawlerImageView = itemView.findViewById(R.id.iv_brawler_image);
            mGadgetImageView = itemView.findViewById(R.id.iv_brawler_gadget);
            mGadgetTextView = itemView.findViewById(R.id.tv_brawler_gadget);
            mStarPowerImageView = itemView.findViewById(R.id.iv_brawler_star_power);
            mStarPowerTextView = itemView.findViewById(R.id.tv_brawler_star_power);
        }
    }
}
