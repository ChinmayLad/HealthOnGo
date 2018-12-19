package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chinmay on 17/12/18.
 */

public class MakePostViewHolder extends RecyclerView.ViewHolder {
    public MakePostViewHolder(View itemView) {
        super(itemView);
    }

    public static MakePostViewHolder createViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_make_post,parent,false);
        return new MakePostViewHolder(v);
    }
}
