package com.buaa.news.newsproject.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.buaa.news.newsproject.BasePager;

/**
 * Created by Administrator on 2016/6/10.
 */
public class SettingPager extends BasePager {

    public SettingPager(Activity activity){
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("设置");

        TextView view = new TextView(mActivity);
        view.setText("设置");
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);
        view.setTextSize(22);

        flContent.addView(view);
    }
}
