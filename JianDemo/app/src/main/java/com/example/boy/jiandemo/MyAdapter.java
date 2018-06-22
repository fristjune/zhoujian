package com.example.boy.jiandemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.boy.jiandemo.MyRecyclerAdapter.RecyclerBaseAdapter;
import com.example.boy.jiandemo.MyRecyclerAdapter.RecyclerBaseHolder;


/**
 * Created by boy on 2018/6/1.
 */

class MyAdapter extends RecyclerBaseAdapter {
    @Override
    public int getLayoutId() {
        return R.layout.item;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new MyViewHolder(itemView ,context,this);
    }

    class MyViewHolder extends RecyclerBaseHolder {

        private final TextView viewById;

        public MyViewHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            viewById = (TextView) itemView.findViewById(R.id.context);
        }

        @Override
        public void bindHolder(int position) {
            viewById.setText(mData.toString());
        }
    }
}
