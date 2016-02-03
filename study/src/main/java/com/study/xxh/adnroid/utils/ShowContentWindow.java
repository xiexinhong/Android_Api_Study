package com.study.xxh.adnroid.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.study.xxh.adnroid.R;


/**
 * Created by xiexinhong on 16/2/2.
 */
public class ShowContentWindow extends PopupWindow {

    private ViewGroup mRootView;
    private static ShowContentWindow mInstance;

    public ShowContentWindow(Context context) {
        mRootView = (ViewGroup)((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.popwindow_common,null);
        setContentView(mRootView);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));
        setOutsideTouchable(true);
        setFocusable(true);
        setElevation(5);
        setWidth((int) (AppUitl.mScreenWidth * 0.8));
        setHeight((int) (AppUitl.mScreenHeight * 0.8));
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public static ShowContentWindow create(Context context) {
        if(mInstance == null) {
            mInstance = new ShowContentWindow(context);
        }
        return mInstance;
    }

    public ShowContentWindow setShowView(View view) {
        mRootView.addView(view);
        return this;
    }

    public void show(View view) {
        showAtLocation(view, Gravity.CENTER,0,0);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
