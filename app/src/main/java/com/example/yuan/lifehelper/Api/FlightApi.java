package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.FlightBean;
import com.example.yuan.lifehelper.bean.TrainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/19.
 */

public interface FlightApi
{
    /**
     * http://apicloud.mob.com/flight/no/query?key=520520test&name=CZ8319
     */
    @GET("flight/no/query")
    Observable<FlightBean> getPhone(
            @Query("key") String key,
            @Query("name") String name);
}
