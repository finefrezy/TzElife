package com.elife.tzelife.net;


import com.elife.tzelife.constant.ConstantData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tzhang on 2016/9/13.
 */
public class RetrofitClient {

    private static RetrofitService sRetrofitService;

    public static RetrofitService getClient() {
        if (sRetrofitService == null) {
//            OkHttpClient okClient = new OkHttpClient();

            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(ConstantData.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

            // 拦截器
            // 设置超时时间
            // RXjava 的回调器
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(ConstantData.SERVER_URL)
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            sRetrofitService = client.create(RetrofitService.class);
        }
        return sRetrofitService;
    }



}
