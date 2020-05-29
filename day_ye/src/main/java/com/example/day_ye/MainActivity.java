package com.example.day_ye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.day_ye.adapter.MyAdapter;
import com.example.day_ye.bean.DatasBean;
import com.example.day_ye.prenter.MyPrenter;
import com.example.day_ye.view.MyView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView {

    private Toolbar mToolbar;
    private RecyclerView mRecycler;
    private List<DatasBean> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }
    private void initData() {
        MyPrenter myPrenter = new MyPrenter(this);
        myPrenter.getData();
    }


    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("");
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRecycler.setAdapter(myAdapter);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<DatasBean> lists) {
        list.addAll(lists);
        myAdapter.notifyDataSetChanged();
    }
}
