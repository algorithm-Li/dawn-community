package com.dawn.community.adapter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.message.Message;
import com.dawn.community.databinding.ItemPracticeInstantBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Algorithm
 * @Date: 2021/3/27/0027
 * @Time: 17:42
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.InnerHolder>{

    ArrayList<Message> messageList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPracticeInstantBinding itemPracticeInstantBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_practice_instant,parent,false);
        return new InnerHolder(itemPracticeInstantBinding.getRoot(),itemPracticeInstantBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public void addData() {

    }


    static class InnerHolder extends RecyclerView.ViewHolder{
        ItemPracticeInstantBinding itemPracticeInstantBinding;
        public InnerHolder(@NonNull View itemView, ItemPracticeInstantBinding itemBinding) {
            super(itemView);
            this.itemPracticeInstantBinding = itemBinding;

            /*
             * 设置水波纹背景
             */
            if (itemView.getBackground() == null) {
                TypedValue typedValue = new TypedValue();
                Resources.Theme theme = itemView.getContext().getTheme();
                int top = itemView.getPaddingTop();
                int bottom = itemView.getPaddingBottom();
                int left = itemView.getPaddingLeft();
                int right = itemView.getPaddingRight();
                if (theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)) {
                    itemView.setBackgroundResource(typedValue.resourceId);
                }
                itemView.setPadding(left, top, right, bottom);
            }
        }
    }

}
