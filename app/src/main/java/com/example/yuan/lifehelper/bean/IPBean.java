package com.example.yuan.lifehelper.bean;

/**
 * Created by yuan on 2017/12/19.
 */

public class IPBean
{

    /**
     * msg : success
     * result : {"city":"岳阳","country":"中国","ip":"61.187.92.238","province":"湖南"}
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
         * city : 岳阳
         * country : 中国
         * ip : 61.187.92.238
         * province : 湖南
         */

        private String city;
        private String country;
        private String ip;
        private String province;

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        public String getCountry()
        {
            return country;
        }

        public void setCountry(String country)
        {
            this.country = country;
        }

        public String getIp()
        {
            return ip;
        }

        public void setIp(String ip)
        {
            this.ip = ip;
        }

        public String getProvince()
        {
            return province;
        }

        public void setProvince(String province)
        {
            this.province = province;
        }
    }
}
