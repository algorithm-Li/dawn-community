package com.dawn.community.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.dawn.community.R;
import com.dawn.community.adapter.ChatAdapter;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivityChatBinding;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.ChatViewModel;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;

/**
 * @author Algorithm
 */
public class ChatActivity extends BaseVmActivity<ActivityChatBinding, ChatViewModel>{

    private ChatAdapter chatAdapter = new ChatAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //setStatusBar();
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();

        //设置ToolBar
        setSupportActionBar(viewDataBinding.toolbarChat);
        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            bar.setDisplayHomeAsUpEnabled(true);
        }

        View arrow = viewDataBinding.footer.findViewById(ClassicsFooter.ID_IMAGE_ARROW);
        arrow.setScaleY(-1);//必须设置

        viewDataBinding.listView.setAdapter(chatAdapter);
        viewDataBinding.listView.setScaleY(-1);

    }

    @Override
    protected void initEvent() {
        super.initEvent();

        viewDataBinding.refreshLayout.setEnableRefresh(false);
        viewDataBinding.refreshLayout.setEnableAutoLoadMore(true);
        viewDataBinding.refreshLayout.setEnableNestedScroll(false);
        viewDataBinding.refreshLayout.setEnableScrollContentWhenLoaded(true);
        viewDataBinding.refreshLayout.getLayout().setScaleY(-1);
        viewDataBinding.refreshLayout.setScrollBoundaryDecider(new ScrollBoundaryDecider() {

            @Override
            public boolean canRefresh(View content) {
                return false;
            }

            @Override
            public boolean canLoadMore(View content) {
                return this.canRefresh(content);
            }
        });

        //监听加载，而不是监听 刷新
        viewDataBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chatAdapter.addData();
                        refreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });
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
        return R.layout.activity_chat;
    }

    @Override
    public Class<ChatViewModel> getSubVMClass() {
        return ChatViewModel.class;
    }

    /**
     * 设置状态栏透明
     */
    private void setStatusBar()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }
}