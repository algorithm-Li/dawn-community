package com.dawn.community.fragment.social.message;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentNoticeBinding;
import com.dawn.community.viewmodel.fragment.social.message.NoticeViewModel;

public class NoticeFragment extends BaseVmFragment<FragmentNoticeBinding, NoticeViewModel> {

    private static final String TAG = "NoticeFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<NoticeViewModel> getSubVMClass() {
        return NoticeViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_notice;
    }
}
