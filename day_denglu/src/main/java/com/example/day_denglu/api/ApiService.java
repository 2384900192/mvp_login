package com.example.day_9_011;


import com.example.day_9_011.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String URL="https://www.wanandroid.com/";
    @POST("user/login")
    @FormUrlEncoded
    Observable<MainBean> getMtent(@Field("username") String username, @Field("password") String password);
}
