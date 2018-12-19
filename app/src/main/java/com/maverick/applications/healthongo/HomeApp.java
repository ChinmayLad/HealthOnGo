package com.maverick.applications.healthongo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeApp extends AppCompatActivity {

    private BottomNavigationView mNavigation;
    private TextView mTextMessage;
    private FloatingActionButton mChatButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            String message="";
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    message = getResources().getString(R.string.title_home);
//                    Toast.makeText(HomeApp.this,message,Toast.LENGTH_SHORT).show();
                    if(mFragmentManager != null) {
                        mFragmentManager.beginTransaction().replace(R.id.navigation_container,mHomeFragment).commit();
                    }
                    return true;
                case R.id.navigation_dashboard:
                    message = getResources().getString(R.string.title_dashboard);
//                    Toast.makeText(HomeApp.this,message,Toast.LENGTH_SHORT).show();
                    if(mFragmentManager != null) {
                        mFragmentManager.beginTransaction().replace(R.id.navigation_container,mDashboardFragment).commit();
                    }
                    return true;
                case R.id.navigation_settings:
                    message = getResources().getString(R.string.title_settings);
//                    Toast.makeText(HomeApp.this,message,Toast.LENGTH_SHORT).show();
                    if(mFragmentManager != null) {
                        mFragmentManager.beginTransaction().replace(R.id.navigation_container,mSettingsFragment).commit();
                    }
                    return true;
            }
            return false;
        }
    };

    android.support.v4.app.FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.layout_titlebar);
            TextView title = findViewById(R.id.actionbar_title);
            title.setText(R.string.app_name);
        }
        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mChatButton = findViewById(R.id.action_chat);
        mChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(HomeApp.this,getResources().getString(R.string.title_chat),Toast.LENGTH_SHORT).show();
                Intent chatIntent = new Intent(HomeApp.this,ChatActivity.class);
                startActivity(chatIntent);
            }
        });

        mFragmentManager = getSupportFragmentManager();
        setupFragments();

        if(savedInstanceState == null) {
            mNavigation.setSelectedItemId(R.id.navigation_home);
        }
    }

    HomeFragment mHomeFragment;
    DashboardFragment mDashboardFragment;
    SettingsFragment mSettingsFragment;
    private void setupFragments() {
        mHomeFragment = new HomeFragment();
        mDashboardFragment = new DashboardFragment();
        mSettingsFragment = new SettingsFragment();
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
        if(mNavigation.getSelectedItemId() != R.id.navigation_home){
            mNavigation.setSelectedItemId(R.id.navigation_home);
            return;
        }
        super.onBackPressed();
    }
}
