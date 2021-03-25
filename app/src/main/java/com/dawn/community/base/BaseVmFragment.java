package com.dawn.community.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Algorithm
 * 带ViewModel的基类
 * 还不知道具体的布局和Binding以及ViewModel
 */
public abstract class BaseVmFragment<T extends ViewDataBinding, VM extends ViewModel> extends BaseViewFragment<T>{

    //ViewModel对象，泛型
    protected VM viewModel;

    public BaseVmFragment(){
        super();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //创建ViewModel
        initViewModel();
        //初始化页面
        initView();
        //观察数据变化 --> 更新UI
        observerData();
        //设置相关的事件
        initEvent();
        //开始去加载数据
        startLoadData();
    }

    protected void initView(){

    }

    protected void startLoadData() {

    }

    protected void initEvent() {

    }


    protected void observerData() {

    }

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
