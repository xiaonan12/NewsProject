package com.buaa.news.newsproject.imp;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.buaa.news.newsproject.R;

/**
 * Created by Administrator on 2016/6/13.
 */
public class ContentFragment extends BaseFragment {

    private ViewPager mViewPager;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);

        return view;
    }

    @Override
    protected void initData() {

    }
}
