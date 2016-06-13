package com.buaa.news.newsproject.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.buaa.news.newsproject.BasePager;


/**
 * Created by Administrator on 2016/6/10.
 */
public class NewsCenter extends BasePager {

    public NewsCenter(Activity activity){
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("新闻");

        TextView view = new TextView(mActivity);
        view.setText("新闻中心");
        view.setTextSize(22);
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);

        flContent.addView(view);
    }
}
