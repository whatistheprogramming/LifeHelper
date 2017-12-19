package com.example.yuan.lifehelper.bean;

import java.util.List;

/**
 * Created by yuan on 2017/12/19.
 */

public class PostcodeBean
{

    /**
     * msg : success
     * result : {"address":["市政府","五里乡","云梦路","洞庭乡","知青场","北港乡","学院路","南湖大道","金鹗东路","青年东路","巴陵东路","岳阳大道","金鹗西路","求索西路","蔡家奇家村","五里乡岳城村","五里乡得胜村","洞庭乡捕捞村","五里乡南津村","北港乡蔡家村","北港乡北港村","北港乡枫树村","北港乡木鱼村","五里乡城郊村","北港乡奇家村","北港乡望岳村","学院路金桥花园","五里乡八字门村","五里乡铁炉冲村","洞庭乡东风湖村","洞庭乡吉家湖村","巴陵东路八字门","经济技术开发区","云梦路东风广场","青年东路富兴康城","岳阳大道岳阳大道","求索西路湖畔新村","岳阳大道南湖广场","经济技术开发区大桥村","经济技术开发区亮山村","经济技术开发区茶场村"],"city":"岳阳市","district":"岳阳楼区","postNumber":"414000","province":"湖南省","size":"41"}
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
         * address : ["市政府","五里乡","云梦路","洞庭乡","知青场","北港乡","学院路","南湖大道","金鹗东路","青年东路","巴陵东路","岳阳大道","金鹗西路","求索西路","蔡家奇家村","五里乡岳城村","五里乡得胜村","洞庭乡捕捞村","五里乡南津村","北港乡蔡家村","北港乡北港村","北港乡枫树村","北港乡木鱼村","五里乡城郊村","北港乡奇家村","北港乡望岳村","学院路金桥花园","五里乡八字门村","五里乡铁炉冲村","洞庭乡东风湖村","洞庭乡吉家湖村","巴陵东路八字门","经济技术开发区","云梦路东风广场","青年东路富兴康城","岳阳大道岳阳大道","求索西路湖畔新村","岳阳大道南湖广场","经济技术开发区大桥村","经济技术开发区亮山村","经济技术开发区茶场村"]
         * city : 岳阳市
         * district : 岳阳楼区
         * postNumber : 414000
         * province : 湖南省
         * size : 41
         */

        private String city;
        private String district;
        private String postNumber;
        private String province;
        private String size;
        private List<String> address;

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        public String getDistrict()
        {
            return district;
        }

        public void setDistrict(String district)
        {
            this.district = district;
        }

        public String getPostNumber()
        {
            return postNumber;
        }

        public void setPostNumber(String postNumber)
        {
            this.postNumber = postNumber;
        }

        public String getProvince()
        {
            return province;
        }

        public void setProvince(String province)
        {
            this.province = province;
        }

        public String getSize()
        {
            return size;
        }

        public void setSize(String size)
        {
            this.size = size;
        }

        public List<String> getAddress()
        {
            return address;
        }

        public void setAddress(List<String> address)
        {
            this.address = address;
        }
    }
}
