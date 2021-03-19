package com.dawn.community.fragment;

import androidx.fragment.app.Fragment;

import com.dawn.community.R;
import com.dawn.community.adapter.ViewPagerAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentDiscoverBinding;
import com.dawn.community.viewmodel.DiscoverViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class DiscoverFragment extends BaseVmFragment<FragmentDiscoverBinding, DiscoverViewModel> {

    //Fragment数组
    private ArrayList<Fragment> myFragmentList = new ArrayList<>();

    //TabLayout标题内容数组
    private ArrayList<String> myFragmentTitleList = new ArrayList<>();

    @Override
    protected void initView() {
        super.initView();
        //添加默认的Fragment内容及TabLayout标题数据
        myFragmentList.add(new RecommendFragment());
        myFragmentList.add(new FollowFragment());
        myFragmentTitleList.add("推荐");
        myFragmentTitleList.add("关注");

        //为viewPager2设置Adapter
        viewDataBinding.discoverViewpager.setAdapter(new ViewPagerAdapter(this,myFragmentList));

        //绑定ViewPager2和TabLayout
        new TabLayoutMediator(
                viewDataBinding.discoverTabLayout,
                viewDataBinding.discoverViewpager,
                (tab, position) -> tab.setText(myFragmentTitleList.get(position))
        ).attach();
    }

    @Override
    public Class<DiscoverViewModel> getSubVMClass() {
        return DiscoverViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_discover;
    }
}
