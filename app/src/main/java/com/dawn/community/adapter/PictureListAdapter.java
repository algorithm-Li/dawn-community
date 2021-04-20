package com.dawn.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.discover.PictureItem;
import com.dawn.community.databinding.ItemPictureBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 1:21
 */
public class PictureListAdapter extends RecyclerView.Adapter<PictureListAdapter.InnerHolder>{

    ArrayList<PictureItem> pictureItemArrayList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPictureBinding itemPictureBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_picture,parent,false);
        return new InnerHolder(itemPictureBinding.getRoot(),itemPictureBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        PictureItem pictureItem = pictureItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemPictureBinding.setPictureItem(pictureItem);//拿到对应item的数据
        holder.itemPictureBinding.setPictureList(pictureItemArrayList);
        holder.itemPictureBinding.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return pictureItemArrayList.size();
    }

    public void setData(ArrayList<PictureItem> pictureItems){
        pictureItemArrayList.clear();
        pictureItemArrayList.addAll(pictureItems);
        //如果是通过添加到头部，或者添加到底部的方式
        //可以局部更新
        //添加到头部或者尾部
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemPictureBinding itemPictureBinding;

        public InnerHolder(@NonNull View itemView, ItemPictureBinding itemBinding) {
            super(itemView);
            this.itemPictureBinding = itemBinding;
        }
    }
}
