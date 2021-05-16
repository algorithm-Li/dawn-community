package com.dawn.community.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.dawn.community.CommunityApplication;
import com.dawn.community.MainActivity;
import com.dawn.community.R;
import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.api.viewobject.request.bean.LoginReqBean;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.binding_handler.CommonHandler;
import com.dawn.community.databinding.ActivityLoginBinding;
import com.dawn.community.utils.MyAnimations;
import com.dawn.community.utils.common.Interpolator;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.LoginViewModel;

/**
 * @author Algorithm
 */
public class LoginActivity extends BaseVmActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //启用沉浸式布局，白底黑字,需在setContentView前调用
        StatusBar.fitSystemBar(this);
        super.onCreate(savedInstanceState);
    }

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
                finish();
            }
        });

        viewDataBinding.relBtnLogin.setOnClickListener(new animationOnClickListener());
    }

    @Override
    protected void observerData() {
        super.observerData();
        //观察登录是否成功数据
        viewModel.userModelLiveData.observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                if(userModel.getCode() == 200){
                    viewModel.LOGIN_STATE.setValue(LoginViewModel.LoginState.LOGIN_SUCCESS);
                }else{
                    viewModel.LOGIN_STATE.setValue(LoginViewModel.LoginState.LOGIN_FAIL);
                }
            }
        });

        //观察登录状态数据
        viewModel.LOGIN_STATE.observe(this, new Observer<LoginViewModel.LoginState>() {
            @Override
            public void onChanged(LoginViewModel.LoginState loginState) {
                switch (loginState){
                    case LOGIN_SUCCESS:
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                        break;
                    case LOGIN_FAIL:
                        recovery();
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected void initViewModel() {
        super.initViewModel();

    }

    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewDataBinding.setCommonHandel(new CommonHandler());
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
                case R.id.relBtnPass:
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
                        case R.id.relBtnLoginFacebook:
                            startAnimatingOthers(viewDataBinding.relBtnPass,800L);
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
        viewDataBinding.relBtnPass.setVisibility(View.INVISIBLE);
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

    class animationOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(viewDataBinding.inputLayLout.getVisibility() == View.VISIBLE){

                //先隐藏里面的内容
                viewDataBinding.inpUsername.setVisibility(View.INVISIBLE);
                viewDataBinding.inpPassword.setVisibility(View.INVISIBLE);
                viewDataBinding.txtForgotPass.setVisibility(View.INVISIBLE);
                viewDataBinding.relBtnLogin.setVisibility(View.INVISIBLE);
                viewDataBinding.txtSignUp.setVisibility(View.INVISIBLE);

                //再隐藏外壳
                inputAnimator(viewDataBinding.inputLayLout);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoginReqBean loginReqBean = new LoginReqBean(
                                viewDataBinding.etUsername.getText().toString(),
                                viewDataBinding.etPassword.getText().toString(),
                                "login");
                        viewModel.setLoginReqBean(loginReqBean);
                        viewModel.LOGIN_STATE.setValue(LoginViewModel.LoginState.LOGIN_LOADING);
                    }
                }, 2000);

            }
        }
    }

    private void inputAnimator(final View view) {

        AnimatorSet set = new AnimatorSet();

        /*ValueAnimator animator = ValueAnimator.ofFloat(0, w);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view
                        .getLayoutParams();
                params.leftMargin = (int) value;
                params.rightMargin = (int) value;
                view.setLayoutParams(params);
            }
        });*/

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(viewDataBinding.inputLayLout,
                "scaleX", 1f, 0.5f);
        set.setDuration(1000);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        //set.playTogether(animator, animator2);
        set.play(animator2);
        set.start();
        set.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                //隐藏外壳后，载入新的内容
                viewDataBinding.loginLayoutProgress.setVisibility(View.VISIBLE);
                progressAnimator(viewDataBinding.loginLayoutProgress);
                viewDataBinding.inputLayLout.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

    }

    private void progressAnimator(final View view) {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
                0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
                0.5f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view,
                animator, animator2);
        animator3.setDuration(1000);
        animator3.setInterpolator(new Interpolator());
        animator3.start();
    }

    /**
     * 恢复初始状态
     */
    private void recovery() {

        viewDataBinding.loginLayoutProgress.setVisibility(View.GONE);

        viewDataBinding.inpUsername.setVisibility(View.VISIBLE);
        viewDataBinding.inpPassword.setVisibility(View.VISIBLE);
        viewDataBinding.txtForgotPass.setVisibility(View.VISIBLE);
        viewDataBinding.relBtnLogin.setVisibility(View.VISIBLE);
        viewDataBinding.txtSignUp.setVisibility(View.VISIBLE);
        viewDataBinding.inputLayLout.setVisibility(View.VISIBLE);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) viewDataBinding.inputLayLout.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        viewDataBinding.inputLayLout.setLayoutParams(params);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(viewDataBinding.inputLayLout, "scaleX", 0.5f,1f );
        animator2.setDuration(500);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());
        animator2.start();
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