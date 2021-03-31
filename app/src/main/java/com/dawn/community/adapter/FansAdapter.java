package com.dawn.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.FansItem;
import com.dawn.community.bean.message.ContactsItem;
import com.dawn.community.databinding.ItemFansBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:26
 */
public class FansAdapter extends RecyclerView.Adapter<FansAdapter.InnerHolder> {

    ArrayList<FansItem> fansItemArrayList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFansBinding itemFansBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_fans,parent,false);
        return new InnerHolder(itemFansBinding.getRoot(),itemFansBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        FansItem itemData = fansItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemFansBinding.setItemData(itemData);//拿到对应item的数据a
    }

    @Override
    public int getItemCount() {
        return fansItemArrayList.size();
    }

    public void setData(ArrayList<FansItem> fansItems) {
        this.fansItemArrayList.clear();
        this.fansItemArrayList.addAll(fansItems);
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemFansBinding itemFansBinding;

        public InnerHolder(@NonNull View itemView, ItemFansBinding itemBinding) {
            super(itemView);
            this.itemFansBinding = itemBinding;
        }
    }
}
