package com.yyhuang.recyclerviewtest.adapters;

import android.net.sip.SipSession;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yyhuang.recyclerviewtest.Bean.ItemBean;
import com.yyhuang.recyclerviewtest.R;

import java.util.List;

public abstract class RecycleViewBaseAdapter extends RecyclerView.Adapter<RecycleViewBaseAdapter.InnerHolder> {

    private final List<ItemBean> mData;
    private OnItemClickListener mOnItemClickListener;

    public RecycleViewBaseAdapter(List<ItemBean> data){
        this.mData = data;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getSubView(parent,viewType);
        return new InnerHolder(view);
    }

    protected abstract View getSubView(ViewGroup parent,int viewType);


    @Override
    public void onBindViewHolder(@NonNull RecycleViewBaseAdapter.InnerHolder holder, int position) {
        //设置数据
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if(mData != null){
            return mData.size();
        }
        return 0;
    }


    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView title;
        private int position;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //一.设置数据前找到条目控件
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);

            //4.点击事件之外部接口方法的调用
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            });
        }

        //用于设置数据
        public void setData(ItemBean itemBean ,int position) {
            this.position = position;
            //二.找到对应条目控件后设置数据
            icon.setImageResource(itemBean.icon);
            title.setText(itemBean.title);

        }
    }

    /**
     * 其实recycleView没有点击处理事件，根据ListView自己处理事件
     * 编写回调的步骤
     * 1.创建这个接口
     * 2.定义接口内部方法
     * 3.实现接口定义的方法
     * 4.外部接口方法的调用
     */
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        //设置一个监听事件，其实就是设置一个接口
        this.mOnItemClickListener = listener;
    }
}
