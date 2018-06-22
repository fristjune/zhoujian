package com.example.boy.jiandemo.MyRecyclerAdapter;

import android.view.View;


public interface OnRecyclerItemListener<T> {

    public void onItemClick(View v, T data);


}
