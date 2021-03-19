package com.dawn.community.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

/**
 * 用于页面里的ViewPager2和TabLayout的结合
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    //Fragment数组
    private ArrayList<Fragment> myFragmentList;

    //构造函数
    public ViewPagerAdapter(@NonNull Fragment fragment, ArrayList<Fragment> myFragmentList) {
        super(fragment);
        this.myFragmentList = myFragmentList;
    }

    //返回Fragment页面
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return myFragmentList.get(position);
    }

    /**
     * 返回Fragment数量
     * @return myFragmentList.size()
     */
    @Override
    public int getItemCount() {
        return myFragmentList.size();
    }
}
