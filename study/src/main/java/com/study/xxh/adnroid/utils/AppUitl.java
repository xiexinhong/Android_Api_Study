package com.study.xxh.adnroid.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by xiexinhong on 16/2/2.
 */
public class AppUitl {

    public static int mScreenWidth;
    public static int mScreenHeight;
    public static float mDisplayDensity;
    public static int mDisplayDensityDpi;
    public static Context mContext;

    public static void init(Context context) {
        mContext = context;
        getScreenInfo();
    }

    private static void getScreenInfo() {
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        mScreenWidth = metrics.widthPixels;     // 屏幕宽度（像素）
        mScreenHeight = metrics.heightPixels;   // 屏幕高度（像素）
        mDisplayDensity = metrics.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
        mDisplayDensityDpi = metrics.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
    }
}
