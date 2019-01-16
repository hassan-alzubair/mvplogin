package com.hassan.mvplogin.Login;


import com.hassan.mvplogin.Base.ApiResponse;
import com.hassan.mvplogin.Login.pojo.User;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApi {

    @FormUrlEncoded
    @POST("/login.php")
    Single<ApiResponse<User>> login(@Field("username") String username, @Field("password") String password);

}
