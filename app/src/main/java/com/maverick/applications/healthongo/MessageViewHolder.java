package com.maverick.applications.healthongo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chinmay on 16/12/18.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {
    private TextView mMessage;
    public MessageViewHolder(View itemView) {
        super(itemView);
        mMessage = itemView.findViewById(R.id.message_body);
    }

    public static MessageViewHolder createViewHolder(ViewGroup parent,int inflateViewId) {
        View v = LayoutInflater.from(parent.getContext()).inflate(inflateViewId,parent,false);
        return new MessageViewHolder(v);
    }

    public void bindViewHolder(String message) {
        mMessage.setText(message);
    }
}
