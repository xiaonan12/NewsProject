package com.buaa.news.newsproject.imp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.buaa.news.newsproject.BaseMenuDetailPager;
import com.buaa.news.newsproject.BasePager;
import com.buaa.news.newsproject.MainActivity;
import com.buaa.news.newsproject.domain.NewsMenuData;
import com.buaa.news.newsproject.imp.menudetail.InteractMenuDetailPager;
import com.buaa.news.newsproject.imp.menudetail.NewsMenuDetailPager;
import com.buaa.news.newsproject.imp.menudetail.PhotosMenuDetailPager;
import com.buaa.news.newsproject.imp.menudetail.TopicMenuDetailPager;
import com.buaa.news.newsproject.retrofit.RetrofitAPI;
import com.buaa.news.newsproject.utils.CacheUtils;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/6/10.
 */
public class NewsCenterPager extends BasePager {

    private MenuLeftFragment leftMenuFragment;
    private ArrayList<BaseMenuDetailPager> mMenuDetailPager;
    private NewsMenuData mNewsMenuData;

    public NewsCenterPager(Activity activity){
        super(activity);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mNewsMenuData = (NewsMenuData) msg.obj;//获得bean对象，也可以直接在onResponse赋值对象，看爱好
            switch (msg.what) {
                case RetrofitAPI.RESPONSE_SUCCESS:
                    //此处mNewsMenuData就是赋值后的了
                    Log.i("111111", "handleMessage: " + mNewsMenuData.toString());
                    Log.i("111111", "handleMessage: " + mNewsMenuData.data.toString());
                    //之后把bean放置到你需要的地方
                    leftMenuFragment.setData(mNewsMenuData.data);

                    //初始化四个菜单详情页
                    mMenuDetailPager = new ArrayList<BaseMenuDetailPager>();
                    mMenuDetailPager.add(new NewsMenuDetailPager(mActivity,mNewsMenuData.data.get(0).children));
                    mMenuDetailPager.add(new TopicMenuDetailPager(mActivity));
                    mMenuDetailPager.add(new PhotosMenuDetailPager(mActivity));
                    mMenuDetailPager.add(new InteractMenuDetailPager(mActivity));
                    //菜单详情页——新闻  作为初始页面
                    setCurrentMenuDetailPager(0);
            }

        }
    };

    @Override
    public void initData() {
        tvTitle.setText("新闻");

        //1.首先看本地有没有缓存
        //2.如果有先加载缓存
        String cache = CacheUtils.getCache(RetrofitAPI.BASE_URL, mActivity);
        if(!TextUtils.isEmpty(cache)){
//            leftMenuFragment.setData(cache);
        }
        getDataFromServer();
        
    }

    /**
     * 从服务器获取数据
     */
    public void getDataFromServer() {
        RetrofitAPI.connectInternet(handler);//此处是异步，处理ui要用handler
        //connectInternet()这一步是获取服务端返回的json数据并转为bean对象，
        //response.body()就是bean对象，但是这是服务端解析回来的，需要 NewsMenuData mNewsMenuData = response.body();
        //转为本地bean，这样就完成了赋值，其他地方也就可以用了
        //获取侧边栏对象
        MainActivity mainUI = (MainActivity) mActivity;
        leftMenuFragment = mainUI.getMenuLeftFragment();
    }

    /**
     * 给新闻中心页面的FramLayout填充布局
     */
    protected void setCurrentMenuDetailPager(int position){
        BaseMenuDetailPager pager = mMenuDetailPager.get(position);
        //先移除之前所有的view对象，清理屏幕
        flContent.removeAllViews();

        flContent.addView(pager.mRootView);

        pager.initData();//初始化该页面的页签的数据

        // 更改标题栏的标题
        tvTitle.setText(mNewsMenuData.data.get(position).title);
    }

}
