package com.dawn.community.api;

import androidx.databinding.ObservableField;

import com.dawn.community.api.viewobject.OtpModel;
import com.dawn.community.api.viewobject.UserModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author algorithm
 * @Date:  2021/4/27
 * 接口
 */
public interface ApiServices {

    /**
     * 获取新闻数据
     * @param type 类型
     * @param key appkey
     * @return
     */
    /*@GET("toutiao/index")
    Observable<NewBean> getNews(@Query("type") String type, @Query("key") String key);*/

    @POST("login")
    @FormUrlEncoded
    Observable<UserModel> login(
            @Field("telephone")String telephone,
            @Field("password")String password,
            @Field("type")String type);

    /*@POST("getOtp")
    @FormUrlEncoded
    Observable<OtpModel> getOtp(
            @Field("telephone")String telephone
    );*/

    @POST("getOtp")
    @FormUrlEncoded
    Observable<Response<OtpModel>> getOtp(
            @Field("telephone")String telephone
    );

    @POST("register")
    @FormUrlEncoded
    Observable<UserModel> register(
            @Field("telephone")String telephone,
            @Field("otpCode")String otpCode,
            @Field("password")String password,
            @Field("passwordAgain")String passwordAgain
    );




}
