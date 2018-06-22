package com.example.boy.jiandemo;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by boy on 2018/6/2.
 */

class RecyclerAdapter extends BaseMultiItemQuickAdapter<RecyclerModle, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecyclerAdapter(List data) {
        super(data);
        addItemType(0, R.layout.item0);
        addItemType(1, R.layout.item1);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecyclerModle item) {
        switch (helper.getItemViewType()) {
            case 0:
                helper.setText(R.id.title, item.getName());
                break;
            case 1:
                helper.setText(R.id.text_name, item.getName())
                        .setText(R.id.text_sex, item.getSex())
                        .addOnClickListener(R.id.imager)
                        .addOnClickListener(R.id.text_sex)
                        .addOnClickListener(R.id.text_name);
                break;
        }
    }
}
