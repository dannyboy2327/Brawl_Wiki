package com.example.brawlwiki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlwiki.R;
import com.example.brawlwiki.models.gamemodes.GameMode;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GameModesAdapter extends RecyclerView.Adapter<GameModesAdapter.GameModesViewHolder> {

    private List<GameMode> mGameModeList;
    private Context mContext;

    public GameModesAdapter(Context context, List<GameMode> gameModeList) {
        mContext = context;
        mGameModeList = gameModeList;
    }

    @NonNull
    @Override
    public GameModesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_modes_list_item, parent, false);
        return new GameModesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameModesViewHolder holder, int position) {
        GameMode gameMode = this.mGameModeList.get(position);
        Picasso.get().load(gameMode.getImageUrl()).into(holder.mGameModeIconImageView);
        Picasso.get().load(gameMode.getImageUrl2()).into(holder.mGameModeBannerImageView);
        holder.mGameModeNameTextView.setText(gameMode.getName());

        switch (gameMode.getId()) {
            case 1:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.bounty));
                break;
            case 2:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.gemGrab));
                break;
            case 3:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.showdown));
                break;
            case 4:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.duoShowdown));
                break;
            case 5:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.heist));
                break;
            case  6:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.bigGame));
                break;
            case 7:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.brawlBall));
                break;
            case 8:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.roboRumble));
                break;
            case 9:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.bossFight));
                break;
            case 10:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.siege));
                break;
            case 11:
                holder.mGameModeBannerImageView.setBackgroundColor(holder.mGameModeBannerImageView.getResources().getColor(R.color.training));
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.training));
                break;
            case 12:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.takeDown));
                break;
            case 13:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.loneStar));
                break;
            case 14:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.presentBlunder));
                break;
            case 15:
                holder.mBackgroundFrameLayout.setBackgroundColor(holder.mBackgroundFrameLayout.getResources().getColor(R.color.hotZone));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mGameModeList.size();
    }

    public class GameModesViewHolder extends RecyclerView.ViewHolder {

        private ImageView mGameModeBannerImageView;
        private ImageView mGameModeIconImageView;
        private TextView mGameModeNameTextView;
        private FrameLayout mBackgroundFrameLayout;

        public GameModesViewHolder(@NonNull View itemView) {
            super(itemView);

            mGameModeBannerImageView = itemView.findViewById(R.id.iv_game_mode_banner);
            mGameModeIconImageView = itemView.findViewById(R.id.iv_game_mode_icon);
            mGameModeNameTextView = itemView.findViewById(R.id.tv_game_mode_name);
            mBackgroundFrameLayout = itemView.findViewById(R.id.fl_bar);
        }
    }
}
