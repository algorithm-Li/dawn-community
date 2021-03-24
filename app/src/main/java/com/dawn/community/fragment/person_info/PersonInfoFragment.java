package com.dawn.community.fragment.person_info;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentPersonInfoBinding;
import com.dawn.community.viewmodel.activity.PersonInfoViewModel;

public class PersonInfoFragment extends BaseVmFragment<FragmentPersonInfoBinding, PersonInfoViewModel> implements View.OnClickListener {

    private static final String TAG = "PersonInfoFragment";
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
        //设置控件监听器，在本Fragment中实现接口
        viewDataBinding.actionBack.setOnClickListener(this);
        viewDataBinding.relName.setOnClickListener(this);
        viewDataBinding.relSex.setOnClickListener(this);
        viewDataBinding.relBirthday.setOnClickListener(this);
        viewDataBinding.relDescription.setOnClickListener(this);
        viewDataBinding.relPhoneNumber.setOnClickListener(this);
        viewDataBinding.relOtherAccount.setOnClickListener(this);
        viewDataBinding.relEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                //直接结束整个Activity，因为这个Fragment是套在本Activity中的最开始位置
                requireActivity().finish();
                break;
            case R.id.rel_name:
                navController.navigate(R.id.action_personInfoFragment_to_changeNameFragment);
                break;
            case R.id.rel_sex:
                navController.navigate(R.id.action_personInfoFragment_to_changeSexFragment);
                break;
            case R.id.rel_birthday:
                navController.navigate(R.id.action_personInfoFragment_to_changeBirthdayFragment);
                break;
            case R.id.rel_description:
                navController.navigate(R.id.action_personInfoFragment_to_changeDescriptionFragment);
                break;
            case R.id.rel_phone_number:
                navController.navigate(R.id.action_personInfoFragment_to_changePhoneFragment);
                break;
            case R.id.rel_other_account:
                navController.navigate(R.id.action_personInfoFragment_to_bindSocialAccountFragment);
                break;
            case R.id.rel_email:
                navController.navigate(R.id.action_personInfoFragment_to_changeEmailFragment);
                break;
            default:
                break;
        }
    }

    @Override
    public Class<PersonInfoViewModel> getSubVMClass() {
        return PersonInfoViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_person_info;
    }
}
