package com.example.yuan.lifehelper.Api;

import com.example.yuan.lifehelper.bean.PostcodeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/19.
 */

public interface PostcodeApi
{
    /**
     * http://apicloud.mob.com/v1/postcode/query?key=2327e5fc4a8c8&code=414000
     */
    @GET("v1/postcode/query")
    Observable<PostcodeBean> getPhone(
            @Query("key") String key,
            @Query("code") String code);
}
