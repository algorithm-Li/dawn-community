package com.dawn.community.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Algorithm
 */
public abstract class BaseVmActivity<T extends ViewDataBinding, VM extends ViewModel> extends BaseViewActivity<T> {

    //ViewModel对象，泛型
    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建ViewModel
        initViewModel();
        //观察数据变化 --> 更新UI
        observerData();
        //初始化页面
        initView();
        //设置相关的事件
        initEvent();
        //载入动画
        initAnimation();
        //开始去加载数据
        startLoadData();
    }

    protected void initAnimation() { }

    protected void initView(){ }

    protected void startLoadData() { }

    protected void initEvent() { }

    protected void observerData() { }

    /**
     * 创建ViewModel
     */
    protected void initViewModel() {
        viewModel = new ViewModelProvider(this).get(getSubVMClass());
    }

    /**
     * 用户必须重写
     * 用来构建ViewModel
     * @return ViewModel实现的类
     */
    public abstract Class<VM> getSubVMClass();

}
