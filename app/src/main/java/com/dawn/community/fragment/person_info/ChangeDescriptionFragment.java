package com.dawn.community.fragment.person_info;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangeDescriptionBinding;
import com.dawn.community.viewmodel.fragment.person_info.ChangeDescriptionViewModel;

/**
 * @author Algorithm
 */
public class ChangeDescriptionFragment extends BaseVmFragment<FragmentChangeDescriptionBinding, ChangeDescriptionViewModel> {

    private static final String TAG = "CDescriptionFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ChangeDescriptionViewModel> getSubVMClass() {
        return ChangeDescriptionViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_description;
    }


}
