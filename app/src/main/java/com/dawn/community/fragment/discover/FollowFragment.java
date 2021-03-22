package com.dawn.community.fragment.discover;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentFollowBinding;
import com.dawn.community.viewmodel.fagment.social.FollowViewModel;

public class FollowFragment extends BaseVmFragment<FragmentFollowBinding, FollowViewModel> {

    @Override
    public Class<FollowViewModel> getSubVMClass() {
        return FollowViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_follow;
    }
}
