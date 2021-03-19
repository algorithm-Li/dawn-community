package com.dawn.community.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseViewFragment<T extends ViewDataBinding> extends Fragment {

    //数据绑定的获取对象
    protected T viewDataBinding;

    public BaseViewFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //方式一
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return viewDataBinding.getRoot();
        //方式二
        /*View view = inflater.inflate(getLayoutId(), container, false);
        T dataBinding = DataBindingUtil.bind(view);
        return dataBinding.getRoot();*/
    }

    /**
     * 子类需实现该方法，返回layout的id值
     * @return id 视图id
     */
    public abstract int getLayoutId();
}
