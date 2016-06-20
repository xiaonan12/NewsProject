package com.buaa.news.newsproject.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.buaa.news.newsproject.BasePager;

/**
 * Created by Administrator on 2016/6/9.
 */
public class HomePager extends BasePager {

    public HomePager(Activity activity){
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("智慧上海") ;

        btnMenu.setVisibility(View.GONE);//设置侧边栏按钮不可见

        TextView view = new TextView(mActivity);
        view.setText("首页");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        flContent.addView(view);
    }
}
