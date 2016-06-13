package com.buaa.news.newsproject.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.buaa.news.newsproject.BasePager;


/**
 * Created by Administrator on 2016/6/10.
 */
public class SmartServicePager extends BasePager {

    public SmartServicePager(Activity activity){
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("智慧服务");

        TextView view = new TextView(mActivity);
        view.setText("智慧服务");
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);
        view.setTextSize(22);

        flContent.addView(view);
    }
}
