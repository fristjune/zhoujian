package com.example.boy.jiandemo.moder;

import android.databinding.ObservableField;

/**
 * Created by boy on 2018/6/8.
 */

public class DataBindingModer {
    public ObservableField<String> name = new ObservableField<>();

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public ObservableField<String> age = new ObservableField<>();

    public DataBindingModer(String name, String age) {
        this.name.set(name);
        this.age.set(age);
    }
}
