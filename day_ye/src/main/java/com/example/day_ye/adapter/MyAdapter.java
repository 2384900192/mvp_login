package com.example.day_ye.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_ye.Dbeson;
import com.example.day_ye.R;
import com.example.day_ye.bean.DatasBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<DatasBean> list;

    public MyAdapter(Context context, List<DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }
    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       final ViewHolder viewHolder = (ViewHolder) holder;
       final DatasBean datasBean = list.get(position);
        viewHolder.text_one.setText(datasBean.getDescription());
        RequestOptions crop = new RequestOptions().circleCrop();
        Glide.with(context).load(datasBean.getThumbnail()).apply(crop).into(viewHolder.image_one);
        viewHolder.btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将数据保存到数据库
                if (viewHolder.btn_one.getText().equals("关注")){
                    viewHolder.btn_one.setText("取消");
                    Dbeson.insert(datasBean);
                    Log.i("onClickGuan", "onClick: 关注了");
                    Toast.makeText(context, "关注", Toast.LENGTH_SHORT).show();
                }else {
                    //将保存的数据从数据库删除
                    viewHolder.btn_one.setText("关注");
                    Dbeson.deletr(datasBean);
                    notifyDataSetChanged();
                    Log.i("onClickQu", "onClick: 取消了");
                    Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_one;
        TextView text_one;
        Button btn_one;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_one = itemView.findViewById(R.id.iv_img);
            text_one = itemView.findViewById(R.id.tv_title);
            btn_one = itemView.findViewById(R.id.btn_login);
        }
    }
}
