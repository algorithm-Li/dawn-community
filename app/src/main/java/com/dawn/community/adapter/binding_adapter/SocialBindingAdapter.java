package com.dawn.community.adapter.binding_adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dawn.community.R;
import com.dawn.community.bean.tabs.SocialTab;
import com.dawn.community.fragment.social.ContactsFragment;
import com.dawn.community.fragment.social.message.MessageFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class SocialBindingAdapter {

    /**
     * social_fragment.xml 中 ViewPage2和TabLayout的结合
     * @param tabLayout TabLayout组件
     * @param fragment  Fragment 组件
     * @param tabConfig SocialTab 组件
     * @param detach 移除判断
     * @param type 页面种类
     */
    @BindingAdapter(value = {"bindSocialFragment", "socialTabConfig", "detach", "fragmentType"})
    public static void bindSofaTabLayout(TabLayout tabLayout, Fragment fragment, SocialTab tabConfig, Boolean detach, int type) {

        //拿到所有的 Tabs 数据
        ArrayList<SocialTab.Tabs> tabs = new ArrayList<>();
        //解析TabConfig
        for (SocialTab.Tabs tab : tabConfig.tabs) {
            if (tab.enable) {
                tabs.add(tab);
            }
        }
        //初始化ViewPager2实例
        ViewPager2 viewPager2;
        viewPager2 = tabLayout.getRootView().findViewById(R.id.social_viewpager);

        //设置屏幕外加载页面数量
        viewPager2.setOffscreenPageLimit(ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT);
        //写死的ViewPager加载的页面，设置适配器
        viewPager2.setAdapter(new FragmentStateAdapter(fragment.getChildFragmentManager(), fragment.getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch(position){
                    case 0:
                        return new MessageFragment();
                    case 1:
                        return new ContactsFragment();
                    default:
                        return new Fragment();
                }
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        //viewPager2页面切换的回调接口
        ViewPager2.OnPageChangeCallback mPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
            //页面切换调用的函数，回调接口
            @Override
            public void onPageSelected(int position) {
                //TabLayout的标题数量，也即页面数量
                int tabCount = tabLayout.getTabCount();
                //遍历所有的Tabs
                for (int i = 0; i < tabCount; i++) {
                    TabLayout.Tab tab = tabLayout.getTabAt(i);
                    //设置字体大小和类型
                    if(tab!=null){
                        TextView customView = (TextView) tab.getCustomView();
                        if(customView!=null){
                            if (tab.getPosition() == position) {
                                customView.setTextSize(tabConfig.activeSize);
                                customView.setTypeface(Typeface.DEFAULT_BOLD);
                            } else {
                                customView.setTextSize(tabConfig.normalSize);
                                customView.setTypeface(Typeface.DEFAULT);
                            }
                        }
                    }
                }
            }
        };

        if (detach) {
            //移除回调
            viewPager2.unregisterOnPageChangeCallback(mPageChangeCallback);
        }

        //设置TabLayout的Gravity属性
        tabLayout.setTabGravity(tabConfig.tabGravity);
        //使用TabLayoutMediator结合TabLayout和ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView tabView = new TextView(fragment.getContext());
                int[][] states = new int[2][];
                states[0] = new int[]{android.R.attr.state_selected};
                states[1] = new int[]{};
                //解析激活的颜色和正常颜色
                int[] colors = new int[]{Color.parseColor(tabConfig.activeColor), Color.parseColor(tabConfig.normalColor)};
                //设置颜色状态
                ColorStateList stateList = new ColorStateList(states, colors);
                tabView.setTextColor(stateList);
                tabView.setText(tabs.get(position).title);
                tabView.setTextSize(tabConfig.normalSize);
                tab.setCustomView(tabView);
            }
        }).attach();

        //注册接口
        viewPager2.registerOnPageChangeCallback(mPageChangeCallback);
        //切换到默认选择项,那当然要等待初始化完成之后才有效
        viewPager2.post(() -> viewPager2.setCurrentItem(tabConfig.select, false));

    }
}
