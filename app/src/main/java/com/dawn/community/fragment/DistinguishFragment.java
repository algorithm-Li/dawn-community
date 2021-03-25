package com.dawn.community.fragment;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentDistinguishBinding;
import com.dawn.community.viewmodel.fragment.DistinguishViewModel;

public class DistinguishFragment extends BaseVmFragment<FragmentDistinguishBinding, DistinguishViewModel> {

    private static final String TAG = "DistinguishFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<DistinguishViewModel> getSubVMClass() {
        return DistinguishViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_distinguish;
    }
}
