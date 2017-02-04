package com.example.administrator.recyclerviewitemtouchhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * author:  wujinli
 * date:    2017/2/4
 * desc:    recyclerview的适配器
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        ItemTouchHelperAdapter {

    private List<String> mData;
    private LayoutInflater inflater;
    private Context context;

    public MyAdapter(Context context, List<String> mData) {
        this.context = context;
        this.mData = mData;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).tv_textView.setText(mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        Collections.swap(mData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemRemoved(int position) {
        //移除数据
        mData.remove(position);
        notifyItemRemoved(position);
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv_textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv_textView = (TextView) itemView.findViewById(R.id.tv_textView);
    }
}
