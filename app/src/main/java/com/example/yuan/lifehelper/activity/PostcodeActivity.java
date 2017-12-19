package com.example.yuan.lifehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.bean.PhoneBean;
import com.example.yuan.lifehelper.bean.PostcodeBean;
import com.example.yuan.lifehelper.http.API.PhoneApi;
import com.example.yuan.lifehelper.http.API.PostcodeApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.yuan.lifehelper.activity.MainActivity.KEY;

public class PostcodeActivity extends AppCompatActivity
{
    private static final String TAG = "PostcodeActivity";
    private EditText inputCode;
    private Button sendCode;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcode);

        setTitle("邮编查询");
        inputCode = (EditText) findViewById(R.id.et_input_code);
        sendCode = (Button) findViewById(R.id.btn_querycode);
        showText = (TextView) findViewById(R.id.show_text);

        sendCode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String inputText = inputCode.getText().toString();
                if(isOk(inputText))
                {
                    getData();
                }
                else
                {
                    Toast.makeText(PostcodeActivity.this, "邮编不正确，请检查", Toast.LENGTH_SHORT).show();
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
        PostcodeApi request = retrofit.create(PostcodeApi.class);

        String code = inputCode.getText().toString();

        //RxJava实现请求
        request.getPhone(KEY, code)
                //数据通过rxjava提交先在io线程里
                .subscribeOn(Schedulers.io())
                //返回到主线程
                .observeOn(AndroidSchedulers.mainThread())
                //通过subscribe实现订阅关系
                .subscribe(new Observer<PostcodeBean>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(PostcodeBean value)
                    {
                        if (!"success".equals(value.getMsg()))
                        {
                            Toast.makeText(PostcodeActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Log.d(TAG, "city="+value.getResult().getCity());

                        StringBuilder builder = new StringBuilder();
                        builder.append(value.getResult().getProvince() + "\n" +
                                value.getResult().getCity() + "\n" +
                                value.getResult().getDistrict() + "\n\n");

                        for (int i = 0; i < value.getResult().getAddress().size(); i++)
                        {
                            builder.append(value.getResult().getAddress().get(i) + "\n");
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
        if (!TextUtils.isEmpty(inputText)&&!inputText.contains(" ")&&inputText.length()==6)
        {
            return true;
        }
        return false;
    }
}
