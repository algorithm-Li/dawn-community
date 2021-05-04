package com.dawn.community.viewmodel.activity;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.api.viewobject.request.bean.LoginReqBean;
import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.repository.LoginRepository;

/**
 * @author Algorithm
 */
public class LoginViewModel extends ViewModel {

    MutableLiveData<LoginState> LOGIN_STATE = new MutableLiveData<>();

    static enum LoginState{
        UN_LOGIN,
        LOGIN_LOADING,
        LOGIN_FAIL,
        LOGIN_SUCCESS,
        AUTO_LOGIN
    }

    //登录请求Bean数据
    private MutableLiveData<LoginReqBean> loginReqBean = new MutableLiveData<>();

    //登录请求发送回调数据
    public LiveData<UserModel> userModelLiveData = Transformations.switchMap(loginReqBean, new Function<LoginReqBean, LiveData<UserModel>>() {
        @Override
        public LiveData<UserModel> apply(LoginReqBean input) {
            return LoginRepository.getInstance().doLogin(input);
        }
    });

    public void setLoginReqBean(LoginReqBean loginReqBean) {
        this.loginReqBean.setValue(loginReqBean);
    }
}
