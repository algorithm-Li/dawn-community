package com.dawn.community.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dawn.community.R;
import com.dawn.community.adapter.utils_adapter.ViewPager2Adapter;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivityMessageCenterBinding;
import com.dawn.community.fragment.social.message.CommentFragment;
import com.dawn.community.fragment.social.message.MentionMeFragment;
import com.dawn.community.fragment.social.message.NoticeFragment;
import com.dawn.community.fragment.social.message.PrivateMessageFragment;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.MessageCenterViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MessageCenterActivity extends BaseVmActivity<ActivityMessageCenterBinding, MessageCenterViewModel>{

    //Fragment数组
    private ArrayList<Fragment> myFragmentList = new ArrayList<>();

    //TabLayout标题内容数组
    private ArrayList<String> myFragmentTitleList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        //初始化数据
        initArrayListData();
        //为viewPager2设置Adapter
        viewDataBinding.messageViewpager.setAdapter(new ViewPager2Adapter(this,myFragmentList));
        //设置默认加载页数
        viewDataBinding.messageViewpager.setOffscreenPageLimit(4);
        //绑定ViewPager2和TabLayout
        new TabLayoutMediator(
                viewDataBinding.tabs,
                viewDataBinding.messageViewpager,
                (tab, position) -> tab.setText(myFragmentTitleList.get(position))
        ).attach();
    }

    private void initArrayListData(){
        myFragmentList.add(new PrivateMessageFragment());
        myFragmentList.add(new CommentFragment());
        myFragmentList.add(new MentionMeFragment());
        myFragmentList.add(new NoticeFragment());

        myFragmentTitleList.add("私信");
        myFragmentTitleList.add("评论");
        myFragmentTitleList.add("@我");
        myFragmentTitleList.add("通知");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message_center;
    }

    @Override
    public Class<MessageCenterViewModel> getSubVMClass() {
        return MessageCenterViewModel.class;
    }
}