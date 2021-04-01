package com.dawn.community.fragment.person_info;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.binding_handler.CommonHandler;
import com.dawn.community.databinding.FragmentChangeSexBinding;
import com.dawn.community.viewmodel.fragment.person_info.ChangeSexViewModel;

/**
 * @author Algorithm
 */
public class ChangeSexFragment extends BaseVmFragment<FragmentChangeSexBinding, ChangeSexViewModel> implements View.OnClickListener {

    private static final String TAG = "ChangeSexFragment";
    NavController navController;

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        navController = NavHostFragment.findNavController(this);
    }

    @Override
    protected void observerData() {
        super.observerData();
        viewModel.chooseSex.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String sex) {
                viewDataBinding.setChooseSex(sex);
                viewDataBinding.setVm(viewModel);
                viewDataBinding.setEventHandler(new CommonHandler());
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.actionBack.setOnClickListener(this);
    }

    /**
     * 加载数据
     */
    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewModel.setSex("保密");
    }

    @Override
    public Class<ChangeSexViewModel> getSubVMClass() {
        return ChangeSexViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_change_sex;
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
