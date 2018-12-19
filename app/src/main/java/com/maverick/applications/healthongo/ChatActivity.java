package com.maverick.applications.healthongo;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private EditText mMessageBox;
    private ImageButton mSendButton;
    private RecyclerView mChatView;
    private MessageAdapter mAdapter;
    private List<String> mMessages = new ArrayList<>();
    private String[] messagesArr = {"Hi","How are You?","How is your day going on!","How is weight loss progress?"};
    private static int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = 0;
        setContentView(R.layout.activity_chat);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(R.string.title_chat);
        }

        mMessageBox = findViewById(R.id.message_box);
        mMessageBox.setOnEditorActionListener(listener);
        mSendButton = findViewById(R.id.send_button);
        mChatView = findViewById(R.id.chat_view);

        setupChatView();

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                receiveMessage();
            }
        },500);
    }

    private void setupChatView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        mChatView.setLayoutManager(layoutManager);
        mAdapter = new MessageAdapter(mMessages);
        mChatView.setAdapter(mAdapter);
    }

    private EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEND:
                    sendMessage();
                    return true;
            }
            return false;
        }
    };

    private void receiveMessage() {
        List<String> r_message = new ArrayList<>(Arrays.asList(messagesArr));
        mMessages.add(r_message.get(pos));
        int insertPosition = mMessages.size() - 1;
        mAdapter.notifyItemInserted(insertPosition);
        mChatView.smoothScrollToPosition(insertPosition);
        pos += 1;
    }

    private void sendMessage() {
        Editable message = mMessageBox.getText();
        if (message == null)
            return;

        String msgStr = message.toString();
        msgStr = msgStr.trim();
        if (!msgStr.isEmpty() && mAdapter != null) {
            mMessages.add(msgStr);
            int insertPosition = mMessages.size() - 1;
            mAdapter.notifyItemInserted(insertPosition);
            mChatView.smoothScrollToPosition(insertPosition);
        }
        mMessageBox.setText("");
        if(pos < messagesArr.length) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    receiveMessage();
                }
            }, 1200);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
