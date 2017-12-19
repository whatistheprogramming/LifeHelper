package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.PhoneBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/18.
 */

public interface PhoneApi
{
    /**
     * /**
     * http://apicloud.mob.com/v1/mobile/address/query?key=123456&phone=15697406026
     */
    @GET("v1/mobile/address/query")
    Observable<PhoneBean> getPhone(
            @Query("key") String key,
            @Query("phone") String phone);
}
