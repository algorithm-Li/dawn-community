package com.dawn.community.fragment.social;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentMessageBinding;
import com.dawn.community.viewmodel.fagment.discover.MessageViewModel;

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
