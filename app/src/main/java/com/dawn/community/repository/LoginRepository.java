package com.dawn.community.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.api.ApiServices;
import com.dawn.community.api.BaseSubscriber;
import com.dawn.community.api.RetrofitServiceBuilder;
import com.dawn.community.api.viewobject.request.bean.LoginReqBean;
import com.dawn.community.api.viewobject.UserModel;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Algorithm
 * @Date: 2021/4/29/0029
 * @Time: 1:08
 */
public class LoginRepository {

    private static final String TAG = "LoginRepository";

    private static LoginRepository LOGIN_REPOSITORY = new LoginRepository();

    public static LoginRepository getInstance(){
        if(LOGIN_REPOSITORY == null){
            LOGIN_REPOSITORY = new LoginRepository();
        }
        return LOGIN_REPOSITORY;
    }

    @NotNull
    public MutableLiveData<UserModel> doLogin(String telephone, String password, String type) {
        Log.d(TAG, "LoginRepository: 走进这个方法了");

        final MutableLiveData<UserModel> mutableLiveData = new MutableLiveData<>();

        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);

        //子线程获取数据
        //主线程处理数据
        if (apiServices != null) {
            apiServices.login(telephone, password, type)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<UserModel>() {
                        @Override
                        public void onNext(UserModel userModel) {
                            Log.d(TAG, "onNext: 在这里");
                            mutableLiveData.setValue(userModel);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: " + e.toString());
                        }
                    });

        }
        return mutableLiveData;
    }

    @NotNull
    public MutableLiveData<UserModel> doLogin(@NotNull LoginReqBean loginReqBean) {
        return doLogin(loginReqBean.getTelephone(),loginReqBean.getPassword(),loginReqBean.getType());
    }
}
