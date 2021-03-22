package com.dawn.community.activity;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivitySignUpBinding;
import com.dawn.community.viewmodel.activity.SignUpViewModel;

public class SignUpActivity extends BaseVmActivity<ActivitySignUpBinding, SignUpViewModel> {

    @Override
    protected void initView() {
        super.initView();
        viewDataBinding.etPassword.setTransformationMethod(new PasswordTransformationMethod());
        hideAllView();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.relBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewDataBinding.relBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void hideAllView() {
        viewDataBinding.inpName.setVisibility(View.INVISIBLE);
        viewDataBinding.inpEmail.setVisibility(View.INVISIBLE);
        viewDataBinding.inpPassword.setVisibility(View.INVISIBLE);
        viewDataBinding.inpPhone.setVisibility(View.INVISIBLE);

        viewDataBinding.relBtnLogin.setVisibility(View.INVISIBLE);
        viewDataBinding.relBtnSignUp.setVisibility(View.INVISIBLE);

        viewDataBinding.viewBubble1.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble2.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble3.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble4.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble5.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble6.setVisibility(View.INVISIBLE);

        viewDataBinding.relHeader.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_sign_up;
    }

    @Override
    public Class<SignUpViewModel> getSubVMClass() {
        return SignUpViewModel.class;
    }
}