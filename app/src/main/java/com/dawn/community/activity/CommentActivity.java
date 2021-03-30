package com.dawn.community.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.binding_handler.CommonHandler;
import com.dawn.community.databinding.ActivityCommentBinding;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.CommentViewModel;

/**
 * @author Algorithm
 */
public class CommentActivity extends BaseVmActivity<ActivityCommentBinding, CommentViewModel>{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        //设置ToolBar
        setSupportActionBar(viewDataBinding.toolbarComment);
        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setTitle("动态详情页");
        }
    }

    @Override
    protected void startLoadData() {
        super.startLoadData();
        RecommendItem itemData = (RecommendItem)getIntent().getSerializableExtra("itemData");
        viewDataBinding.setItemData(itemData);
        viewDataBinding.setEventHandler(new CommonHandler());
        viewDataBinding.setLifecycleOwner(this);
        viewDataBinding.setContext(this);
    }

    /**
     * 菜单选中监听事件
     * @param item 菜单项
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public Class<CommentViewModel> getSubVMClass() {
        return CommentViewModel.class;
    }
}