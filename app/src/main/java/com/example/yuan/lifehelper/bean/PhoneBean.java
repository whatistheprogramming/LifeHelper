package com.example.yuan.lifehelper.bean;

/**
 * Created by yuan on 2017/12/18.
 */


public class PhoneBean
{


    /**
     * msg : success
     * result : {"city":"岳阳市","cityCode":"0730","mobileNumber":"1569740","operator":"湖南联通GSM卡","province":"湖南","zipCode":"414000"}
     * retCode : 200
     */

    private String msg;
    private ResultBean result;
    private String retCode;

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public ResultBean getResult()
    {
        return result;
    }

    public void setResult(ResultBean result)
    {
        this.result = result;
    }

    public String getRetCode()
    {
        return retCode;
    }

    public void setRetCode(String retCode)
    {
        this.retCode = retCode;
    }

    public static class ResultBean
    {
        /**
         * city : 岳阳市
         * cityCode : 0730
         * mobileNumber : 1569740
         * operator : 湖南联通GSM卡
         * province : 湖南
         * zipCode : 414000
         */

        private String city;
        private String cityCode;
        private String mobileNumber;
        private String operator;
        private String province;
        private String zipCode;

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        public String getCityCode()
        {
            return cityCode;
        }

        public void setCityCode(String cityCode)
        {
            this.cityCode = cityCode;
        }

        public String getMobileNumber()
        {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber)
        {
            this.mobileNumber = mobileNumber;
        }

        public String getOperator()
        {
            return operator;
        }

        public void setOperator(String operator)
        {
            this.operator = operator;
        }

        public String getProvince()
        {
            return province;
        }

        public void setProvince(String province)
        {
            this.province = province;
        }

        public String getZipCode()
        {
            return zipCode;
        }

        public void setZipCode(String zipCode)
        {
            this.zipCode = zipCode;
        }
    }
}
