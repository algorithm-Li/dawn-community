package com.dawn.community.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.api.ApiServices;
import com.dawn.community.api.BaseSubscriber;
import com.dawn.community.api.RetrofitServiceBuilder;
import com.dawn.community.api.viewobject.OtpModel;
import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.api.viewobject.request.bean.RegisterReqBean;
import com.dawn.community.http.HeaderInterceptor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * @author Algorithm
 * @Date: 2021/5/1/0001
 * @Time: 13:15
 */
public class SignUpRepository {

    private static final String TAG = "SignUpRepository";

    private static SignUpRepository SIGN_UP_REPOSITORY = new SignUpRepository();

    public static SignUpRepository getInstance(){
        if(SIGN_UP_REPOSITORY == null){
            SIGN_UP_REPOSITORY = new SignUpRepository();
        }
        return SIGN_UP_REPOSITORY;
    }

    //发起验证码请求
    /*public MutableLiveData<OtpModel> getOtp(String telephone){

        Log.d(TAG,"进入这个GetOtp方法");

        final MutableLiveData<OtpModel> mutableLiveData = new MutableLiveData<>();

        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);

        if(apiServices!=null){
            apiServices.getOtp(telephone)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<OtpModel>() {
                        @Override
                        public void onNext(OtpModel otpModel) {
                            Log.d(TAG, "onNext: 在这里");
                            mutableLiveData.postValue(otpModel);
                            System.out.println(otpModel);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: " + e.toString());
                        }
                    });

        }
        return mutableLiveData;
    }*/

    //发起验证码请求
    public MutableLiveData<OtpModel> sss(String telephone){

        Log.d(TAG,"进入这个GetOtp方法");

        final MutableLiveData<OtpModel> mutableLiveData = new MutableLiveData<>();

        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);

        if(apiServices!=null){
            apiServices.getOtp(telephone)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<Response<OtpModel>>() {
                        @Override
                        public void onNext(Response<OtpModel> userModelResponse) {
                            if(userModelResponse.body()!=null){
                                //如果获取验证码成功，则将Cookie保存起来
                                if(userModelResponse.body().getCode() == 200){
                                    HeaderInterceptor.cookie = userModelResponse.headers().get("set-cookie");
                                }
                                mutableLiveData.postValue(userModelResponse.body());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });

        }
        return mutableLiveData;
    }

    //发起注册请求
    public MutableLiveData<UserModel> register(RegisterReqBean registerReqBean){

        Log.d(TAG,"进入这个register方法");

        final MutableLiveData<UserModel> mutableLiveData = new MutableLiveData<>();

        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);

        Log.d(TAG,registerReqBean.toString());

        if(apiServices!=null){
            apiServices.register(
                    registerReqBean.getTelephone(),
                    registerReqBean.getOtpCode(),
                    registerReqBean.getPassword(),
                    registerReqBean.getPasswordAgain())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<UserModel>() {
                        @Override
                        public void onNext(UserModel userModel) {
                            Log.d(TAG, "onNext: 在这里");
                            mutableLiveData.postValue(userModel);
                            Log.d(TAG,userModel.toString());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: " + e.toString());
                        }
                    });

        }
        return mutableLiveData;
    }
}
