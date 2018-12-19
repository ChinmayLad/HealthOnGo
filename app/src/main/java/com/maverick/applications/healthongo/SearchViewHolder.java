package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chinmay on 18/12/18.
 */

public class SearchViewHolder extends RecyclerView.ViewHolder {
    public SearchViewHolder(View itemView) {
        super(itemView);
    }

    public static SearchViewHolder createViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_search,parent,false);
        return new SearchViewHolder(v);
    }
}
