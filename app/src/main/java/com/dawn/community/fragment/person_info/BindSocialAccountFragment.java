package com.dawn.community.fragment.person_info;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentBindSocialAccountBinding;
import com.dawn.community.viewmodel.fragment.person_info.BindSoicalAccountViewModel;

public class BindSocialAccountFragment extends BaseVmFragment<FragmentBindSocialAccountBinding, BindSoicalAccountViewModel> {

    private static final String TAG = "BSAFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<BindSoicalAccountViewModel> getSubVMClass() {
        return BindSoicalAccountViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_bind_social_account;
    }
}
