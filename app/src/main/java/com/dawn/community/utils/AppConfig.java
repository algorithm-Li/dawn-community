package com.dawn.community.utils;

import android.content.res.AssetManager;

import com.alibaba.fastjson.JSON;
import com.dawn.community.CommunityApplication;
import com.dawn.community.bean.tabs.DiscoverTab;
import com.dawn.community.bean.tabs.SocialTab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Algorithm
 * App基本配置信息
 */
public class AppConfig {

    private static SocialTab sSocialTab;
    private static DiscoverTab sDiscoverTab;

    /**
     * 获取社交页面 TabLayout 标题数据，保存在sSocialTab中
     * @return SocialTab TabLayout标题数据
     */
    public static SocialTab getSocialTabConfig() {
        if (sSocialTab == null) {
            String content = parseFile("social_tabs_config.json");
            sSocialTab = JSON.parseObject(content, SocialTab.class);
            Collections.sort(sSocialTab.tabs, new Comparator<SocialTab.Tabs>() {
                @Override
                public int compare(SocialTab.Tabs o1, SocialTab.Tabs o2) {
                    return o1.index < o2.index ? -1 : 1;
                }
            });
        }
        return sSocialTab;
    }

    /**
     * 获取发现页面 TabLayout 标题数据，保存在sDiscoverTab中
     * @return DiscoverTab TabLayout标题数据
     */
    public static DiscoverTab getDiscoverTabConfig() {
        if (sDiscoverTab == null) {
            String content = parseFile("discover_tabs_config.json");
            sDiscoverTab = JSON.parseObject(content, DiscoverTab.class);
            Collections.sort(sDiscoverTab.tabs, new Comparator<DiscoverTab.Tabs>() {
                @Override
                public int compare(DiscoverTab.Tabs o1, DiscoverTab.Tabs o2) {
                    return o1.index < o2.index ? -1 : 1;
                }
            });
        }
        return sDiscoverTab;
    }

    /**
     * 解析文件，返回字符串
     * @param fileName 文件名
     * @return String
     */
    private static String parseFile(String fileName) {
        AssetManager assets = CommunityApplication.getContext().getAssets();
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            is = assets.open(fileName);
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception ignored) {

            }
        }
        return builder.toString();
    }

}
