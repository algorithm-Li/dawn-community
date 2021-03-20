package com.dawn.community.fragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentDistinguishBinding;
import com.dawn.community.viewmodel.DistinguishViewModel;

public class DistinguishFragment extends BaseVmFragment<FragmentDistinguishBinding, DistinguishViewModel> {

    @Override
    public Class<DistinguishViewModel> getSubVMClass() {
        return DistinguishViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_distinguish;
    }
}
