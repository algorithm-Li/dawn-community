package com.dawn.community.fragment.social;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.tabs.SocialTab;
import com.dawn.community.databinding.FragmentSocialBinding;
import com.dawn.community.utils.AppConfig;
import com.dawn.community.viewmodel.fagment.discover.SocialViewModel;

import java.util.ArrayList;

public class SocialFragment extends BaseVmFragment<FragmentSocialBinding, SocialViewModel> {

    private static final String TAG = "SocialFragment";

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

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        //ViewPager2和TabLayout的结合在绑定适配器类中实现
        /*Log.d(TAG,"==> initView");
        //添加默认的Fragment内容及TabLayout标题数据
        myFragmentList.clear();
        myFragmentTitleList.clear();
        myFragmentList.add(new MessageFragment());
        myFragmentList.add(new ContactsFragment());
        myFragmentTitleList.add("消息");
        myFragmentTitleList.add("联系人");

        //为viewPager2设置Adapter
        viewDataBinding.socialViewpager.setAdapter(new ViewPager2Adapter(this,myFragmentList));

        //绑定ViewPager2和TabLayout
        new TabLayoutMediator(
                viewDataBinding.socialTabLayout,
                viewDataBinding.socialViewpager,
                (tab, position) -> tab.setText(myFragmentTitleList.get(position))
        ).attach();*/
    }

    @Override
    protected void startLoadData() {
        viewDataBinding.setVm(viewModel);
    }

    @Override
    public void onDestroy() {
        viewModel.destroy.set(true);
        super.onDestroy();
    }

    public SocialTab getTabConfig() {
        return AppConfig.getSocialTabConfig();
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
