package com.example.yuan.lifehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.lifehelper.Api.BankApi;
import com.example.yuan.lifehelper.Api.CalendarApi;
import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.bean.BankBean;
import com.example.yuan.lifehelper.bean.CalendarBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.yuan.lifehelper.activity.MainActivity.KEY;

public class CalendarActivity extends AppCompatActivity
{
    private DatePicker datePicker;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("万年历");

        datePicker = (DatePicker) findViewById(R.id.date_picker);
        showText = (TextView) findViewById(R.id.show_text);

        //隐藏掉头部
        hideDatePickerHeader(datePicker);

        getData();

        int y = datePicker.getYear();
        int m = datePicker.getMonth();
        int d = datePicker.getDayOfMonth();

        //日期初始化并设置监听事件
        datePicker.init(y, m, d, new DatePicker.OnDateChangedListener()
        {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                getData();
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
        CalendarApi request = retrofit.create(CalendarApi.class);

        String date = datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth();

        //RxJava实现请求
        request.getPhone(KEY, date)
                //数据通过rxjava提交先在io线程里
                .subscribeOn(Schedulers.io())
                //返回到主线程
                .observeOn(AndroidSchedulers.mainThread())
                //通过subscribe实现订阅关系
                .subscribe(new Observer<CalendarBean>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(CalendarBean value)
                    {
                        if (!"success".equals(value.getMsg()))
                        {
                            Toast.makeText(CalendarActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        /**
                         * avoid : 种植 掘沟 开井
                         * date : 2018-12-25
                         * holiday : 圣诞节
                         * lunar : 十一月十九
                         * lunarYear : 戊戌
                         * suit : 涂泥 婚礼 出行 修道 涂泥
                         * weekday : 星期二
                         * zodiac : 狗
                         */

                        String builder =
                                "日期：" + value.getResult().getDate() + "\n" +
                                        value.getResult().getWeekday() + "\n" +
                                        "农历：" + value.getResult().getLunar() + "\n" +
                                        "农历年：" + value.getResult().getLunarYear() + "\n" +
                                        "宜：" + value.getResult().getSuit() + "\n" +
                                        "不宜：" + value.getResult().getAvoid() + "\n" +
                                        "生肖:" + value.getResult().getZodiac() + "\n";

                        if (value.getResult().getHoliday() != null)
                        {
                            builder+= "节假日："+value.getResult().getHoliday() + "\n";
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
                })  ;


    }


    private void hideDatePickerHeader(DatePicker datePicker) {
        ViewGroup rootView = (ViewGroup) datePicker.getChildAt(0);
        if (rootView == null) {
            return;
        }
        View headerView = rootView .getChildAt(0);
        if (headerView == null) {
            return;
        }
        //5.0+
        int headerId = this.getResources().getIdentifier("day_picker_selector_layout", "id", "android");
        if (headerId == headerView.getId()) {
            headerView.setVisibility(View.GONE);

            ViewGroup.LayoutParams layoutParamsRoot = rootView.getLayoutParams();
            layoutParamsRoot.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            rootView.setLayoutParams(layoutParamsRoot);

            ViewGroup animator = (ViewGroup) rootView.getChildAt(1);
            ViewGroup.LayoutParams layoutParamsAnimator = animator.getLayoutParams();
            layoutParamsAnimator.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            animator.setLayoutParams(layoutParamsAnimator);

            View child = animator.getChildAt(0);
            ViewGroup.LayoutParams layoutParamsChild = child.getLayoutParams();
            layoutParamsChild.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            child.setLayoutParams(layoutParamsChild );
            return;
        }
        //6.0+
        headerId = this.getResources().getIdentifier("date_picker_header", "id", "android");
        if (headerId == headerView.getId()) {
            headerView.setVisibility(View.GONE);
        }
    }

}
