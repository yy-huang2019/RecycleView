package com.yyhuang.recyclerviewtest.adapters;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yyhuang.recyclerviewtest.Bean.ItemBean;
import com.yyhuang.recyclerviewtest.R;

import java.util.List;

//3.适配器的创建
public class ListViewAdapter extends RecycleViewBaseAdapter {

    private static final String TAG = ListViewAdapter.class.getName();

    public ListViewAdapter(List<ItemBean> data){
        super(data);
    }


    protected View getSubView(ViewGroup parent,int viewType) {
        //传进去的这个View其实就是条目的界面(创建用于存放条目的界面)
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return view;
    }
}
