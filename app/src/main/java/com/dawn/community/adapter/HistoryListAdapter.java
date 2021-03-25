package com.dawn.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.history.HistoryItem;
import com.dawn.community.databinding.ItemHistoryBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.InnerHolder> {

    ArrayList<HistoryItem> historyItemArrayList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //这里面的内容不可以设置成成员变量
        //只能是局部变量，因为这些变量一直在变化
        ItemHistoryBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_history, parent, false);
        return new InnerHolder(itemBinding.getRoot(),itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        HistoryItem itemData = historyItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemHistoryBinding.setItemData(itemData);//拿到对应item的数据
    }

    @Override
    public int getItemCount() {
        return historyItemArrayList.size();
    }

    public void setData(ArrayList<HistoryItem> historyItems) {
        historyItemArrayList.clear();
        historyItemArrayList.addAll(historyItems);
        //如果是通过添加到头部，或者添加到底部的方式
        //可以局部更新
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemHistoryBinding itemHistoryBinding;

        public InnerHolder(@NonNull View itemView,ItemHistoryBinding itemBinding) {
            super(itemView);
            this.itemHistoryBinding = itemBinding;
        }
    }
}
