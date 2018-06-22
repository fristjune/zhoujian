package com.example.boy.jiandemo.MyRecyclerAdapter;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/4/10 0010.
 * 作为所有公共的Adapter的适配接口
 */

public interface IAdapter<H> {
    /**
     * 返回布局的id
     *
     * @return
     */
    int getLayoutId();

    /**
     * 创建ViewHolder
     *
     * @param itemView
     * @return
     */
    H createViewHolder(View itemView, Context context, int viewType);

}
