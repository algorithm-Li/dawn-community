package com.dawn.community.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.dawn.community.R;
import com.dawn.community.activity.HistoryActivity;
import com.dawn.community.activity.MessageCenterActivity;
import com.dawn.community.activity.PersonInfoActivity;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentMineBinding;
import com.dawn.community.viewmodel.fragment.MineViewModel;

/**
 * @author Algorithm
 */
public class MineFragment extends BaseVmFragment<FragmentMineBinding, MineViewModel> implements View.OnClickListener {

    private static final String TAG = "MineFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.goDetail.setOnClickListener(this);
        viewDataBinding.userName.setOnClickListener(this);
        viewDataBinding.description.setOnClickListener(this);
        viewDataBinding.userHistory.setOnClickListener(this);
        viewDataBinding.relMessageCenter.setOnClickListener(this);
    }

    @Override
    public Class<MineViewModel> getSubVMClass() {
        return MineViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_detail:
            case R.id.user_name:
            case R.id.description:
                startActivity(new Intent(getContext(), PersonInfoActivity.class));
                break;
            //剩下的补充
            case R.id.user_image:
                break;
            case R.id.user_history:
                startActivity(new Intent(getContext(), HistoryActivity.class));
                break;
            case R.id.rel_message_center:
                startActivity(new Intent(getContext(), MessageCenterActivity.class));
            default:
                break;
        }
    }
}
