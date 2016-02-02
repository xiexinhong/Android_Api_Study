package com.study.xxh.adnroid.localdata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * Created by xiexinhong on 16/2/1.
 */
public class LocalDataDemoListActivity extends AppCompatActivity {


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,LocalDataDemoListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout mRootView = new RelativeLayout(this);
        mRootView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(mRootView);
        getSupportActionBar().setTitle("本地数据库某块");

        ListView mListView = new ListView(this);
        mListView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mRootView.addView(mListView);

        final String[] demoListDescs = new String[]{"创建数据库"};
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,demoListDescs));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(LocalDataDemoListActivity.this, demoListDescs[position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
