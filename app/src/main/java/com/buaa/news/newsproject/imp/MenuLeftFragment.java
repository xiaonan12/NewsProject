package com.buaa.news.newsproject.imp;


import android.view.View;

import com.buaa.news.newsproject.R;


/**
 * Created by Administrator on 2016/6/4.
 */
public class MenuLeftFragment extends BaseFragment {
    @Override
    public View initView() {
       View view = View.inflate(mActivity,R.layout.fragment_left_menu,null);
        return view;
    }

    @Override
    protected void initData() {

    }
}
