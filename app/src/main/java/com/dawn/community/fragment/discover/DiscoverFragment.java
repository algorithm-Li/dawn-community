package com.dawn.community.fragment.discover;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.tabs.DiscoverTab;
import com.dawn.community.databinding.FragmentDiscoverBinding;
import com.dawn.community.utils.AppConfig;
import com.dawn.community.viewmodel.fragment.discover.DiscoverViewModel;

import java.util.ArrayList;

public class DiscoverFragment extends BaseVmFragment<FragmentDiscoverBinding, DiscoverViewModel> {

    private static final String TAG = "DiscoverFragment";

    //Fragment数组
    private ArrayList<Fragment> myFragmentList = new ArrayList<>();

    //TabLayout标题内容数组
    private ArrayList<String> myFragmentTitleList = new ArrayList<>();

    /**
     * 初始化ViewModel
     */
    @Override
    protected void initViewModel() {
        super.initViewModel();//父类构建ViewModel
        //初始化数据赋值
        viewModel.fragment.set(this);
        viewModel.tabConfig.set(getTabConfig());
        viewModel.type.set(0);
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        /*
        //添加默认的Fragment内容及TabLayout标题数据
        myFragmentList.clear();
        myFragmentTitleList.clear();
        myFragmentList.add(new RecommendFragment());
        myFragmentList.add(new FollowFragment());
        myFragmentTitleList.add("推荐");
        myFragmentTitleList.add("关注");

        //为viewPager2设置Adapter
        viewDataBinding.discoverViewpager.setAdapter(new ViewPager2Adapter(this,myFragmentList));

        //绑定ViewPager2和TabLayout
        new TabLayoutMediator(
                viewDataBinding.discoverTabLayout,
                viewDataBinding.discoverViewpager,
                (tab, position) -> tab.setText(myFragmentTitleList.get(position))
        ).attach();*/
    }

    /**
     * 初始化数据
     */
    @Override
    protected void startLoadData() {
        viewDataBinding.setVm(viewModel);
    }

    @Override
    public void onDestroy() {
        viewModel.destroy.set(true);
        super.onDestroy();
    }

    public DiscoverTab getTabConfig() {
        return AppConfig.getDiscoverTabConfig();
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
