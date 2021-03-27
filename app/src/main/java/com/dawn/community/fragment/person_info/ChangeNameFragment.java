package com.dawn.community.fragment.person_info;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentChangeNameBinding;
import com.dawn.community.viewmodel.fragment.person_info.ChangeNameViewModel;

/**
 * @author Algorithm
 */
public class ChangeNameFragment extends BaseVmFragment<FragmentChangeNameBinding, ChangeNameViewModel> implements View.OnClickListener {

    private static final String TAG = "ChangeNameFragment";
    NavController navController;

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        navController = NavHostFragment.findNavController(this);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.actionBack.setOnClickListener(this);
    }

    @Override
    public Class<ChangeNameViewModel> getSubVMClass() {
        return ChangeNameViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_name;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                navController.navigateUp();
                break;
            default:
                break;
        }
    }
}
