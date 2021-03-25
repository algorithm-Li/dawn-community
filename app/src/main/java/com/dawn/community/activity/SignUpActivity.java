package com.dawn.community.activity;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivitySignUpBinding;
import com.dawn.community.utils.MyAnimations;
import com.dawn.community.viewmodel.activity.SignUpViewModel;

/**
 * @author Algorithm
 */
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

    @Override
    protected void initAnimation() {
        super.initAnimation();
        startAnimating(viewDataBinding.viewBubble1);
    }

    private void startAnimating(View view) {
        this.startAnimating(view,200L);
    }

    private void startAnimating(View view,Long durationMillis) {
        try{
            view.setVisibility(View.VISIBLE);
            Animation animation;
            switch(view.getId()){
                case R.id.inpName:
                case R.id.inpEmail:
                case R.id.inpPhone:
                case R.id.inpPassword:
                case R.id.relBtnLogin:
                case R.id.relBtnSignUp:
                    animation = MyAnimations.getInstance().scaleAnimation(durationMillis);
                    break;
                default:
                    animation = MyAnimations.getInstance().overshootAnimate(durationMillis);
            }

            view.startAnimation(animation);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    switch (view.getId()){
                        case R.id.inpName:
                            startAnimating(viewDataBinding.inpEmail,400L);
                            break;
                        case R.id.inpEmail:
                            startAnimating(viewDataBinding.inpPhone,500L);
                            break;
                        case R.id.inpPhone:
                            startAnimating(viewDataBinding.inpPassword,600L);
                            break;
                        case R.id.inpPassword:
                            startAnimating(viewDataBinding.relBtnSignUp,700L);
                            break;
                        case R.id.relBtnSignUp:
                            startAnimating(viewDataBinding.relBtnLogin,950L);
                            break;
                    }
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    switch (view.getId()){
                        case R.id.viewBubble1:
                            startAnimating(viewDataBinding.viewBubble2);
                            break;
                        case R.id.viewBubble2:
                            startAnimating(viewDataBinding.viewBubble3);
                            break;
                        case R.id.viewBubble3:
                            startAnimating(viewDataBinding.viewBubble4);
                            break;
                        case R.id.viewBubble4:
                            startAnimating(viewDataBinding.viewBubble5);
                            break;
                        case R.id.viewBubble5:
                            startAnimating(viewDataBinding.viewBubble6);
                            break;
                        case R.id.viewBubble6:
                            startAnimating(viewDataBinding.inpName);
                            break;
                        case R.id.relBtnLogin:
                            startAnimating(viewDataBinding.relHeader,600L);
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }catch (Exception ignore){

        }
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