package com.example.administrator.recyclerviewitemtouchhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView_main;
    private List<String> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initData();
    }

    private void initData() {
        //初始化数据源
        list = getData();
        //初始化适配器
        myAdapter = new MyAdapter(this, list);

        //先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(myAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(recyclerView_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView_main.setLayoutManager(linearLayoutManager);
        recyclerView_main.setAdapter(myAdapter);
    }

    private void findView() {
        recyclerView_main = (RecyclerView) findViewById(R.id.recyclerView_main);
    }

    /**
     * 模拟数据
     *
     * @return
     */
    public List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item" + i);
        }
        return list;
    }
}
