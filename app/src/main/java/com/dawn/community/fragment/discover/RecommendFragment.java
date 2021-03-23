package com.dawn.community.fragment.discover;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentRecommendBinding;
import com.dawn.community.viewmodel.fagment.social.RecommendViewModel;

public class RecommendFragment extends BaseVmFragment<FragmentRecommendBinding, RecommendViewModel> {

    private static final String TAG = "RecommendFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<RecommendViewModel> getSubVMClass() {
        return RecommendViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
