package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.BankBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/19.
 */

public interface BankApi
{
    /**
     * http://apicloud.mob.com/appstore/bank/card/query?key=appkey&card=6228482898203884775
     */
    @GET("appstore/bank/card/query")
    Observable<BankBean> getPhone(
            @Query("key") String key,
            @Query("card") String card);
}
