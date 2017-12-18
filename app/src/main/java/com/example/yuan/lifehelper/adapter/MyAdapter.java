package com.example.yuan.lifehelper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.lifehelper.R;

import java.util.List;

/**
 * Created by yuan on 2017/12/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    List<String> dataList;

    public MyAdapter(List<String>  dataList)
    {
        this.dataList = dataList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position)
    {
    }

    @Override
    public int getItemCount()
    {
        if (dataList==null) return 0;
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView text;
        public ViewHolder(final View itemView)
        {
            super(itemView);

            image= (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(itemView.getContext(), "click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
