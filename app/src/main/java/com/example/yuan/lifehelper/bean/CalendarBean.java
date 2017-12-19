package com.example.yuan.lifehelper.bean;

/**
 * Created by yuan on 2017/12/19.
 */

public class CalendarBean
{

    /**
     * msg : success
     * result : {"avoid":"种植 掘沟 开井 ","date":"2018-12-25","holiday":"圣诞节","lunar":"十一月十九","lunarYear":"戊戌","suit":"涂泥 婚礼 出行 修道 涂泥 ","weekday":"星期二","zodiac":"狗"}
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
         * avoid : 种植 掘沟 开井
         * date : 2018-12-25
         * holiday : 圣诞节
         * lunar : 十一月十九
         * lunarYear : 戊戌
         * suit : 涂泥 婚礼 出行 修道 涂泥
         * weekday : 星期二
         * zodiac : 狗
         */

        private String avoid;
        private String date;
        private String holiday;
        private String lunar;
        private String lunarYear;
        private String suit;
        private String weekday;
        private String zodiac;

        public String getAvoid()
        {
            return avoid;
        }

        public void setAvoid(String avoid)
        {
            this.avoid = avoid;
        }

        public String getDate()
        {
            return date;
        }

        public void setDate(String date)
        {
            this.date = date;
        }

        public String getHoliday()
        {
            return holiday;
        }

        public void setHoliday(String holiday)
        {
            this.holiday = holiday;
        }

        public String getLunar()
        {
            return lunar;
        }

        public void setLunar(String lunar)
        {
            this.lunar = lunar;
        }

        public String getLunarYear()
        {
            return lunarYear;
        }

        public void setLunarYear(String lunarYear)
        {
            this.lunarYear = lunarYear;
        }

        public String getSuit()
        {
            return suit;
        }

        public void setSuit(String suit)
        {
            this.suit = suit;
        }

        public String getWeekday()
        {
            return weekday;
        }

        public void setWeekday(String weekday)
        {
            this.weekday = weekday;
        }

        public String getZodiac()
        {
            return zodiac;
        }

        public void setZodiac(String zodiac)
        {
            this.zodiac = zodiac;
        }
    }
}
