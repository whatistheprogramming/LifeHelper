package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.BankBean;
import com.example.yuan.lifehelper.bean.CalendarBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/19.
 */

public interface CalendarApi
{
    /**
     * http://apicloud.mob.com/appstore/calendar/day?key=appkey&date=2018-12-25
     */
    @GET("appstore/calendar/day")
    Observable<CalendarBean> getPhone(
            @Query("key") String key,
            @Query("date") String date);
}
