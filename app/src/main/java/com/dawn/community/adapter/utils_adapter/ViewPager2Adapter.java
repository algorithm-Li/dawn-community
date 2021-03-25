package com.dawn.community.adapter.utils_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

/**
 * @author Algorithm
 * ViewPager2的适配器
 * 建议使用
 */
public class ViewPager2Adapter extends FragmentStateAdapter {

    //Fragment数组
    private ArrayList<Fragment> myFragmentList;

    //构造函数，传递Fragment数组
    public ViewPager2Adapter(@NonNull Fragment fragment, ArrayList<Fragment> myFragmentList) {
        super(fragment);
        this.myFragmentList = myFragmentList;
    }

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> myFragmentList) {
        super(fragmentActivity);
        this.myFragmentList = myFragmentList;
    }

    public ViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> myFragmentList) {
        super(fragmentManager, lifecycle);
        this.myFragmentList = myFragmentList;
    }

    /**
     * 设置数据
     * @param myFragmentList Fragment数组
     */
    void setData(ArrayList<Fragment> myFragmentList){
        this.myFragmentList.clear();
        this.myFragmentList.addAll(myFragmentList);
        this.notifyDataSetChanged();
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
