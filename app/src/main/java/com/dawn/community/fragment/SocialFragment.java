package com.dawn.community.fragment;

import androidx.fragment.app.Fragment;

import com.dawn.community.R;
import com.dawn.community.adapter.ViewPagerAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentSocialBinding;
import com.dawn.community.viewmodel.SocialViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class SocialFragment extends BaseVmFragment<FragmentSocialBinding, SocialViewModel> {

    //Fragment数组
    private ArrayList<Fragment> myFragmentList = new ArrayList<>();

    //TabLayout标题内容数组
    private ArrayList<String> myFragmentTitleList = new ArrayList<>();

    @Override
    protected void initView() {
        super.initView();
        //添加默认的Fragment内容及TabLayout标题数据
        myFragmentList.add(new MessageFragment());
        myFragmentList.add(new ContactsFragment());
        myFragmentTitleList.add("消息");
        myFragmentTitleList.add("联系人");

        //为viewPager2设置Adapter
        viewDataBinding.socialViewpager.setAdapter(new ViewPagerAdapter(this,myFragmentList));

        //绑定ViewPager2和TabLayout
        new TabLayoutMediator(
                viewDataBinding.socialTabLayout,
                viewDataBinding.socialViewpager,
                (tab, position) -> tab.setText(myFragmentTitleList.get(position))
        ).attach();
    }

    @Override
    public Class<SocialViewModel> getSubVMClass() {
        return SocialViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_social;
    }
}
