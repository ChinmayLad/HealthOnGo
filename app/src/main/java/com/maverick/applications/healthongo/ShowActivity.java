package com.maverick.applications.healthongo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Bundle b = getIntent().getExtras();
        int value = 0;
        if(b != null) {
            value = b.getInt("image");
        }
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ImageView v = findViewById(R.id.image);
        LinearLayout lv = findViewById(R.id.listview);
        if(value != -1) {
            lv.setVisibility(View.GONE);
            int drawable = value == 0 ? R.mipmap.image0 : R.mipmap.image1;
            v.setImageDrawable(getResources().getDrawable(drawable, null));
        } else {
            v.setVisibility(View.GONE);
            lv.setVisibility(View.VISIBLE);
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
}
