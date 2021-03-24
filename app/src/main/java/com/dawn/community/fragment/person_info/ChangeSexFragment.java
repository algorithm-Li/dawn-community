package com.dawn.community.fragment.person_info;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangeSexBinding;
import com.dawn.community.viewmodel.fagment.person_info.ChangeSexViewModel;

public class ChangeSexFragment extends BaseVmFragment<FragmentChangeSexBinding, ChangeSexViewModel> {

    private static final String TAG = "ChangeSexFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ChangeSexViewModel> getSubVMClass() {
        return ChangeSexViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_sex;
    }


}
