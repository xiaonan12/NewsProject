package com.buaa.news.newsproject.imp;


import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.buaa.news.newsproject.MainActivity;
import com.buaa.news.newsproject.R;
import com.buaa.news.newsproject.domain.NewsMenuData;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/6/4.
 */
public class MenuLeftFragment extends BaseFragment {

    private ListView lvList;
    private ArrayList<NewsMenuData.NewsData> mMenuList;
    private MenuAdapter mAdapter;
    private int mCorrentPos;

    @Override
    public View initView() {
        View view = View.inflate(mActivity,R.layout.fragment_left_menu,null);
        lvList = (ListView) view.findViewById(R.id.lv_list);
        return view;
    }

    public void setData(ArrayList<NewsMenuData.NewsData> data){
        //此处需要把值放到相应的位置
        mMenuList = data;
        mAdapter = new MenuAdapter();
        lvList.setAdapter(mAdapter);

        //给lvList设置点击事件,被点击时变为红色
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCorrentPos = position;
                mAdapter.notifyDataSetChanged();

                //通知新闻中心，切换页面
                setCurrentMenuDetailPager(position);
                //隐藏侧边栏
                toggle();

            }
        });

        mCorrentPos = 0;///重置当前页面，默认是新闻页面
    }

    /**
     * 切换菜单
     */
    protected void setCurrentMenuDetailPager(int position){
        //获取新闻中心对象NewsCenterPager
        //①先获取MainActivity，②通过MainActivity获取ContentFragment，
        // ③通过ContentFragment获取NewsCenterPager

        MainActivity mainUI = (MainActivity) mActivity;
        ContentFragment contentFragment = mainUI.getContentFragment();
        NewsCenterPager newsCenterPager = contentFragment.getNewsCenterPager();
        //给新闻中心的FrameLayout填充布局
        newsCenterPager.setCurrentMenuDetailPager(position);

    }

    //点击后自动关闭侧边栏
    private void toggle(){
        MainActivity mainUI = (MainActivity) mActivity;
        mainUI.mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

    class MenuAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mMenuList.size();
        }

        @Override
        public NewsMenuData.NewsData getItem(int position) {
            return mMenuList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mActivity, R.layout.list_item_left_menu,
                    null);
            TextView tvMenu = (TextView) view.findViewById(R.id.tv_menu);

            NewsMenuData.NewsData data = getItem(position);
            tvMenu.setText(data.title);

            if(mCorrentPos==position){
                tvMenu.setEnabled(true);
            }else {
                tvMenu.setEnabled(false);
            }

            return view;
        }
    }

}
