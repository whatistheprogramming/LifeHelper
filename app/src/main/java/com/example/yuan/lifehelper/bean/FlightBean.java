package com.example.yuan.lifehelper.bean;

import java.util.List;

/**
 * Created by yuan on 2017/12/19.
 */

public class FlightBean
{

    /**
     * msg : success
     * result : [{"airLines":"中国南方航空公司","flightNo":"CZ8319","flightRate":"100%","flightTime":"1h32m","from":"浦东国际机场","fromAirportCode":"PVG","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T2","planArriveTime":"09:35","planTime":"07:25","to":"黄花国际机场","toAirportCode":"CSX","toCityCode":"CSX","toCityName":"长沙","toTerminal":"T2","week":"一,二,三,四,五,六,日"}]
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
         * airLines : 中国南方航空公司
         * flightNo : CZ8319
         * flightRate : 100%
         * flightTime : 1h32m
         * from : 浦东国际机场
         * fromAirportCode : PVG
         * fromCityCode : SHA
         * fromCityName : 上海
         * fromTerminal : T2
         * planArriveTime : 09:35
         * planTime : 07:25
         * to : 黄花国际机场
         * toAirportCode : CSX
         * toCityCode : CSX
         * toCityName : 长沙
         * toTerminal : T2
         * week : 一,二,三,四,五,六,日
         */

        private String airLines;
        private String flightNo;
        private String flightRate;
        private String flightTime;
        private String from;
        private String fromAirportCode;
        private String fromCityCode;
        private String fromCityName;
        private String fromTerminal;
        private String planArriveTime;
        private String planTime;
        private String to;
        private String toAirportCode;
        private String toCityCode;
        private String toCityName;
        private String toTerminal;
        private String week;

        public String getAirLines()
        {
            return airLines;
        }

        public void setAirLines(String airLines)
        {
            this.airLines = airLines;
        }

        public String getFlightNo()
        {
            return flightNo;
        }

        public void setFlightNo(String flightNo)
        {
            this.flightNo = flightNo;
        }

        public String getFlightRate()
        {
            return flightRate;
        }

        public void setFlightRate(String flightRate)
        {
            this.flightRate = flightRate;
        }

        public String getFlightTime()
        {
            return flightTime;
        }

        public void setFlightTime(String flightTime)
        {
            this.flightTime = flightTime;
        }

        public String getFrom()
        {
            return from;
        }

        public void setFrom(String from)
        {
            this.from = from;
        }

        public String getFromAirportCode()
        {
            return fromAirportCode;
        }

        public void setFromAirportCode(String fromAirportCode)
        {
            this.fromAirportCode = fromAirportCode;
        }

        public String getFromCityCode()
        {
            return fromCityCode;
        }

        public void setFromCityCode(String fromCityCode)
        {
            this.fromCityCode = fromCityCode;
        }

        public String getFromCityName()
        {
            return fromCityName;
        }

        public void setFromCityName(String fromCityName)
        {
            this.fromCityName = fromCityName;
        }

        public String getFromTerminal()
        {
            return fromTerminal;
        }

        public void setFromTerminal(String fromTerminal)
        {
            this.fromTerminal = fromTerminal;
        }

        public String getPlanArriveTime()
        {
            return planArriveTime;
        }

        public void setPlanArriveTime(String planArriveTime)
        {
            this.planArriveTime = planArriveTime;
        }

        public String getPlanTime()
        {
            return planTime;
        }

        public void setPlanTime(String planTime)
        {
            this.planTime = planTime;
        }

        public String getTo()
        {
            return to;
        }

        public void setTo(String to)
        {
            this.to = to;
        }

        public String getToAirportCode()
        {
            return toAirportCode;
        }

        public void setToAirportCode(String toAirportCode)
        {
            this.toAirportCode = toAirportCode;
        }

        public String getToCityCode()
        {
            return toCityCode;
        }

        public void setToCityCode(String toCityCode)
        {
            this.toCityCode = toCityCode;
        }

        public String getToCityName()
        {
            return toCityName;
        }

        public void setToCityName(String toCityName)
        {
            this.toCityName = toCityName;
        }

        public String getToTerminal()
        {
            return toTerminal;
        }

        public void setToTerminal(String toTerminal)
        {
            this.toTerminal = toTerminal;
        }

        public String getWeek()
        {
            return week;
        }

        public void setWeek(String week)
        {
            this.week = week;
        }
    }
}
