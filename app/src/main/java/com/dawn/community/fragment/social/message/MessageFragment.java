package com.dawn.community.fragment.social.message;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.dawn.community.R;
import com.dawn.community.adapter.utils_adapter.ViewPager2Adapter;
import com.dawn.community.adapter.utils_adapter.ViewPagerTabLayoutAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentMessageBinding;
import com.dawn.community.viewmodel.fragment.social.message.MessageViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

public class MessageFragment extends BaseVmFragment<FragmentMessageBinding, MessageViewModel> {

    private static final String TAG = "MessageFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");

    }

    @Override
    public Class<MessageViewModel> getSubVMClass() {
        return MessageViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }
}
