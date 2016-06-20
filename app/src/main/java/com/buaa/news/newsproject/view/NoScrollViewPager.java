package com.buaa.news.newsproject.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/6/15.
 */
public class NoScrollViewPager extends ViewPager{
    public NoScrollViewPager(Context context){
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;//不拦截事件，让嵌套的子ViewPager有机会响应触摸事件（滑动页面里面的页签时）
    }

    //在触摸事件中设置
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;//什么都不做就可以达到禁用ViewPager滑动的效果
    }
}
