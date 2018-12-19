package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinmay on 17/12/18.
 */

public class FriendsAdapter extends RecyclerView.Adapter {

    List<Integer> selectedPositions = new ArrayList<>();
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0) {
            return SearchViewHolder.createViewHolder(parent);
        }
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_friend,parent,false);
        return new FriendViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    @Override
    public int getItemViewType(int position) {
        return position !=0 ? 1 : 0;
    }

    class FriendViewHolder extends RecyclerView.ViewHolder {

        public FriendViewHolder(View itemView) {
            super(itemView);

        }
    }
}
