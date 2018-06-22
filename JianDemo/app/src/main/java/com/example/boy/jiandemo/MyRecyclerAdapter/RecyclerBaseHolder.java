package com.example.boy.jiandemo.MyRecyclerAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * 仅供RecyclerView使用的Holder
 */

public abstract class RecyclerBaseHolder<D> extends RecyclerView.ViewHolder {
    protected Context mContext;
    protected RecyclerView.Adapter mAdapter;
    protected D mData;

    private RecyclerBaseAdapter.ClickListenner<D> clickListenner;

    public RecyclerBaseHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
        super(itemView);
        this.mContext = context;
        this.mAdapter = adapter;
    }

    public void setData(D data) {
        this.mData = data;
        this.itemView.setTag(data);
    }

    public abstract void bindHolder(int position);


    public D getData() {

        return this.mData;
    }

    public RecyclerBaseAdapter.ClickListenner<D> getClickListenner() {
        return clickListenner;
    }

    public void setClickListenner(RecyclerBaseAdapter.ClickListenner<D> clickListenner) {
        this.clickListenner = clickListenner;
    }
}
