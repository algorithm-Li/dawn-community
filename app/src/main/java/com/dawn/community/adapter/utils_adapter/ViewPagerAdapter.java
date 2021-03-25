package com.dawn.community.adapter.utils_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @author Algorithm
 * ViewPager的适配器
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    //Fragment数组
    private ArrayList<Fragment> myFragmentList;

    //构造函数，传递Fragment数组
    public ViewPagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> myFragmentList) {
        super(fm);
        this.myFragmentList = myFragmentList;
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> myFragmentList) {
        super(fm, behavior);
        this.myFragmentList = myFragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }
}
