package com.example.day_ye.model;

import android.util.Log;

import com.example.day_ye.ApiServer;
import com.example.day_ye.bean.DatasBean;
import com.example.day_ye.bean.MyBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

    public void getData(final CallBack callBack){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        apiServer.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        List<DatasBean> datas = myBean.getDatas();
                        callBack.showList(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface CallBack {
        void showToast(String str);
        void showList(List<DatasBean> lists);
    }
}
