package com.example.yuan.lifehelper.http.API;

import com.example.yuan.lifehelper.bean.PostcodeBean;
import com.example.yuan.lifehelper.bean.TrainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/12/19.
 */

public interface TrainApi
{
    /**
     * http://apicloud.mob.com/train/tickets/queryByTrainNo?key=2327e5fc4a8c8&trainno=G2
     */
    @GET("train/tickets/queryByTrainNo")
    Observable<TrainBean> getPhone(
            @Query("key") String key,
            @Query("trainno") String trainno);
}
