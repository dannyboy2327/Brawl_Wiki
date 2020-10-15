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
import com.example.brawlwiki.models.playerranking.PlayerItem;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {

    private List<PlayerItem> mPlayerItemList;
    private Context mContext;

    public PlayersAdapter(Context context, List<PlayerItem> playerItemList) {
        mContext = context;
        mPlayerItemList = playerItemList;
    }


    @NonNull
    @Override
    public PlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_list_item, parent, false);
        return new PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersViewHolder holder, int position) {
        PlayerItem playerItem = mPlayerItemList.get(position);
        holder.mPlayerRankTextView.setText(Integer.toString(playerItem.getRank()));
        holder.mPlayerNameTextView.setText(playerItem.getName());
        holder.mPlayerTrophiesTextView.setText(Integer.toString(playerItem.getTrophies()));
    }

    @Override
    public int getItemCount() {
        return mPlayerItemList.size();
    }

    public class PlayersViewHolder extends RecyclerView.ViewHolder {

        private TextView mPlayerRankTextView;
        private ImageView mPlayerImageView;
        private TextView mPlayerNameTextView;
        private TextView mPlayerTrophiesTextView;

        public PlayersViewHolder(@NonNull View itemView) {
            super(itemView);

            mPlayerRankTextView = itemView.findViewById(R.id.tv_player_rank);
            mPlayerImageView = itemView.findViewById(R.id.iv_player_icon);
            mPlayerNameTextView = itemView.findViewById(R.id.tv_player_name);
            mPlayerTrophiesTextView = itemView.findViewById(R.id.tv_player_trophies);
        }
    }
}
