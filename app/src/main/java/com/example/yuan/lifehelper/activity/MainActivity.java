package com.example.yuan.lifehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.yuan.lifehelper.adapter.MyAdapter;
import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.bean.DataBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    private List<DataBean> dataList = new ArrayList<>();
    private RecyclerView recyclerView;

    public static final String KEY = "2327e5fc4a8c8";
    public static final String SECRET = "64c55e0e5c7dc3b80cf0852387bbe380";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        initView();

    }

    private void initView()
    {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        MyAdapter adapter = new MyAdapter(dataList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void getData()
    {
        dataList.add(new DataBean(R.drawable.ic_launcher,"手机号码查询"));
        dataList.add(new DataBean(R.drawable.ic_launcher,"身份证查询"));
        dataList.add(new DataBean(R.drawable.ic_launcher,"火车票查询"));
        dataList.add(new DataBean(R.drawable.ic_launcher,"IP查询"));
        dataList.add(new DataBean(R.drawable.ic_launcher,"银行卡信息查询"));
        dataList.add(new DataBean(R.drawable.ic_launcher,"邮编查询"));

    }
}
