package com.buaa.news.newsproject.imp.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.buaa.news.newsproject.BaseMenuDetailPager;
import com.buaa.news.newsproject.domain.NewsMenuData;

/**
 * 12个页签的页面对象
 *
 * Created by Administrator on 2016/6/20.
 */
public class TabDetailPager extends BaseMenuDetailPager {

    private NewsMenuData.NewsTabData mTabData;
    private TextView mTextView;

    public TabDetailPager(Activity activity, NewsMenuData.NewsTabData tabData){
        super(activity);
        mTabData = tabData;
    }
    @Override
    public View initView() {
        mTextView = new TextView(mActivity);
//        mTextView.setText("我就是页签，就是这么嚣张");
        mTextView.setTextColor(Color.RED);
        mTextView.setTextSize(22);
        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }
    @Override
    public void initData() {
        mTextView.setText(mTabData.title);
    }
}
