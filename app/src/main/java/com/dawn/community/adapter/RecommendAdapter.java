package com.dawn.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.databinding.ItemRecommendBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 0:52
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.InnerHolder> {

    ArrayList<RecommendItem> recommendItemArrayList = new ArrayList<>();

    Context context;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecommendBinding itemRecommendBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_recommend,parent,false);
        return new InnerHolder(itemRecommendBinding.getRoot(),itemRecommendBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        RecommendItem itemData = recommendItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemRecommendBinding.setItemData(itemData);//拿到对应item的数据
    }

    @Override
    public int getItemCount() {
        return recommendItemArrayList.size();
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void setData(ArrayList<RecommendItem> recommendItems){
        recommendItemArrayList.clear();
        recommendItemArrayList.addAll(recommendItems);
        //如果是通过添加到头部，或者添加到底部的方式
        //可以局部更新
        //添加到头部或者尾部
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemRecommendBinding itemRecommendBinding;

        public InnerHolder(@NonNull View itemView, ItemRecommendBinding itemBinding) {
            super(itemView);
            this.itemRecommendBinding = itemBinding;
        }
    }
}
