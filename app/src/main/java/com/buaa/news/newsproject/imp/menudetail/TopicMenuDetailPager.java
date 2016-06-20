package com.buaa.news.newsproject.imp.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.buaa.news.newsproject.BaseMenuDetailPager;

/**
 *菜单详情页——专题
 *
 * Created by Administrator on 2016/6/19.
 */
public class TopicMenuDetailPager extends BaseMenuDetailPager {

    public TopicMenuDetailPager(Activity activity){
        super(activity);
    }

    @Override
    public View initView() {
        TextView view = new TextView(mActivity);
        view.setText("菜单详情页——专题");
        view.setTextSize(22);
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);
        return view;
    }
}
