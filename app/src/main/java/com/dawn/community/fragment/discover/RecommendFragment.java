package com.dawn.community.fragment.discover;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentRecommendBinding;
import com.dawn.community.viewmodel.fagment.social.RecommendViewModel;

public class RecommendFragment extends BaseVmFragment<FragmentRecommendBinding, RecommendViewModel> {

    @Override
    public Class<RecommendViewModel> getSubVMClass() {
        return RecommendViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
