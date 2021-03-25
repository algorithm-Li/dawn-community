package com.dawn.community.fragment.social.message;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentMentionMeBinding;
import com.dawn.community.databinding.FragmentPrivateMessageBinding;
import com.dawn.community.viewmodel.fragment.social.message.MentionMeViewModel;
import com.dawn.community.viewmodel.fragment.social.message.MessageViewModel;

public class MentionMeFragment extends BaseVmFragment<FragmentMentionMeBinding, MentionMeViewModel> {

    private static final String TAG = "MentionMeFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<MentionMeViewModel> getSubVMClass() {
        return MentionMeViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mention_me;
    }
}
