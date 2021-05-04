package com.dawn.community.fragment.setting;

import android.util.Log;
import android.view.View;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentSettingBinding;
import com.dawn.community.viewmodel.fragment.setting.SettingViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 */
public class SettingFragment extends BaseVmFragment<FragmentSettingBinding, SettingViewModel> implements View.OnClickListener {

    private static final String TAG = "SettingFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.topBarSetting.toolbarBack.setOnClickListener(this);
    }

    @Override
    public Class<SettingViewModel> getSubVMClass() {
        return SettingViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void onClick(@NotNull View v) {
        switch (v.getId()){
            case R.id.toolbar_back:
                requireActivity().finish();
                break;
            default:
                break;
        }
    }
}
