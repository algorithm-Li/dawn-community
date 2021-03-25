package com.dawn.community.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.adapter.HistoryListAdapter;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.bean.history.HistoryItem;
import com.dawn.community.bean.history.User;
import com.dawn.community.databinding.ActivityHistoryBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.HistoryViewModel;

import java.util.ArrayList;

public class HistoryActivity extends BaseVmActivity<ActivityHistoryBinding, HistoryViewModel>{

    HistoryListAdapter historyListAdapter = new HistoryListAdapter();

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
        viewDataBinding.rvHistory.setLayoutManager(new LinearLayoutManager(this));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rvHistory.setAdapter(historyListAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rvHistory.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //单位是px，不适配，0.8dp转成px
                outRect.bottom = SizeUtils.dip2px(getApplicationContext(),0.8f);
            }
        });
        //设置ToolBar
        setSupportActionBar(viewDataBinding.toolbarHistory);
        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setTitle("观看历史");
        }
    }

    @Override
    protected void observerData() {
        super.observerData();
        viewModel.historyItemLiveData.observe(this, new Observer<ArrayList<HistoryItem>>() {
            @Override
            public void onChanged(ArrayList<HistoryItem> historyItems) {
                historyListAdapter.setData(historyItems);
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
            case R.id.history_video_clear:
                //删除操作
                //待补充
                //记得更新adapter数据
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * toolBar绑定菜单
     * @param menu 菜单
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_history_video_clear,menu);
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    public Class<HistoryViewModel> getSubVMClass() {
        return HistoryViewModel.class;
    }
}