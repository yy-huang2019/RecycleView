package com.yyhuang.recyclerviewtest;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yyhuang.recyclerviewtest.Bean.Datas;
import com.yyhuang.recyclerviewtest.Bean.MoreTypeBean;
import com.yyhuang.recyclerviewtest.adapters.MoreTypeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoreTypeActivity extends Activity {

    private RecyclerView recyclerView;
    private List mData;
    private Random random;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_type);

        //找到控件
        recyclerView = this.findViewById(R.id.more_type_recycleView);

        mData = new ArrayList<MoreTypeBean>();
        //准备数据
        initData();
        //创建和设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //创建适配器
        MoreTypeAdapter adapter = new MoreTypeAdapter(mData);

        //实现适配器
        recyclerView.setAdapter(adapter);
    }


    private void initData() {
        random = new Random();

        for(int i = 0;i< Datas.icons.length;i++){
            //产生一个0-3的正数(不包括bound)
            int nextInt = random.nextInt(4);
            MoreTypeBean moreTypeBean = new MoreTypeBean();
            moreTypeBean.pic = Datas.icons[i];
            moreTypeBean.type = nextInt;

            mData.add(moreTypeBean);
        }
    }
}
