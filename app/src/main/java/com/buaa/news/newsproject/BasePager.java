package com.buaa.news.newsproject;

import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/9.
 */
public abstract class BasePager {

    public Activity mActivity;
    public View mRootView;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;

    //构造方法
    public BasePager(Activity activity){
        mActivity = activity ;
        initView();
    }



    /**
     * 初始化布局
     */
    public void initView(){
        mRootView = View.inflate(mActivity, R.layout.base_pager, null);
        tvTitle = (TextView)mRootView.findViewById(R.id.tv_title);
        btnMenu = (ImageButton )mRootView.findViewById(R.id.btn_menu);
        flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }
//    mainUI.mDrawerLayout.closeDrawer(Gravity.LEFT);
    //点击后自动关闭侧边栏
    private void toggle(){
        MainActivity mainUI = (MainActivity) mActivity;
        if (mainUI.mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mainUI.mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mainUI.mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    /**
     * 初始化数据
     */
    public abstract void initData() ;

}
