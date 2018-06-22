package com.example.boy.jiandemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.boy.jiandemo.recyclerViewTonch.OnActivityTouchListener;
import com.example.boy.jiandemo.recyclerViewTonch.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boy on 2018/6/2.
 */

public class RecyclerActivity extends Activity implements BaseQuickAdapter.OnItemClickListener ,RecyclerTouchListener.RecyclerTouchListenerHelper{

    private RecyclerView xrecyler;
    private List<RecyclerModle> data;
    private RecyclerAdapter adapter;
    private RecyclerTouchListener onTouchListener;
    private OnActivityTouchListener touchListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setData();
        xrecyler = (RecyclerView) findViewById(R.id.xrecycler);
        xrecyler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(data);
        xrecyler.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.imager:
                        Toast.makeText(RecyclerActivity.this, "这是图片呗点击了" + position, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.text_sex:
                        Toast.makeText(RecyclerActivity.this, "这是性别呗点击了" + position, Toast.LENGTH_LONG).show();

                        break;
                    case R.id.text_name:
                        Toast.makeText(RecyclerActivity.this, "这是名字呗点击了" + position, Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });


        onTouchListener = new RecyclerTouchListener(this, xrecyler);
        onTouchListener
//                .setIndependentViews(R.id.rowButton)
//                .setViewsToFade(R.id.rowButton)
                .setClickable(new RecyclerTouchListener.OnRowClickListener() {
                    @Override
                    public void onRowClicked(int position) {
                        ToastUtil.makeToast(getApplicationContext(), "我 " + (position + 1) + " clicked!");
                    }

                    @Override
                    public void onIndependentViewClicked(int independentViewID, int position) {
                        ToastUtil.makeToast(getApplicationContext(), "Button in row " + (position + 1) + " clicked!");
                    }
                })
                .setLongClickable(true, new RecyclerTouchListener.OnRowLongClickListener() {
                    @Override
                    public void onRowLongClicked(int position) {
                        ToastUtil.makeToast(getApplicationContext(), "Row " + (position + 1) + " long clicked!");
                    }
                })
                .setSwipeOptionViews(R.id.add, R.id.edit, R.id.change)
                .setSwipeable(R.id.rowFG, R.id.rowBG, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, int position) {
                        String message = "";
                        if (viewID == R.id.add) {
                            message += "Add";
                        } else if (viewID == R.id.edit) {
                            message += "Edit";
                        } else if (viewID == R.id.change) {
                            message += "Change";
                        }
                        message += " clicked for row " + (position + 1);
                        ToastUtil.makeToast(getApplicationContext(), message);
                    }
                });

    }

    private void setData() {
        data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            RecyclerModle recyclerModle = new RecyclerModle();
            recyclerModle.setName("周健" + i);
            recyclerModle.setSex("男" + i);
            if (i % 10 == 0) {
                recyclerModle.setType(0);
            } else {
                recyclerModle.setType(1);
            }
            data.add(recyclerModle);

        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(RecyclerActivity.this, "条目呗点击了" + position, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        xrecyler.addOnItemTouchListener(onTouchListener);
    }
    @Override
    protected void onPause() {
        super.onPause();
        xrecyler.removeOnItemTouchListener(onTouchListener);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (touchListener != null) touchListener.getTouchCoordinates(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setOnActivityTouchListener(OnActivityTouchListener listener) {
        this.touchListener = listener;
    }


}
