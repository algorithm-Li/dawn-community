package com.dawn.community.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.binding_handler.CommonHandler;
import com.dawn.community.databinding.ActivityPostArticlesBinding;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.PostArticlesViewModel;

/**
 * @author Algorithm
 */
public class PostArticlesActivity extends BaseVmActivity<ActivityPostArticlesBinding, PostArticlesViewModel>{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //setStatusBar();
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.setCommonHandler(new CommonHandler());
        /*TextView textView = findViewById(R.id.idea_cancel);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        viewDataBinding.toolbarTop.ideaCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_post_articles;
    }

    @Override
    public Class<PostArticlesViewModel> getSubVMClass() {
        return PostArticlesViewModel.class;
    }

}