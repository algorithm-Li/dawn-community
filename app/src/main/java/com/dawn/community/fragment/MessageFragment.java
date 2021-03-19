package com.dawn.community.fragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentMessageBinding;
import com.dawn.community.viewmodel.MessageViewModel;

public class MessageFragment extends BaseVmFragment<FragmentMessageBinding, MessageViewModel> {

    @Override
    public Class<MessageViewModel> getSubVMClass() {
        return MessageViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }
}
