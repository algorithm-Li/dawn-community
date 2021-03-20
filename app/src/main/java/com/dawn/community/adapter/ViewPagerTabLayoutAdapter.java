package com.dawn.community.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
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

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return myFragmentTitleList.get(position);
    }
}
