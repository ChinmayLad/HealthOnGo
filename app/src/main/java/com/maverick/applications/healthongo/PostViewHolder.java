package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chinmay on 17/12/18.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{
    public PostViewHolder(View itemView) {
        super(itemView);

    }

    public static PostViewHolder createViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post,parent,false);
        return new PostViewHolder(v);
    }
}
