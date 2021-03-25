package com.dawn.community.fragment.person_info;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangePhoneBinding;
import com.dawn.community.viewmodel.fragment.person_info.ChangePhoneViewModel;

/**
 * @author Algorithm
 */
public class ChangePhoneFragment extends BaseVmFragment<FragmentChangePhoneBinding, ChangePhoneViewModel> {

    private static final String TAG = "ChangePhoneFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ChangePhoneViewModel> getSubVMClass() {
        return ChangePhoneViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_phone;
    }


}
