package com.dawn.community.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivitySettingBinding;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.SettingViewModel;

/**
 * @author Algorithm
 */
public class SettingActivity extends BaseVmActivity<ActivitySettingBinding, SettingViewModel>{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public Class<SettingViewModel> getSubVMClass() {
        return SettingViewModel.class;
    }
}