package com.example.yuan.lifehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.bean.BankBean;
import com.example.yuan.lifehelper.Api.BankApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.yuan.lifehelper.activity.MainActivity.KEY;

public class BankActivity extends AppCompatActivity
{

    private static final String TAG = "BankActivity";
    private EditText inputBank;
    private Button sendBank;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        setTitle("银行卡类别查询");
        inputBank = (EditText) findViewById(R.id.ed_bank);
        sendBank = (Button) findViewById(R.id.btn_querybank);
        showText = (TextView) findViewById(R.id.show_text);


        sendBank.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String inputText = inputBank.getText().toString();
                if(isOk(inputText))
                {
                    getData();
                }
                else
                {
                    Toast.makeText(BankActivity.this, "号码不正确，请检查", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isOk(String inputText)
    {
        if (!TextUtils.isEmpty(inputText) && !inputText.contains(" ") )
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
        BankApi request = retrofit.create(BankApi.class);

        String idNum = inputBank.getText().toString();

        //RxJava实现请求
        request.getPhone(KEY, idNum)
                //数据通过rxjava提交先在io线程里
                .subscribeOn(Schedulers.io())
                //返回到主线程
                .observeOn(AndroidSchedulers.mainThread())
                //通过subscribe实现订阅关系
                .subscribe(new Observer<BankBean>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(BankBean value)
                    {
                        if (!"success".equals(value.getMsg()))
                        {
                            Toast.makeText(BankActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                            return;
                        }
//                        Log.d(TAG, "area=" + value.getResult().getArea());

                        /**
                         * bank : 农业银行
                         * bin : 622848
                         * binNumber : 6
                         * cardName : 金穗通宝卡(银联卡)
                         * cardNumber : 19
                         * cardType : 借记卡
                         */

                        String builder = "所属银行：" + value.getResult().getBank() + "\n" +
                                "bin码：" + value.getResult().getBin() + "\n" +
                                "bin码长度：" + value.getResult().getBinNumber() + "\n" +
                                "卡名：" + value.getResult().getCardName() + "\n" +
                                "卡号长度：" + value.getResult().getCardNumber() + "\n" +
                                "卡片类型：" + value.getResult().getCardType();
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
