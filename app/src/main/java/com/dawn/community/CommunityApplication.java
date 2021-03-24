package com.dawn.community;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * 全局Application类
 */
public class CommunityApplication extends Application {

    //保存全局唯一的ApplicationContext
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    /**
     * 获取全局Context，唯一上下文
     * @return applicationContext
     */
    public static Context getContext() {
        return context;
    }
}
