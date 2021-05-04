package com.dawn.community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.dawn.community.R;
import com.dawn.community.api.viewobject.OtpModel;
import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.api.viewobject.request.bean.RegisterReqBean;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivitySignUpBinding;
import com.dawn.community.utils.MyAnimations;
import com.dawn.community.utils.common.StatusBar;
import com.dawn.community.viewmodel.activity.SignUpViewModel;

import java.util.Objects;

/**
 * @author Algorithm
 */
public class SignUpActivity extends BaseVmActivity<ActivitySignUpBinding, SignUpViewModel> {

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
        viewDataBinding.etPasswordAgain.setTransformationMethod(new PasswordTransformationMethod());
        hideAllView();
    }

    //监听数据变化
    @Override
    protected void observerData() {
        super.observerData();
        viewModel.checkCode.observe(this, new Observer<OtpModel>() {
                    @Override
                    public void onChanged(OtpModel otpModel) {
                        Log.d("checkCode","数据改变");
                        if(otpModel!=null){
                            if(otpModel.getCode() == 200){
                                viewDataBinding.etCheckCode.setText(otpModel.getData().getOtpCode());
                            }
                            else if(otpModel.getCode() == 20004){
                                Toast.makeText(SignUpActivity.this,otpModel.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
        viewModel.userModelLiveData.observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                System.out.println(userModel);
                if(userModel.getCode() == 200){
                    Toast.makeText(SignUpActivity.this,"注册成功，将跳转到登录压面",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(SignUpActivity.this,userModel.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        //监听获取验证码按钮
        viewDataBinding.btnCheckCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setTelephone(Objects.requireNonNull(viewDataBinding.etTelephone.getText()).toString());
            }
        });
        //监听登录按钮
        viewDataBinding.relBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //监听注册按钮
        viewDataBinding.relBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里补充对输入的数据进行判断
                RegisterReqBean registerReqBean = new RegisterReqBean(
                        Objects.requireNonNull(viewDataBinding.etTelephone.getText()).toString().trim(),
                        Objects.requireNonNull(viewDataBinding.etCheckCode.getText()).toString().trim(),
                        Objects.requireNonNull(viewDataBinding.etPassword.getText()).toString().trim(),
                        Objects.requireNonNull(viewDataBinding.etPasswordAgain.getText()).toString().trim()
                );
                viewModel.setRegisterReqBeanMutableLiveData(registerReqBean);
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
                case R.id.inpTelephone:
                case R.id.LLCheckCode:
                case R.id.inpPassword:
                case R.id.inpPasswordAgain:
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
                        case R.id.inpTelephone:
                            startAnimating(viewDataBinding.LLCheckCode,400L);
                            break;
                        case R.id.LLCheckCode:
                            startAnimating(viewDataBinding.inpPassword,500L);
                            break;
                        case R.id.inpPassword:
                            startAnimating(viewDataBinding.inpPasswordAgain,600L);
                            break;
                        case R.id.inpPasswordAgain:
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
                            startAnimating(viewDataBinding.inpTelephone);
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
        viewDataBinding.inpTelephone.setVisibility(View.INVISIBLE);
        viewDataBinding.LLCheckCode.setVisibility(View.INVISIBLE);
        viewDataBinding.inpPassword.setVisibility(View.INVISIBLE);
        viewDataBinding.inpPasswordAgain.setVisibility(View.INVISIBLE);

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