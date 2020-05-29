package com.example.day_ye.prenter;

import com.example.day_ye.bean.DatasBean;
import com.example.day_ye.model.MyModel;
import com.example.day_ye.view.MyView;

import java.util.List;

public class MyPrenter  {
    private MyView myView;
    private MyModel myModel;

    public MyPrenter(MyView myView) {
        this.myView = myView;
        myModel=new MyModel();
    }

    public void getData(){
        myModel.getData(new MyModel.CallBack() {
            @Override
            public void showToast(String str) {
                myView.showToast(str);
            }

            @Override
            public void showList(List<DatasBean> lists) {
                myView.showList(lists);
            }
        });
    }
}
