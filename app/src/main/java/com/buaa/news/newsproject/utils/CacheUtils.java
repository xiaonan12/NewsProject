package com.buaa.news.newsproject.utils;

import android.content.Context;

import java.util.ArrayList;

/**
 * 保存缓存原则：以url+参数为key，以json为value
 *
 * Created by Administrator on 2016/6/20.
 */
public class CacheUtils {
    //写缓存
    public static void setCache(String url, String json, Context ctx){
        PrefUtils.putString(url,json,ctx);
    }
    //取缓存
    public static String getCache(String url, Context ctx){
        return PrefUtils.getString(url, null, ctx);
    }
}
