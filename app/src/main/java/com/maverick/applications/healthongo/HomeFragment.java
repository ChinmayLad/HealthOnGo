package com.maverick.applications.healthongo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;



public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    RecyclerView mPostList;
    PostAdapter mAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBar actionBar = ((HomeApp)getActivity()).getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.layout_titlebar);
            actionBar.setDisplayHomeAsUpEnabled(false);
            TextView title = getActivity().findViewById(R.id.actionbar_title);
            title.setText(R.string.app_name);
        }

        mPostList = view.findViewById(R.id.post_list);
        setupPosts(view);
    }

    public void setupPosts(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mPostList.setLayoutManager(layoutManager);
        mAdapter = new PostAdapter();
        mPostList.setAdapter(mAdapter);
    }
}
