package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by chinmay on 17/12/18.
 */

public class PostAdapter extends RecyclerView.Adapter {


    public PostAdapter() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return MakePostViewHolder.createViewHolder(parent);
            case 1:
                return PostViewHolder.createViewHolder(parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        return position != 0 ? 1 : 0;
    }
}
