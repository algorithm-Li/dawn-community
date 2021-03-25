package com.dawn.community.adapter.utils_adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @author Algorithm
 * ViewPager 和 TabLayout 结合的 Adapter
 */
public class ViewPagerTabLayoutAdapter extends FragmentStatePagerAdapter {

    //Fragment数组
    private ArrayList<Fragment> myFragmentList;
    //Fragment title数组
    private ArrayList<String> myFragmentTitleList;

    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm,
                                     ArrayList<Fragment> myFragmentList,ArrayList<String> myFragmentTitleList) {
        super(fm);
        this.myFragmentList = myFragmentList;
        this.myFragmentTitleList = myFragmentTitleList;
    }

    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm, int behavior,
                                     ArrayList<Fragment> myFragmentList,ArrayList<String> myFragmentTitleList) {
        super(fm, behavior);
        this.myFragmentList = myFragmentList;
        this.myFragmentTitleList = myFragmentTitleList;
    }

    /**
     * 获取当前下标的Fragment
     * @param position 位置参数，下标
     * @return Fragment 页面
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    /**
     * 获取页面数量
     * @return size
     */
    @Override
    public int getCount() {
        return myFragmentList.size();
    }

    /**
     * 获取对应下标的TabLayout标题
     * @param position 下标
     * @return CharSequence 标题
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return myFragmentTitleList.get(position);
    }
}
