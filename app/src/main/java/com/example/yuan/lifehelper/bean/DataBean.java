package com.example.yuan.lifehelper.bean;

/**
 * Created by yuan on 2017/12/18.
 */

public class DataBean
{
    private int image;
    private String name;

    public DataBean(int image, String name)
    {
        this.image = image;
        this.name = name;
    }

    public int getImage()
    {
        return image;
    }

    public void setImage(int image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
