package com.example.brawlwiki.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlwiki.R;
import com.example.brawlwiki.models.clubranking.Item;

import java.util.ArrayList;
import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ClubsViewHolder> {

    private List<Item> mItemList;
    private Context mContext;

    public ClubsAdapter(Context context, List<Item> itemList) {
        mContext = context;
        mItemList= itemList;
    }

    @NonNull
    @Override
    public ClubsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubs_list_item, parent, false);
        return new ClubsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsViewHolder holder, int position) {
        Item item = this.mItemList.get(position);
        holder.mClubNameTextView.setText(item.getName());
        holder.mClubRankTextView.setText(Integer.toString(item.getRank()));
        holder.mClubTrophiesTextView.setText(Integer.toString(item.getTrophies()));
        holder.mClubMembersTextView.setText(Integer.toString(item.getMemberCount()));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ClubsViewHolder extends RecyclerView.ViewHolder {

        private TextView mClubNameTextView;
        private TextView mClubRankTextView;
        private TextView mClubTrophiesTextView;
        private TextView mClubMembersTextView;

        public ClubsViewHolder(@NonNull View itemView) {
            super(itemView);

            mClubNameTextView = itemView.findViewById(R.id.tv_club_name);
            mClubRankTextView = itemView.findViewById(R.id.tv_club_rank);
            mClubTrophiesTextView = itemView.findViewById(R.id.tv_club_trophies);
            mClubMembersTextView = itemView.findViewById(R.id.tv_club_members);
        }
    }
}
