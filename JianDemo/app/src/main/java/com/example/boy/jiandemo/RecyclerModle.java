package com.example.boy.jiandemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.boy.jiandemo.moder.BaseBean;

/**
 * Created by boy on 2018/6/2.
 */

class RecyclerModle extends BaseBean implements MultiItemEntity {
    private String name;
    private String sex;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
