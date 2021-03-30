package com.dawn.community.fragment.person_info;

import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentBindSocialAccountBinding;
import com.dawn.community.viewmodel.fragment.person_info.BindSoicalAccountViewModel;

import java.util.Objects;

/**
 * @author Algorithm
 */
public class BindSocialAccountFragment extends BaseVmFragment<FragmentBindSocialAccountBinding, BindSoicalAccountViewModel> {

    private static final String TAG = "BSAFragment";
    NavController navController;

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        navController = NavHostFragment.findNavController(this);

        ((AppCompatActivity) requireActivity()).setSupportActionBar(viewDataBinding.toolbarBindAccount);
        setHasOptionsMenu(true);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
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
                navController.navigateUp();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public Class<BindSoicalAccountViewModel> getSubVMClass() {
        return BindSoicalAccountViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_bind_social_account;
    }
}
