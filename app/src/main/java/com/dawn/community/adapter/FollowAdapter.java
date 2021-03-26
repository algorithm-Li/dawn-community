package com.dawn.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.discover.FollowItem;
import com.dawn.community.databinding.ItemFollowBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 22:38
 */
public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.InnerHolder> {

    ArrayList<FollowItem> followItemArrayList = new ArrayList<>();

    Context context;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFollowBinding itemFollowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_follow,parent,false);
        return new InnerHolder(itemFollowBinding.getRoot(),itemFollowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        FollowItem itemData = followItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemFollowBinding.setItemData(itemData);//拿到对应item的数据
        holder.itemFollowBinding.setContext(context);
    }

    @Override
    public int getItemCount() {
        return followItemArrayList.size();
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void setData(ArrayList<FollowItem> followItems){
        followItemArrayList.clear();
        followItemArrayList.addAll(followItems);
        //如果是通过添加到头部，或者添加到底部的方式
        //可以局部更新
        //添加到头部或者尾部
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemFollowBinding itemFollowBinding;

        public InnerHolder(@NonNull View itemView, ItemFollowBinding itemBinding) {
            super(itemView);
            this.itemFollowBinding = itemBinding;
        }
    }

}
