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
import com.dawn.community.adapter.RecommendAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.bean.history.User;
import com.dawn.community.bean.message.PrivateMessageItem;
import com.dawn.community.databinding.FragmentRecommendBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.viewmodel.fragment.discover.RecommendViewModel;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class RecommendFragment extends BaseVmFragment<FragmentRecommendBinding, RecommendViewModel> {

    private static final String TAG = "RecommendFragment";

    private RecommendAdapter recommendAdapter = new RecommendAdapter();

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        //给Recyclerview设置布局管理器
        viewDataBinding.rvRecommend.setLayoutManager(new LinearLayoutManager(getContext()));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rvRecommend.setAdapter(recommendAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rvRecommend.addItemDecoration(new RecyclerView.ItemDecoration() {
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
        viewModel.recommendItems.observe(this, new Observer<ArrayList<RecommendItem>>() {
            @Override
            public void onChanged(ArrayList<RecommendItem> recommendItems) {
                recommendAdapter.setData(recommendItems);
                for (RecommendItem recommendItem : recommendItems) {
                    Log.d(TAG,recommendItem.toString());
                }
            }
        });
    }

    /**
     * 加载数据
     */
    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewModel.setUser(new User("","","","","",""));
    }

    @Override
    public Class<RecommendViewModel> getSubVMClass() {
        return RecommendViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
