package com.example.yuan.lifehelper.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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
        //初始化toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("查询服务");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        MyAdapter adapter = new MyAdapter(dataList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //加载toolbar.xml文件
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * 菜单的点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.about_me:
                Toast.makeText(this, "关于我", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    public void getData()
    {
        dataList.add(new DataBean(R.drawable.ic_phone,"手机号码查询"));
        dataList.add(new DataBean(R.drawable.ic_card2,"身份证查询"));
        dataList.add(new DataBean(R.drawable.ic_train2,"火车票查询"));
        dataList.add(new DataBean(R.drawable.ic_ip,"IP查询"));
        dataList.add(new DataBean(R.drawable.ic_bank,"银行卡信息查询"));
        dataList.add(new DataBean(R.drawable.ic_post,"邮编查询"));
        dataList.add(new DataBean(R.drawable.ic_calendar,"万年历"));
        dataList.add(new DataBean(R.drawable.ic_flight,"航班号查询"));

    }
}
