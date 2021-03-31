package com.dawn.community.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.adapter.FollowListAdapter;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.bean.FollowMessageItem;
import com.dawn.community.bean.User;
import com.dawn.community.databinding.ActivityFollowListBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.FollowListViewModel;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class FollowListActivity extends BaseVmActivity<ActivityFollowListBinding, FollowListViewModel>{

    FollowListAdapter followListAdapter = new FollowListAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        //给Recyclerview设置布局管理器
        viewDataBinding.rvFollowList.setLayoutManager(new LinearLayoutManager(this));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rvFollowList.setAdapter(followListAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rvFollowList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //单位是px，不适配，0.8dp转成px
                outRect.bottom = SizeUtils.dip2px(getApplicationContext(),0.8f);
            }
        });
        //设置ToolBar
        setSupportActionBar(viewDataBinding.toolbarFollowList);
    }

    @Override
    protected void observerData() {
        super.observerData();
        viewModel.followMessageItems.observe(this, new Observer<ArrayList<FollowMessageItem>>() {
            @Override
            public void onChanged(ArrayList<FollowMessageItem> followMessageItems) {
                followListAdapter.setData(followMessageItems);
            }
        });
    }

    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewModel.setUser(new User("","","","","",""));
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
        return R.layout.activity_follow_list;
    }

    @Override
    public Class<FollowListViewModel> getSubVMClass() {
        return FollowListViewModel.class;
    }
}