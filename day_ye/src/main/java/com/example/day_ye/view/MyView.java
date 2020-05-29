package com.example.day_ye.view;

import com.example.day_ye.bean.DatasBean;

import java.util.List;

public interface MyView {
    void showToast(String str);
    void showList(List<DatasBean> lists);
}
