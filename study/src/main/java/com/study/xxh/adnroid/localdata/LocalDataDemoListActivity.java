package com.study.xxh.adnroid.localdata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.study.xxh.adnroid.R;
import com.study.xxh.adnroid.utils.ShowContentWindow;


/**
 * Created by xiexinhong on 16/2/1.
 * 参考网址：
 * http://www.cnblogs.com/kgb250/archive/2012/08/28/sqlitedatabase.html
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

        final ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_SHOW_TITLE|ActionBar.DISPLAY_HOME_AS_UP);
        mActionBar.setTitle("本地数据库某块");
        mActionBar.setCustomView(new View(this));


        ListView mListView = new ListView(this);
        mListView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mRootView.addView(mListView);

        final String[] demoListDescs = new String[]{"展示架构图","数据版本进行管理"};
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,demoListDescs));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ImageView mImgView = new ImageView(LocalDataDemoListActivity.this);
                        mImgView.setImageResource(R.drawable.img_sqlite_struct);
                        ShowContentWindow.create(LocalDataDemoListActivity.this).setShowView(mImgView).show(mActionBar.getCustomView());
                        break;
                    case 1:
                        AddDeleteUpdateQueryActivity.startActivity(LocalDataDemoListActivity.this);
                        break;
                }
            }
        });
    }

}
