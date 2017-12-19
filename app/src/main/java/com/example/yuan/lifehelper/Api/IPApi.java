package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.IPBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/19.
 */

public interface IPApi
{
    /**
     * http://apicloud.mob.com/ip/query?key=appkey&ip=61.187.92.238
     */
    @GET("ip/query")
    Observable<IPBean> getPhone(
            @Query("key") String key,
            @Query("ip") String ip);
}
