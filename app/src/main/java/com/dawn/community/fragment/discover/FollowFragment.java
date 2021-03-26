package com.dawn.community.fragment.discover;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.CommunityApplication;
import com.dawn.community.R;
import com.dawn.community.adapter.FollowAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.discover.FollowItem;
import com.dawn.community.bean.User;
import com.dawn.community.databinding.FragmentFollowBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.viewmodel.fragment.discover.FollowViewModel;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class FollowFragment extends BaseVmFragment<FragmentFollowBinding, FollowViewModel> {

    private static final String TAG = "FollowFragment";

    private FollowAdapter followAdapter = new FollowAdapter();

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        //给Recyclerview设置布局管理器
        viewDataBinding.rvFollow.setLayoutManager(new LinearLayoutManager(getContext()));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rvFollow.setAdapter(followAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rvFollow.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //单位是px，不适配，0.8dp转成px
                outRect.bottom = SizeUtils.dip2px(CommunityApplication.getContext(),0.8f);
            }
        });
    }

    @Override
    protected void observerData() {
        super.observerData();
        viewModel.followItems.observe(this, new Observer<ArrayList<FollowItem>>() {
            @Override
            public void onChanged(ArrayList<FollowItem> followItems) {
                followAdapter.setData(followItems);
                Log.d(TAG,followItems.toString());
            }
        });
    }

    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewModel.setUser(new User("","","","","",""));
    }

    @Override
    public Class<FollowViewModel> getSubVMClass() {
        return FollowViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_follow;
    }
}
