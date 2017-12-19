package com.example.yuan.lifehelper.bean;

/**
 * Created by yuan on 2017/12/18.
 */

public class IDCardBean
{

    /**
     * msg : success
     * result : {"area":"湖南省","birthday":"1996年06月02日","sex":"男"}
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
         * area : 湖南省
         * birthday : 1996年06月02日
         * sex : 男
         */

        private String area;
        private String birthday;
        private String sex;

        public String getArea()
        {
            return area;
        }

        public void setArea(String area)
        {
            this.area = area;
        }

        public String getBirthday()
        {
            return birthday;
        }

        public void setBirthday(String birthday)
        {
            this.birthday = birthday;
        }

        public String getSex()
        {
            return sex;
        }

        public void setSex(String sex)
        {
            this.sex = sex;
        }
    }
}
