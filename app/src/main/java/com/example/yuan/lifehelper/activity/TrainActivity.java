package com.example.yuan.lifehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.bean.TrainBean;
import com.example.yuan.lifehelper.Api.TrainApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.yuan.lifehelper.activity.MainActivity.KEY;

public class TrainActivity extends AppCompatActivity
{
    private static final String TAG = "TrainActivity";
    private EditText inputTrain;
    private Button sendTrain;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("火车票查询");

        inputTrain = (EditText) findViewById(R.id.et_input_train);
        sendTrain = (Button) findViewById(R.id.btn_querytrain);
        showText = (TextView) findViewById(R.id.show_text);

        sendTrain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String inputText = inputTrain.getText().toString();
                if(isOk(inputText))
                {
                    getData();
                }
                else
                {
                    Toast.makeText(TrainActivity.this, "号码不正确，请检查", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getData()
    {
        String baseUrl = "http://apicloud.mob.com/";
        Retrofit retrofit = new Retrofit.Builder()
                //设置请求网络的url地址
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())  //添加GSON
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //添加RxJava
                .build();

        //创建网络请求接口实例
        TrainApi request = retrofit.create(TrainApi.class);

        String train = inputTrain.getText().toString();

        //RxJava实现请求
        request.getPhone(KEY, train)
                //数据通过rxjava提交先在io线程里
                .subscribeOn(Schedulers.io())
                //返回到主线程
                .observeOn(AndroidSchedulers.mainThread())
                //通过subscribe实现订阅关系
                .subscribe(new Observer<TrainBean>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(TrainBean value)
                    {
                        if (!"success".equals(value.getMsg()))
                        {
                            Toast.makeText(TrainActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Log.d(TAG, "city="+value.getResult().get(0).getEndStationName());

                        /**
                         * arriveTime : ----
                         * endStationName : 北京南
                         * startStationName : 上海虹桥
                         * startTime : 09:00
                         * stationName : 上海虹桥
                         * stationNo : 01
                         * stationTrainCode : G2
                         * stopoverTime : ----
                         * trainClassName : 高速
                         */
                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < value.getResult().size(); i++)
                        {
                            builder.append("到达时间："+value.getResult().get(i).getArriveTime() + "\n");
                            builder.append("出发时间："+value.getResult().get(i).getStartTime() + "\n");
                            builder.append("起始站名："+value.getResult().get(i).getStartStationName() + "\n");
                            builder.append("终点站名："+value.getResult().get(i).getEndStationName() + "\n");
                            builder.append("站点名："+value.getResult().get(i).getStationName() + "\n");
                            builder.append("站点序号："+value.getResult().get(i).getStationNo() + "\n");
                            builder.append("类型："+value.getResult().get(i).getTrainClassName() + "\n");
                            builder.append("车次号："+value.getResult().get(i).getStationTrainCode() + "\n");
                            builder.append("停留时间:"+value.getResult().get(i).getStopoverTime() + "\n");
                            builder.append("\n");
                        }


                        showText.setText(builder);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });

    }

    private boolean isOk(String inputText)
    {
        if (!TextUtils.isEmpty(inputText)&&!inputText.contains(" "))
        {
            return true;
        }
        return false;
    }
}
