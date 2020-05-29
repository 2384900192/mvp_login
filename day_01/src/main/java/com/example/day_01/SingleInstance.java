package com.example.day_01;

import android.util.Log;

public class SingleInstance {

    //变量
    private static volatile SingleInstance instance;

    //私有化构造
    private SingleInstance() {
    }

    //提供公共访问方式
    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

    public void fun(){
        Log.e("TAG", "1SingleInstance fun()");
        Log.e("TAG", "2SingleInstance fun()");
        Log.e("TAG", "3SingleInstance fun()");
    }

}
