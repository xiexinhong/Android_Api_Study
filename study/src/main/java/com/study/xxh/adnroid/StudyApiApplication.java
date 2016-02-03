package com.study.xxh.adnroid;

import android.app.Application;

import com.study.xxh.adnroid.utils.AppUitl;

/**
 * Created by xiexinhong on 16/2/2.
 */
public class StudyApiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        //初始化AppUtil
        AppUitl.init(this);
    }
}
