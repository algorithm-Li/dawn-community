package com.dawn.community.api;

import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;
import com.dawn.community.CommunityApplication;
import com.dawn.community.config.HttpConfig;
import com.dawn.community.http.HeaderInterceptor;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Algorithm
 * 请求复制构建者模式
 * 默认校验token 不忽略https校验
 */
public class RetrofitServiceBuilder {

    private static OkHttpClient client;

    /**
     * 创建对象
     */
    public static <T> T createService(final Class<T> clazz) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String message) {

            }
        });

        HeaderInterceptor headerInterceptor = new HeaderInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(headerInterceptor);

        client = builder.build();

        //判断网络连接状态
        if (!NetworkUtils.isConnected(CommunityApplication.getContext())) {
            return null;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_WEB_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T service = (T) retrofit.create(clazz);

        return service;
    }
}
