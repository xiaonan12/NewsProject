package com.buaa.news.newsproject.retrofit;

import android.os.Handler;

import com.buaa.news.newsproject.domain.NewsMenuData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/6/16.
 */
public class RetrofitAPI {
    public static final int RESPONSE_SUCCESS = 0;

    // 服务器根链接
    public static final String SERVER_URL = "http://android.yangyuanguang.com/android/zhbj/";
    // 获取分类信息的链接
    public static final String CATEGORIES_URL = "categories.json";

    public static final String BASE_URL = SERVER_URL + CATEGORIES_URL ;

                                      //此处传递hander对象
    public static void connectInternet(final Handler mHandler) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InternetService service = retrofit.create(InternetService.class);

        Call<NewsMenuData> call = service.loadRepo();

        call.enqueue(new Callback<NewsMenuData>() {
            @Override
            public void onResponse(Call<NewsMenuData> call, Response<NewsMenuData> response) {
                if (response.isSuccessful()) {
                    //此处处理完赋值之后需要做的事就是发送handler消息
                    //此处sendMessage是发送消息
                    //obtainMessage是创建消息对象，类似于Message msg = new Message(),前者效率更高
                    //RESPONSE_SUCCESS这个是msg.what值，response.body()这个是传递的对象，即msg.obj
                    mHandler.sendMessage(mHandler.obtainMessage(RESPONSE_SUCCESS,response.body()));
                }
            }

            @Override
            public void onFailure(Call<NewsMenuData> call, Throwable t) {

            }
        });

    }

    public interface InternetService {
        @GET(CATEGORIES_URL)
        Call<NewsMenuData> loadRepo();
    }
}
