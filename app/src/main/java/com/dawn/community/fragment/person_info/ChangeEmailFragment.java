package com.dawn.community.fragment.person_info;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangeEmailBinding;
import com.dawn.community.viewmodel.fragment.person_info.ChangeEmailViewModel;

/**
 * @author Algorithm
 */
public class ChangeEmailFragment extends BaseVmFragment<FragmentChangeEmailBinding, ChangeEmailViewModel> {

    private static final String TAG = "ChangeEmailFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ChangeEmailViewModel> getSubVMClass() {
        return ChangeEmailViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_email;
    }


}
