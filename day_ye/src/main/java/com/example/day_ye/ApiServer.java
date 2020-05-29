package com.example.day_ye;

import com.example.day_ye.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url="http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<MyBean> getData();
}
