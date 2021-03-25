package com.dawn.community.bean.tabs;

import java.util.List;

/**
 * @author Algorithm
 * 发现页面的 TabLayout 的 Tab 子项数据类
 */
public class DiscoverTab {

    /**
     * {
     *   "activeSize": 17,
     *   "normalSize": 14,
     *   "activeColor": "#ED7282",
     *   "normalColor": "#666666",
     *   "select": 0,
     *   "tabGravity": 0,
     *   "tabs": [
     *     {
     *       "title": "消息",
     *       "index": 0,
     *       "tag": "messages",
     *       "enable": true
     *     },
     *     {
     *       "title": "联系人",
     *       "index": 1,
     *       "tag": "contacts",
     *       "enable": true
     *     }
     *   ]
     * }
     */
    public int activeSize;
    public int normalSize;
    public String activeColor;
    public String normalColor;
    public int select;
    public int tabGravity;
    public List<DiscoverTab.Tabs> tabs;

    public static class Tabs {

        public String title;
        public int index;
        public String tag;
        public boolean enable;
    }
}
