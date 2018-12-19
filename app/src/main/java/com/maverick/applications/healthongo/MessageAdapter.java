package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chinmay on 16/12/18.
 */

public class MessageAdapter extends RecyclerView.Adapter {

    private List<String> mMessages;

    public MessageAdapter(List<String> messages) {
        super();
        mMessages = messages;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int viewId = R.layout.my_message;
        switch (viewType) {
            case 1:
                viewId = R.layout.my_message;
                break;
            case 0:
                viewId = R.layout.their_message;
                break;
        }
        return MessageViewHolder.createViewHolder(parent,viewId);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MessageViewHolder)holder).bindViewHolder(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public String getItem(int position) {
        return mMessages.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }
}
