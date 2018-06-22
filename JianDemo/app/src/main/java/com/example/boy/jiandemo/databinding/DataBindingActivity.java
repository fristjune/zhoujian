package com.example.boy.jiandemo.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.boy.jiandemo.R;
import com.example.boy.jiandemo.moder.DataBindingModer;

/**
 * Created by boy on 2018/6/8.
 */

public class DataBindingActivity extends Activity {

    private ActivityDataBindingBinding binding;
    private DataBindingModer mode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        mode = new DataBindingModer("张三", "25");
        binding.setDataBindingModer(mode);
    }

    public class myClick {
        public void click() {

            mode.setAge("李四");
            mode.setName("55");
        }
    }
}
