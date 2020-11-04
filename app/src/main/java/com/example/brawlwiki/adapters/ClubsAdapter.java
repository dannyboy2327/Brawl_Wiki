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
import com.example.brawlwiki.models.clubranking.ClubRanking;

import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ClubsViewHolder> {

    private List<ClubRanking> mClubRankingList;
    private Context mContext;

    public ClubsAdapter(Context context, List<ClubRanking> clubRankingList) {
        mContext = context;
        mClubRankingList = clubRankingList;
    }

    @NonNull
    @Override
    public ClubsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubs_list_item, parent, false);
        return new ClubsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsViewHolder holder, int position) {
        ClubRanking clubRanking = this.mClubRankingList.get(position);
        holder.mClubNameTextView.setText(clubRanking.getName());
        holder.mClubRankTextView.setText(String.valueOf(clubRanking.getRank()));
        holder.mClubTrophiesTextView.setText(String.valueOf(clubRanking.getTrophies()));
        holder.mClubMembersTextView.setText(String.valueOf(clubRanking.getMemberCount()));

        switch (clubRanking.getBadgeId()) {
            case 8000000:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_blue_skull);
                break;
            case 8000001:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_blue_cactus);
                break;
            case 8000002:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_blue_star);
                break;
            case 8000003:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_blue_thunder);
                break;
            case 8000004:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_red_skull);
                break;
            case 8000005:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_red_cactus);
                break;
            case 8000006:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_red_star);
                break;
            case 8000007:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_red_thunder);
                break;
            case 8000008:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_purple_skull);
                break;
            case 8000009:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_purple_cactus);
                break;
            case 8000010:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_purple_star);
                break;
            case 8000011:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_purple_thunder);
                break;
            case 8000012:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_green_skull);
                break;
            case 8000013:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_green_cactus);
                break;
            case 8000014:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_green_star);
                break;
            case 8000015:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_green_thunder);
                break;
            case 8000016:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_yellow_skull);
                break;
            case 8000017:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_yellow_cactus);
                break;
            case 8000018:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_yellow_star);
                break;
            case 8000019:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_yellow_thunder);
                break;
            case 8000020:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_blue_bullet);
                break;
            case 8000021:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_blue_crown);
                break;
            case 8000022:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_red_bullet);
                break;
            case 8000023:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_red_crown);
                break;
            case 8000024:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_purple_bullet);
                break;
            case 8000025:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_purple_crown);
                break;
            case 8000026:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_green_bullet);
                break;
            case 8000027:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_green_crown);
                break;
            case 8000028:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_yellow_bullet);
                break;
            case 8000029:
                holder.mClubBadgeImageView.setImageResource(R.drawable.ic_yellow_crown);
                break;
            default:
                holder.mClubBadgeImageView.setImageResource(R.drawable.icon_clubs);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mClubRankingList.size();
    }

    public class ClubsViewHolder extends RecyclerView.ViewHolder {

        private ImageView mClubBadgeImageView;
        private TextView mClubNameTextView;
        private TextView mClubRankTextView;
        private TextView mClubTrophiesTextView;
        private TextView mClubMembersTextView;

        public ClubsViewHolder(@NonNull View itemView) {
            super(itemView);

            mClubBadgeImageView = itemView.findViewById(R.id.iv_club_badge);
            mClubNameTextView = itemView.findViewById(R.id.tv_club_name);
            mClubRankTextView = itemView.findViewById(R.id.tv_club_rank);
            mClubTrophiesTextView = itemView.findViewById(R.id.tv_club_trophies);
            mClubMembersTextView = itemView.findViewById(R.id.tv_club_members);
        }
    }
}
