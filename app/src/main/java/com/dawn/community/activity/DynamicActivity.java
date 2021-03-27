package com.dawn.community.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivityDynamicBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.DynamicViewModel;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;

/**
 * @author Algorithm
 */
public class DynamicActivity extends BaseVmActivity<ActivityDynamicBinding, DynamicViewModel> {

    private int mOffset = 0;
    private int mScrollY = 0;

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
    protected void initEvent() {
        super.initEvent();
        //refreshLayout 滑动事件刷新监听
        viewDataBinding.refreshLayoutRecommend.setOnMultiListener(new SimpleMultiListener(){

            //头部刷新时，隐藏ToolBar及ToolBar里包含的头像和用户名
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                super.onHeaderMoving(header, isDragging, percent, offset, headerHeight, maxDragHeight);
                mOffset = offset / 2;
                viewDataBinding.parallax.setTranslationY(mOffset - mScrollY);
                viewDataBinding.toolbarDynamic.setAlpha(1 - Math.min(percent, 1));
            }

            //3秒内解决刷新结束，就算没有添加数据
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(3000);
            }

            //2秒内解决刷新结束，就算没有添加数据
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }
        });

        //NestedScrollView 滑动事件监听
        viewDataBinding.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            private int lastScrollY = 0;
            private int h = SizeUtils.dip2px(getApplicationContext(),170.0f);
            private int color = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)&0x00ffffff;

            //根据计算，设置ToolBar底色的显示和置顶
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
                    viewDataBinding.buttonBar.setAlpha(1f * mScrollY / h);
                    viewDataBinding.toolbarDynamic.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                    viewDataBinding.parallax.setTranslationY(mOffset - mScrollY);
                }
                lastScrollY = scrollY;
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dynamic;
    }

    @Override
    public Class<DynamicViewModel> getSubVMClass() {
        return DynamicViewModel.class;
    }
}