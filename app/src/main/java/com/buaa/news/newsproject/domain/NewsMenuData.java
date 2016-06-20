package com.buaa.news.newsproject.domain;

import java.util.ArrayList;

/**
 * 新闻中心侧边栏分类数据
 *
 * Created by Administrator on 2016/6/16.
 */
public class NewsMenuData {
    public int retcode;
    public ArrayList<String> extend;
    public ArrayList<NewsData> data;

    public class NewsData {
        public String id;
        public String title;
        public int type;
        public ArrayList<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsData{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", children=" + children +
                    '}';
        }
    }

    //页签信息封装
    public class NewsTabData{
        public String id;
        public String title;
        public String url;
        public int type;

        public String toString(){
            return "NewsTabData [title = "+ title +"]";
        }
    }

    @Override
    public String toString() {
        return "NewsMenuData{" +
                "retcode=" + retcode +
                ", extend=" + extend +
                ", data=" + data +
                '}';
    }
}
