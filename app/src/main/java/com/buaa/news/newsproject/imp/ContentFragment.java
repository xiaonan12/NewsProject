package com.buaa.news.newsproject.imp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.buaa.news.newsproject.BasePager;
import com.buaa.news.newsproject.MainActivity;
import com.buaa.news.newsproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/13.
 */
public class ContentFragment extends BaseFragment {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private ArrayList<BasePager> mPagers;


    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_radioGroup);

        return view;
    }

    @Override
    protected void initData() {
        mPagers = new ArrayList<BasePager>();//五个标签页的集合

        mPagers.add(new HomePager(mActivity));
        mPagers.add(new NewsCenterPager(mActivity));
        mPagers.add(new SmartServicePager(mActivity));
        mPagers.add(new GovAffairsPager(mActivity));
        mPagers.add(new SettingPager(mActivity));


        mViewPager.setAdapter(new ContentPager());


        //实现点击按钮切换界面
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0,false);//false是设置滑动时候的动画效果
                        mPagers.get(0).initData();//初始化首页的数据，注意是用集合加载
                        setDrawerLayoutEnable(false);
                        break;
                    case R.id.rb_news:
                        mViewPager.setCurrentItem(1,false);
                        mPagers.get(1).initData();//初始化首页的数据，注意是用集合加载
                        setDrawerLayoutEnable(true);
                        break;
                    case R.id.rb_smart:
                        mViewPager.setCurrentItem(2,false);
                        mPagers.get(2).initData();//初始化首页的数据，注意是用集合加载
                        setDrawerLayoutEnable(true);
                        break;
                    case R.id.rb_gov:
                        mViewPager.setCurrentItem(3,false);
                        mPagers.get(3).initData();//初始化首页的数据，注意是用集合加载
                        setDrawerLayoutEnable(true);
                        break;
                    case R.id.rb_setting:
                        mViewPager.setCurrentItem(4,false);
                        mPagers.get(4).initData();//初始化首页的数据，注意是用集合加载
                        setDrawerLayoutEnable(false);
                        break;
                    default:
                        break;
                }
            }
        });

        mPagers.get(0).initData();//解决首页初始化不出来的问题
        setDrawerLayoutEnable(false);//首页禁用侧边栏
    }

    class ContentPager extends PagerAdapter{

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //初始化五个标签页
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            container.addView(pager.mRootView);// 将页面布局添加到容器中
           // pager.initData();//初始化数据，但在此处初始化数据会影响手机的流量和性能，因为ViewPager会自动加载下一个页面的数据
            return pager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
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

    /**
     * 获取新闻中心页面
     * @return
     */
    public NewsCenterPager getNewsCenterPager(){
        return (NewsCenterPager) mPagers.get(1);
    }



}
