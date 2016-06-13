package com.buaa.news.newsproject.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.buaa.news.newsproject.BasePager;

/**
 * Created by Administrator on 2016/6/10.
 */
public class GovAffairsPager extends BasePager {
    public GovAffairsPager(Activity activity){
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("政务");

        TextView view = new TextView(mActivity);
        view.setText("政务");
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);
        view.setTextColor(Color.RED);

        flContent.addView(view);
    }
}
