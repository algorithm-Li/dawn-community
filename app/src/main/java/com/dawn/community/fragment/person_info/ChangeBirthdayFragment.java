package com.dawn.community.fragment.person_info;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangeBirthdayBinding;
import com.dawn.community.viewmodel.fragment.person_info.ChangeBirthdayViewModel;

/**
 * @author Algorithm
 */
public class ChangeBirthdayFragment extends BaseVmFragment<FragmentChangeBirthdayBinding, ChangeBirthdayViewModel> {

    private static final String TAG = "ChangeBirthdayFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ChangeBirthdayViewModel> getSubVMClass() {
        return ChangeBirthdayViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_birthday;
    }


}
