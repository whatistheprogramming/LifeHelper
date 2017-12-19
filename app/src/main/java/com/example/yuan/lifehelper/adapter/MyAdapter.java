package com.example.yuan.lifehelper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.lifehelper.R;
import com.example.yuan.lifehelper.activity.IDCardActivity;
import com.example.yuan.lifehelper.activity.PhoneActivity;
import com.example.yuan.lifehelper.bean.DataBean;

import java.util.List;

/**
 * Created by yuan on 2017/12/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    private List<DataBean> dataList;
    private Context mContext;

    public MyAdapter(List<DataBean>  dataList)
    {
        this.dataList = dataList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position)
    {
        DataBean dataBean = dataList.get(position);
        holder.image.setImageResource(dataBean.getImage());
        holder.text.setText(dataBean.getName());

       holder.view.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               Intent intent;
               switch (position)
               {
                   case 0:
                       intent = new Intent(mContext, PhoneActivity.class);
                       mContext.startActivity(intent);
                       break;
                   case 1:
                       intent = new Intent(mContext, IDCardActivity.class);
                       mContext.startActivity(intent);
                       break;
                   default:
                       break;
               }

           }
       });
    }

    @Override
    public int getItemCount()
    {
        if (dataList==null) return 0;
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View view;
        ImageView image;
        TextView text;
        public ViewHolder(final View itemView)
        {
            super(itemView);

            image= (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
            view = itemView;

        }
    }
}
