package com.example.boy.jiandemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.boy.jiandemo.MyRecyclerAdapter.OnRecyclerItemListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnRecyclerItemListener, View.OnClickListener {

    private XRecyclerView recycler;
    private MyAdapter adapter;
    private List<String> list;
    private BottomSheetDialog bottomSheetDialog;
    private TextView confirm;
    private TextView cancle;
    private TextView recyclerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        adapter = new MyAdapter();
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.dialog);
        recycler = (XRecyclerView) bottomSheetDialog.findViewById(R.id.xrecycler);
        confirm = (TextView) bottomSheetDialog.findViewById(R.id.confirm);
        cancle = (TextView) bottomSheetDialog.findViewById(R.id.cancle);
        recyclerButton = (TextView) findViewById(R.id.recycler);
        confirm.setOnClickListener(this);
        cancle.setOnClickListener(this);
        recyclerButton.setOnClickListener(this);
        this.recycler.setLayoutManager(new LinearLayoutManager(this));
        this.recycler.setAdapter(adapter);
        adapter.refreshData(list);
        adapter.setOnItemClickListener(this);
    }

    public void show(View view) {
        bottomSheetDialog.show();
    }

    @Override
    public void onItemClick(View v, Object data) {
        int childLayoutPosition = recycler.getChildLayoutPosition(v);
        Toast.makeText(this, "我被点击了" + childLayoutPosition, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
                break;
            case R.id.cancle:
                Toast.makeText(this, "确认", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
                break;
            case R.id.recycler:
                Intent intent = new Intent(this, RecyclerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
