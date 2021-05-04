package com.dawn.community.viewmodel.activity;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.activity.SignUpActivity;
import com.dawn.community.api.viewobject.OtpModel;
import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.api.viewobject.request.bean.RegisterReqBean;
import com.dawn.community.repository.SignUpRepository;

/**
 * @author Algorithm
 */
public class SignUpViewModel extends ViewModel {

    //电话号码监听，用户点击了获取验证码，就会将电话号码赋值到这里
    private MutableLiveData<String> telephone = new MutableLiveData<>();

    //注册用户请求信息
    private MutableLiveData<RegisterReqBean> registerReqBeanMutableLiveData = new MutableLiveData<>();

    //根据电话号码改变，去仓库发起获取验证码的请求
    public LiveData<OtpModel> checkCode = Transformations.switchMap(telephone, new Function<String, LiveData<OtpModel>>() {
        @Override
        public LiveData<OtpModel> apply(String input) {
            return SignUpRepository.getInstance().sss(input);
        }
    });

    //获取点击注册后返回的数据
    public LiveData<UserModel> userModelLiveData = Transformations.switchMap(registerReqBeanMutableLiveData, new Function<RegisterReqBean, LiveData<UserModel>>() {
        @Override
        public LiveData<UserModel> apply(RegisterReqBean input) {
            return SignUpRepository.getInstance().register(input);
        }
    });

    public void setTelephone(String telephone) {
        this.telephone.setValue(telephone);
    }

    public void setRegisterReqBeanMutableLiveData(RegisterReqBean registerReqBean){
        this.registerReqBeanMutableLiveData.setValue(registerReqBean);
    }
}
