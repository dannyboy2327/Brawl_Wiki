package com.example.brawlwiki.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brawlwiki.models.clubranking.Item;

import java.util.ArrayList;
import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ClubsViewHolder> {

    private List<Item> mItemList = new ArrayList<>();
    private Context mContext;

    public ClubsAdapter(Context context, List<Item> itemList) {
        mContext = context;
        mItemList= itemList;
    }

    @NonNull
    @Override
    public ClubsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ClubsViewHolder extends RecyclerView.ViewHolder {

        public ClubsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
