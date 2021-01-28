package com.yyhuang.recyclerviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.yyhuang.recyclerviewtest.Bean.Datas;
import com.yyhuang.recyclerviewtest.Bean.ItemBean;
import com.yyhuang.recyclerviewtest.adapters.GirdViewAdapter;
import com.yyhuang.recyclerviewtest.adapters.ListViewAdapter;
import com.yyhuang.recyclerviewtest.adapters.RecycleViewBaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private static final String TAG1 = "aaa";
    private RecyclerView recyclerView;
    private List<ItemBean> mData;
    RecycleViewBaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.要有RecycleView控件，找到该控件
        recyclerView = this.findViewById(R.id.RecyclerView);
        //2.准备数据
        /**
         * 现实开发中，我们的数据一般是从网络上获取
         */
        initData();
        //首次显示
        showList(true, false);
    }

    private void initData() {
        //ListView<listBean（描述图片的信息）>--->
        //(设置适配器)Adapter----> (将适配器的内容展示到ListView)--->显示数据

        mData = new ArrayList<>();
        //创建模拟数据(Datas是一个类，存放图片数组icon)
        for (int i = 0; i < Datas.icons.length; i++) {
            //ItemBean是一个存放条目信息的bean类
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第" + i + "个条目";
            //将数据添加到集合
            mData.add(data);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            //ListView部分
            case R.id.list_view_vertical_standard:
                Log.d(TAG, "点击了垂直标准");
                //表示显示的是第几种类型(垂直，水平..)
                showList(true, false);
                break;
            case R.id.list_view_vertical_reverse:
                showList(true, true);
                break;
            case R.id.list_view_horizontal_standard:
                showList(false, false);
                break;
            case R.id.list_view_horizontal_reverse:
                showList(false, true);
                break;

            //GirdView部分
            case R.id.grid_view_vertical_standard:
                showGird(true, false);
                break;
            case R.id.grid_view_vertical_reverse:
                showGird(true, true);
                break;
            case R.id.grid_view_horizontal_standard:
                showGird(false, false);
                break;
            case R.id.grid_view_horizontal_reverse:
                showGird(false, true);
                break;

            //瀑布流部分
            case R.id.stagger_view_vertical_standard:

                break;
            case R.id.stagger_view_vertical_reverse:

                break;
            case R.id.stagger_view_horizontal_standard:

                break;
            case R.id.stagger_view_horizontal_reverse:

                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void showGird(boolean isVertical, boolean isReverse) {
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        //设置布局管理器来控制设置水平还是垂直，正向还是反向
        manager.setOrientation(isVertical ? RecyclerView.VERTICAL : RecyclerView.HORIZONTAL);
        manager.setReverseLayout(isReverse);
        recyclerView.setLayoutManager(manager);
        Log.d(TAG1, "manager--->" + manager);
        //4.创建适配器(数据和控件是桥梁；把数据弄的适当，显示在需要显示的控件上面)
        mAdapter = new GirdViewAdapter(mData);

        recyclerView.setAdapter(mAdapter);
        Log.d(TAG1, "adapter--->" + mAdapter);

        //初始化点击事件
        initListener();
    }


    //用于显示不同效果
    private void showList(boolean isVertical, boolean isReverse) {
        //3.RecycleView设置样式，其实就是设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);

        //设置布局管理器来控制设置水平还是垂直，正向还是反向
        manager.setOrientation(isVertical ? RecyclerView.VERTICAL : RecyclerView.HORIZONTAL);
        manager.setReverseLayout(isReverse);

        recyclerView.setLayoutManager(manager);

        //4.创建适配器(数据和控件是桥梁；把数据弄的适当，显示在需要显示的控件上面)
        mAdapter = new ListViewAdapter(mData);

        //5.设置适配器到RecycleView中
        recyclerView.setAdapter(mAdapter);

        //初始化点击事件
        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new RecycleViewBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"您点击的是第"+position+"个条目",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
