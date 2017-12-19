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

import com.example.yuan.lifehelper.Api.FlightApi;
import com.example.yuan.lifehelper.Api.TrainApi;
import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.bean.FlightBean;
import com.example.yuan.lifehelper.bean.TrainBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.yuan.lifehelper.activity.MainActivity.KEY;

public class FlightActivity extends AppCompatActivity
{
    private static final String TAG = "FlightActivity";
    private EditText inputFlight;
    private Button sendFlight;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("航班号查询");

        inputFlight = (EditText) findViewById(R.id.et_input_flight);
        sendFlight = (Button) findViewById(R.id.btn_queryflight);
        showText = (TextView) findViewById(R.id.show_text);

        sendFlight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String inputText = inputFlight.getText().toString();
                if(isOk(inputText))
                {
                    getData();
                }
                else
                {
                    Toast.makeText(FlightActivity.this, "输入不正确，请检查", Toast.LENGTH_SHORT).show();
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
        FlightApi request = retrofit.create(FlightApi.class);

        String flight = inputFlight.getText().toString();

        //RxJava实现请求
        request.getPhone(KEY, flight)
                //数据通过rxjava提交先在io线程里
                .subscribeOn(Schedulers.io())
                //返回到主线程
                .observeOn(AndroidSchedulers.mainThread())
                //通过subscribe实现订阅关系
                .subscribe(new Observer<FlightBean>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(FlightBean value)
                    {
                        if (!"success".equals(value.getMsg()))
                        {
                            Toast.makeText(FlightActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        /**
                         * airLines : 中国南方航空公司
                         * flightNo : CZ8319
                         * flightRate : 100%
                         * flightTime : 1h32m
                         * from : 浦东国际机场
                         * fromAirportCode : PVG
                         * fromCityCode : SHA
                         * fromCityName : 上海
                         * fromTerminal : T2
                         * planArriveTime : 09:35
                         * planTime : 07:25
                         * to : 黄花国际机场
                         * toAirportCode : CSX
                         * toCityCode : CSX
                         * toCityName : 长沙
                         * toTerminal : T2
                         * week : 一,二,三,四,五,六,日
                         */

                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < value.getResult().size(); i++)
                        {
                            builder.append("航空公司："+value.getResult().get(i).getAirLines() + "\n");
                            builder.append("航班号："+value.getResult().get(i).getFlightNo() + "\n");
                            builder.append("航班准点率："+value.getResult().get(i).getFlightRate() + "\n");
                            builder.append("航行时间："+value.getResult().get(i).getFlightTime() + "\n");
                            builder.append("出发机场："+value.getResult().get(i).getFrom() + "\n");
                            builder.append("出发机场代码："+value.getResult().get(i).getFromAirportCode() + "\n");
                            builder.append("出发城市代码："+value.getResult().get(i).getFromCityCode() + "\n");
                            builder.append("出发城市名称:"+value.getResult().get(i).getFromCityName() + "\n");
                            builder.append("出发航站楼："+value.getResult().get(i).getFromTerminal() + "\n");
                            builder.append("计划起飞时间："+value.getResult().get(i).getPlanTime() + "\n");
                            builder.append("计划到达时间："+value.getResult().get(i).getPlanArriveTime() + "\n");
                            builder.append("到达机场："+value.getResult().get(i).getTo() + "\n");
                            builder.append("到达机场代码："+value.getResult().get(i).getToAirportCode() + "\n");
                            builder.append("到达城市代码："+value.getResult().get(i).getToCityCode() + "\n");
                            builder.append("到达城市名称："+value.getResult().get(i).getToCityName() + "\n");
                            builder.append("到达城市航站楼："+value.getResult().get(i).getToTerminal() + "\n");
                            builder.append("航班周期："+value.getResult().get(i).getWeek() + "\n");
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
