package com.dawn.community.fragment.social.message;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.CommunityApplication;
import com.dawn.community.R;
import com.dawn.community.adapter.PrivateMessageAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.history.User;
import com.dawn.community.bean.message.PrivateMessageItem;
import com.dawn.community.databinding.FragmentPrivateMessageBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.viewmodel.fragment.social.message.PrivateMessageViewModel;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class PrivateMessageFragment extends BaseVmFragment<FragmentPrivateMessageBinding, PrivateMessageViewModel> {

    private static final String TAG = "PrivateMessageFragment";

    private PrivateMessageAdapter privateMessageAdapter = new PrivateMessageAdapter();

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        //给Recyclerview设置布局管理器
        viewDataBinding.rvPrivateMessage.setLayoutManager(new LinearLayoutManager(getContext()));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rvPrivateMessage.setAdapter(privateMessageAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rvPrivateMessage.addItemDecoration(new RecyclerView.ItemDecoration() {
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
        viewModel.privateMessageItems.observe(this, new Observer<ArrayList<PrivateMessageItem>>() {
            @Override
            public void onChanged(ArrayList<PrivateMessageItem> privateMessageItems) {
                privateMessageAdapter.setData(privateMessageItems);
                Log.d(TAG,privateMessageItems.toString());
            }
        });
    }

    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewModel.setUser(new User("","","","","",""));
    }

    @Override
    public Class<PrivateMessageViewModel> getSubVMClass() {
        return PrivateMessageViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_private_message;
    }
}
