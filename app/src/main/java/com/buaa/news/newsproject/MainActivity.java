package com.buaa.news.newsproject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import com.buaa.news.newsproject.imp.ContentFragment;
import com.buaa.news.newsproject.imp.MenuLeftFragment;
import com.nineoldandroids.view.ViewHelper;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    private static final String TAG_CONTENT = "TAG_CONTENT";
    private static final String TAG_LEFT = "TAG_LEFT";
    public DrawerLayout mDrawerLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);

        initFragment();
        iniEvents();
    }

    //获取Button的点击事件
//    public void OpenLeftMenu(View view){
//        mDrawerLayout.openDrawer(Gravity.LEFT);
//    }

    //给侧边栏设置监听事件，当点击按钮时调用
    private void iniEvents(){

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView ;
                float scale = 1 - slideOffset ;
                float rightScale = 0.8f + scale * 0.2f ;

                if(drawerView.getTag().equals("LEFT")){
                    float leftScale = 1 - 0.3f * scale;
                    ViewHelper.setScaleX(mMenu,leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();

                }else{
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();

                }

            }

            @Override
            public void onDrawerOpened(View drawerView) {


            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    /**
     * 初始化Fragment
     */
    public void initFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.id_left_menu,new MenuLeftFragment(),TAG_LEFT);
        transaction.replace(R.id.id_content,new ContentFragment(),TAG_CONTENT);
        transaction.commit();
    }

    /**
     * 获取侧边栏对象，就是利用Fragment设置的标签获取
     */
    public MenuLeftFragment getMenuLeftFragment(){
        FragmentManager fm = getSupportFragmentManager();
        MenuLeftFragment fragment = (MenuLeftFragment) fm.findFragmentByTag(TAG_LEFT);
        return fragment;
    }

    //获取主页面对象
    public ContentFragment getContentFragment(){
        FragmentManager fm = getSupportFragmentManager();
        ContentFragment fragment = (ContentFragment) fm.findFragmentByTag(TAG_CONTENT);
        return fragment;
    }

}
