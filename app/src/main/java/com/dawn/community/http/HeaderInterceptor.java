package com.dawn.community.http;

import android.os.Build;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Algorithm
 * @Date: 2021/5/2/0002
 * @Time: 15:55
 */
public class HeaderInterceptor implements Interceptor {

    //保存cookie
    public static String cookie=null;

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if(cookie != null) {
            builder.addHeader("Cookie", cookie);
            if (Build.VERSION.SDK != null) {
                builder.addHeader("Connection", "close");
            }
        }
        else{
            Log.e("Cookie","Cookie not found");
        }
        return chain.proceed(builder.build());
    }
}
