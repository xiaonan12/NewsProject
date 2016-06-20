package com.buaa.news.newsproject.imp.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buaa.news.newsproject.BaseMenuDetailPager;
import com.buaa.news.newsproject.MainActivity;
import com.buaa.news.newsproject.R;
import com.buaa.news.newsproject.domain.NewsMenuData;

import java.util.ArrayList;

/**
 *菜单详情页——新闻
 *
 * Created by Administrator on 2016/6/19.
 */
public class NewsMenuDetailPager extends BaseMenuDetailPager implements ViewPager.OnPageChangeListener {

    private ArrayList<NewsMenuData.NewsTabData> mTabList;//页签网络数据集合
    private ViewPager mViewPager;
    private ArrayList<TabDetailPager> mTabPagers;//页面页签集合

    public NewsMenuDetailPager(Activity activity, ArrayList<NewsMenuData.NewsTabData> children){
        super(activity);
        mTabList = children;
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_menu_detail_news,null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_news_detail);
        return view;
    }

    @Override
    public void initData() {

        mTabPagers = new ArrayList<TabDetailPager>();
        //初始化12个页面标签
        for (NewsMenuData.NewsTabData tabData :mTabList ) {
            //创建一个页签对象
            TabDetailPager pager = new TabDetailPager(mActivity,tabData);
            mTabPagers.add(pager);
        }

        mViewPager.setAdapter(new NewsMenuAdapter());
        mViewPager.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0){//在第一个页签允许侧边栏开启
            //开启侧边栏
            setDrawerLayoutEnable(true);
        }else {//其余页面关闭侧边栏
            //关闭侧边栏
            setDrawerLayoutEnable(false);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //设置DrawerLayout侧边栏禁用与不禁用
    private void setDrawerLayoutEnable(boolean enable){

        MainActivity mainUI = (MainActivity) mActivity;
        if(enable){
            mainUI.mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }else{
            mainUI.mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

    }

    class NewsMenuAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mTabPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TabDetailPager pager = mTabPagers.get(position);
            container.addView(pager.mRootView);
            pager.initData();//初始化页面的页签
            return pager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
