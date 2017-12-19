package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.IDCardBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/18.
 */

public interface IDCardApi
{
    /**
     * http://apicloud.mob.com/idcard/query?key=appkey&cardno=431081199606024198
     */
    @GET("idcard/query")
    Observable<IDCardBean> getPhone(
            @Query("key") String key,
            @Query("cardno") String idNum);
}
