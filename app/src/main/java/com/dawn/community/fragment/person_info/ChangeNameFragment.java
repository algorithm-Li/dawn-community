package com.dawn.community.fragment.person_info;

import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangeNameBinding;
import com.dawn.community.viewmodel.fagment.person_info.ChangeNameViewModel;

import java.util.Objects;

public class ChangeNameFragment extends BaseVmFragment<FragmentChangeNameBinding, ChangeNameViewModel> {

    private static final String TAG = "ChangeNameFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ChangeNameViewModel> getSubVMClass() {
        return ChangeNameViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_name;
    }


}
