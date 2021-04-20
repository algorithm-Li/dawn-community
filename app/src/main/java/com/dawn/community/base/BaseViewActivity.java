package com.dawn.community.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author Algorithm
 * @param <T> ViewDataBinding的泛型
 */
public abstract class BaseViewActivity<T extends ViewDataBinding> extends AppCompatActivity {

    //数据绑定的获取对象
    protected T viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        //添加开启的activity
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //删除activity
        ActivityCollector.removeActivity(this);
    }

    /**
     * 子类需实现该方法，返回layout的id值
     * @return id 视图id
     */
    @LayoutRes
    public abstract int getLayoutId();
}
