package com.example.yuan.lifehelper.bean;

/**
 * Created by yuan on 2017/12/19.
 */

public class BankBean
{

    /**
     * msg : success
     * result : {"bank":"农业银行","bin":"622848","binNumber":6,"cardName":"金穗通宝卡(银联卡)","cardNumber":19,"cardType":"借记卡"}
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
         * bank : 农业银行
         * bin : 622848
         * binNumber : 6
         * cardName : 金穗通宝卡(银联卡)
         * cardNumber : 19
         * cardType : 借记卡
         */

        private String bank;
        private String bin;
        private int binNumber;
        private String cardName;
        private int cardNumber;
        private String cardType;

        public String getBank()
        {
            return bank;
        }

        public void setBank(String bank)
        {
            this.bank = bank;
        }

        public String getBin()
        {
            return bin;
        }

        public void setBin(String bin)
        {
            this.bin = bin;
        }

        public int getBinNumber()
        {
            return binNumber;
        }

        public void setBinNumber(int binNumber)
        {
            this.binNumber = binNumber;
        }

        public String getCardName()
        {
            return cardName;
        }

        public void setCardName(String cardName)
        {
            this.cardName = cardName;
        }

        public int getCardNumber()
        {
            return cardNumber;
        }

        public void setCardNumber(int cardNumber)
        {
            this.cardNumber = cardNumber;
        }

        public String getCardType()
        {
            return cardType;
        }

        public void setCardType(String cardType)
        {
            this.cardType = cardType;
        }
    }
}
