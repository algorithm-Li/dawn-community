package com.dawn.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.history.HistoryItem;
import com.dawn.community.bean.message.PrivateMessageItem;
import com.dawn.community.databinding.ItemHistoryBinding;
import com.dawn.community.databinding.ItemPrivateMessageBinding;

import java.util.ArrayList;

public class PrivateMessageAdapter extends RecyclerView.Adapter<PrivateMessageAdapter.InnerHolder> {

    ArrayList<PrivateMessageItem> privateMessageItemArrayList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //这里面的内容不可以设置成成员变量
        //只能是局部变量，因为这些变量一直在变化
        ItemPrivateMessageBinding itemPrivateMessageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_private_message,parent,false);
        return new InnerHolder(itemPrivateMessageBinding.getRoot(),itemPrivateMessageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        PrivateMessageItem itemData = privateMessageItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemPrivateMessageBinding.setItemData(itemData);//拿到对应item的数据
    }

    @Override
    public int getItemCount() {
        return privateMessageItemArrayList.size();
    }

    public void setData(ArrayList<PrivateMessageItem> privateMessageItems){
        privateMessageItemArrayList.clear();
        privateMessageItemArrayList.addAll(privateMessageItems);
        //如果是通过添加到头部，或者添加到底部的方式
        //可以局部更新
        //添加到头部或者尾部
        this.notifyDataSetChanged();
    }


    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemPrivateMessageBinding itemPrivateMessageBinding;

        public InnerHolder(@NonNull View itemView, ItemPrivateMessageBinding itemBinding) {
            super(itemView);
            this.itemPrivateMessageBinding = itemBinding;
        }
    }


}
