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
import com.example.yuan.lifehelper.bean.IDCardBean;
import com.example.yuan.lifehelper.Api.IDCardApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.yuan.lifehelper.activity.MainActivity.KEY;

public class IDCardActivity extends AppCompatActivity
{
    private static final String TAG = "IDCardActivity";
    private EditText inputIDCard;
    private Button sendNum;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("身份证查询");

        inputIDCard = (EditText) findViewById(R.id.ed_idcard);
        sendNum = (Button) findViewById(R.id.btn_queryidcard);
        showText = (TextView) findViewById(R.id.show_text);


        sendNum.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String inputText = inputIDCard.getText().toString();
                if(isOk(inputText))
                {
                    getData();
                }
                else
                {
                    Toast.makeText(IDCardActivity.this, "身份证号码不正确，请检查", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isOk(String inputText)
    {
        if (!TextUtils.isEmpty(inputText) && !inputText.contains(" ") && (inputText.length() == 18 || inputText.length() == 15))
        {
            return true;
        }
        return false;
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
        IDCardApi request = retrofit.create(IDCardApi.class);

        String idNum = inputIDCard.getText().toString();

        //RxJava实现请求
        request.getPhone(KEY, idNum)
                //数据通过rxjava提交先在io线程里
                .subscribeOn(Schedulers.io())
                //返回到主线程
                .observeOn(AndroidSchedulers.mainThread())
                //通过subscribe实现订阅关系
                .subscribe(new Observer<IDCardBean>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(IDCardBean value)
                    {
                        if (!"success".equals(value.getMsg()))
                        {
                            Toast.makeText(IDCardActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Log.d(TAG, "area=" + value.getResult().getArea());

                        String builder = value.getResult().getArea() + "\n" +
                                value.getResult().getBirthday() + "\n" +
                                value.getResult().getSex();
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
                })  ;


    }


}
