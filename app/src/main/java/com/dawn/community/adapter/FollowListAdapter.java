package com.dawn.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.FollowMessageItem;
import com.dawn.community.databinding.ItemFollowListBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:26
 */
public class FollowListAdapter extends RecyclerView.Adapter<FollowListAdapter.InnerHolder> {

    ArrayList<FollowMessageItem> followMessageItemArrayList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFollowListBinding itemFollowListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_follow_list,parent,false);
        return new InnerHolder(itemFollowListBinding.getRoot(),itemFollowListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        FollowMessageItem itemData = followMessageItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemFollowListBinding.setItemData(itemData);//拿到对应item的数据a
    }

    @Override
    public int getItemCount() {
        return followMessageItemArrayList.size();
    }

    public void setData(ArrayList<FollowMessageItem> followMessageItems) {
        this.followMessageItemArrayList.clear();
        this.followMessageItemArrayList.addAll(followMessageItems);
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemFollowListBinding itemFollowListBinding;

        public InnerHolder(@NonNull View itemView, ItemFollowListBinding itemBinding) {
            super(itemView);
            this.itemFollowListBinding = itemBinding;
        }
    }
}
