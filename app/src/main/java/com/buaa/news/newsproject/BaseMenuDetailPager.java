package com.buaa.news.newsproject;

import android.app.Activity;
import android.view.View;

/**
 * Created by Administrator on 2016/6/19.
 */
public abstract class BaseMenuDetailPager{

    public Activity mActivity;

    public View mRootView;

    public BaseMenuDetailPager(Activity activity){
        mActivity = activity;
        mRootView = initView();
    }



    //初始化页面
    public abstract View initView();
    //初始化数据
    public void initData(){

    }

}
