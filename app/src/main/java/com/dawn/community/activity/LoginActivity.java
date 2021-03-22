package com.dawn.community.activity;

import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.dawn.community.CommunityApplication;
import com.dawn.community.R;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivityLoginBinding;
import com.dawn.community.utils.MyAnimations;
import com.dawn.community.viewmodel.activity.LoginViewModel;

public class LoginActivity extends BaseVmActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected void initView() {
        super.initView();
        viewDataBinding.etPassword.setTransformationMethod(new PasswordTransformationMethod());
        hideAllViews();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        //注册按钮跳转页面
        viewDataBinding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityApplication.getContext(),SignUpActivity.class));
            }
        });
    }

    @Override
    protected void initAnimation() {
        super.initAnimation();
        startAnimating(viewDataBinding.viewBubble1);
    }

    /**
     * 载入动画
     * @param viewBubble 开始视图
     */
    private void startAnimating(View viewBubble) {
        try{
            //先设置视图可见
            viewBubble.setVisibility(View.VISIBLE);
            Animation animation;
            //如果遇到了relHeader组件，也即 RelativeLayout，采用的动画不同
            if (viewBubble.getId() == R.id.relHeader) {
                animation = AnimationUtils.loadAnimation(CommunityApplication.getContext(), R.anim.fade_in);
            }else{
                animation = MyAnimations.getInstance().overshootAnimate();
            }

            //开始动画
            viewBubble.startAnimation(animation);

            //设置动画监听器
            if(animation!=null){
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //当动画介绍后，开始另外的动画
                        switch (viewBubble.getId()){
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
                                startAnimatingOthers(viewDataBinding.inpUsername,400L);
                                break;
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }catch (Exception ignore){
        }
    }

    //重载
    private void startAnimatingOthers(View view){
        this.startAnimatingOthers(view,200L);
    }

    /**
     * 开启其他组件动画
     * @param view 视图组件
     * @param durationMillis 时长
     */
    private void startAnimatingOthers(View view, Long durationMillis) {
        try{
            //先设置视图可见
            view.setVisibility(View.VISIBLE);
            Animation animation;
            //根据视图不同，采用动画不同
            switch (view.getId()){
                case R.id.inpUsername:
                case R.id.inpPassword:
                case R.id.txtForgotPass:
                case R.id.relBtnLogin:
                case R.id.relBtnLoginGoogle:
                case R.id.relBtnLoginFacebook:
                    animation = MyAnimations.getInstance().scaleAnimation();
                    break;
                case R.id.txtSignUp:
                case R.id.viewSeparator:
                    animation = AnimationUtils.loadAnimation(CommunityApplication.getContext(),R.anim.fade_in);
                    break;
                case R.id.relHeader:
                    animation = MyAnimations.getInstance().overshootAnimate(durationMillis);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }

            //开始动画
            view.startAnimation(animation);

            //监听动画
            animation.setAnimationListener(new Animation.AnimationListener() {
                //动画开始前
                @Override
                public void onAnimationStart(Animation animation) {
                    switch (view.getId()){
                        case R.id.inpUsername:
                            startAnimatingOthers(viewDataBinding.inpPassword,500L);
                            break;
                        case R.id.inpPassword:
                            startAnimatingOthers(viewDataBinding.txtForgotPass,600L);
                            break;
                        case R.id.txtForgotPass:
                            startAnimatingOthers(viewDataBinding.relBtnLogin,700L);
                            break;
                        case R.id.viewSeparator:
                            startAnimatingOthers(viewDataBinding.relBtnLoginGoogle,700L);
                            break;
                        case R.id.relBtnLoginGoogle:
                            startAnimatingOthers(viewDataBinding.relBtnLoginFacebook,800L);
                            break;
                    }
                }

                //动画结束后
                @Override
                public void onAnimationEnd(Animation animation) {
                    switch (view.getId()){
                        case R.id.relBtnLogin:
                            startAnimatingOthers(viewDataBinding.txtSignUp,500L);
                            break;
                        case R.id.txtSignUp:
                            startAnimatingOthers(viewDataBinding.viewSeparator,400L);
                            break;
                        case R.id.relBtnLoginFacebook:
                            startAnimatingOthers(viewDataBinding.relHeader,600L);
                            break;
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }catch (Exception ignore){
        }
    }

    /**
     * 隐藏所有的UI
     */
    private void hideAllViews() {
        viewDataBinding.inpUsername.setVisibility(View.INVISIBLE);
        viewDataBinding.inpPassword.setVisibility(View.INVISIBLE);
        viewDataBinding.relBtnLogin.setVisibility(View.INVISIBLE);
        viewDataBinding.relBtnLoginGoogle.setVisibility(View.INVISIBLE);
        viewDataBinding.relBtnLoginFacebook.setVisibility(View.INVISIBLE);
        viewDataBinding.txtSignUp.setVisibility(View.INVISIBLE);
        viewDataBinding.txtForgotPass.setVisibility(View.INVISIBLE);

        viewDataBinding.viewBubble1.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble2.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble3.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble4.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble5.setVisibility(View.INVISIBLE);
        viewDataBinding.viewBubble6.setVisibility(View.INVISIBLE);

        viewDataBinding.relHeader.setVisibility(View.INVISIBLE);
        viewDataBinding.viewSeparator.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public Class<LoginViewModel> getSubVMClass() {
        return LoginViewModel.class;
    }
}