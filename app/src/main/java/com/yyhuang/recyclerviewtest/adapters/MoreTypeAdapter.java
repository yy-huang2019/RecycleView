package com.yyhuang.recyclerviewtest.adapters;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yyhuang.recyclerviewtest.Bean.MoreTypeBean;
import com.yyhuang.recyclerviewtest.R;

import java.util.List;

public class MoreTypeAdapter extends RecyclerView.Adapter {

    private static final String TAG = "MoreTypeAdapter";
    private final List<MoreTypeBean> mData;

    //定义三个常量，有三种展示类型
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    private int number;

    public MoreTypeAdapter(List<MoreTypeBean> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Log.d(TAG,"viewType--->"+viewType);
        if (viewType == FIRST) {
            view = View.inflate(parent.getContext(), R.layout.item_type_first,null);
            return new FirstImageHolder(view);
        }else if(viewType == SECOND){
            view = View.inflate(parent.getContext(),R.layout.item_type_second,null);
            return new SecondImageHolder(view);
        }else{
            view = View.inflate(parent.getContext(),R.layout.item_type_third,null);
            return new ThirdImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    //重写获取条目类型的方法
    @Override
    public int getItemViewType(int position) {
        //通过Activity随机产生的type获取到对应的数字
        MoreTypeBean moreType = mData.get(position);
        switch (moreType.type) {
            case 1:
                number = FIRST;
                break;
            case 2:
                number = SECOND;
                break;
            case 3:
                number = THIRD;
                break;
        }
        return number;
    }


    //创建三个方法返回不同的方法
    private class FirstImageHolder extends RecyclerView.ViewHolder {
        public FirstImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class SecondImageHolder extends RecyclerView.ViewHolder {
        public SecondImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ThirdImageHolder extends RecyclerView.ViewHolder {
        public ThirdImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
