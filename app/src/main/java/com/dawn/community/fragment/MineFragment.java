package com.dawn.community.fragment;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentMineBinding;
import com.dawn.community.viewmodel.fagment.MineViewModel;

public class MineFragment extends BaseVmFragment<FragmentMineBinding, MineViewModel> {

    private static final String TAG = "MineFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<MineViewModel> getSubVMClass() {
        return MineViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
