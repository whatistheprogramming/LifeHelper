package com.example.yuan.lifehelper.bean;

import java.util.List;

/**
 * Created by yuan on 2017/12/19.
 */

public class TrainBean
{

    /**
     * msg : success
     * result : [{"arriveTime":"----","endStationName":"北京南","startStationName":"上海虹桥","startTime":"09:00","stationName":"上海虹桥","stationNo":"01","stationTrainCode":"G2","stopoverTime":"----","trainClassName":"高速"},{"arriveTime":"10:07","startTime":"10:09","stationName":"南京南","stationNo":"02","stopoverTime":"2分钟"},{"arriveTime":"13:48","startTime":"13:48","stationName":"北京南","stationNo":"03","stopoverTime":"----"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getRetCode()
    {
        return retCode;
    }

    public void setRetCode(String retCode)
    {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult()
    {
        return result;
    }

    public void setResult(List<ResultBean> result)
    {
        this.result = result;
    }

    public static class ResultBean
    {
        /**
         * arriveTime : ----
         * endStationName : 北京南
         * startStationName : 上海虹桥
         * startTime : 09:00
         * stationName : 上海虹桥
         * stationNo : 01
         * stationTrainCode : G2
         * stopoverTime : ----
         * trainClassName : 高速
         */

        private String arriveTime;
        private String endStationName;
        private String startStationName;
        private String startTime;
        private String stationName;
        private String stationNo;
        private String stationTrainCode;
        private String stopoverTime;
        private String trainClassName;

        public String getArriveTime()
        {
            return arriveTime;
        }

        public void setArriveTime(String arriveTime)
        {
            this.arriveTime = arriveTime;
        }

        public String getEndStationName()
        {
            return endStationName;
        }

        public void setEndStationName(String endStationName)
        {
            this.endStationName = endStationName;
        }

        public String getStartStationName()
        {
            return startStationName;
        }

        public void setStartStationName(String startStationName)
        {
            this.startStationName = startStationName;
        }

        public String getStartTime()
        {
            return startTime;
        }

        public void setStartTime(String startTime)
        {
            this.startTime = startTime;
        }

        public String getStationName()
        {
            return stationName;
        }

        public void setStationName(String stationName)
        {
            this.stationName = stationName;
        }

        public String getStationNo()
        {
            return stationNo;
        }

        public void setStationNo(String stationNo)
        {
            this.stationNo = stationNo;
        }

        public String getStationTrainCode()
        {
            return stationTrainCode;
        }

        public void setStationTrainCode(String stationTrainCode)
        {
            this.stationTrainCode = stationTrainCode;
        }

        public String getStopoverTime()
        {
            return stopoverTime;
        }

        public void setStopoverTime(String stopoverTime)
        {
            this.stopoverTime = stopoverTime;
        }

        public String getTrainClassName()
        {
            return trainClassName;
        }

        public void setTrainClassName(String trainClassName)
        {
            this.trainClassName = trainClassName;
        }
    }
}
