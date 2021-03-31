package com.dawn.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.R;
import com.dawn.community.bean.message.ContactsItem;
import com.dawn.community.binding_handler.CommonHandler;
import com.dawn.community.databinding.ItemContactsBinding;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/25/0025
 * @Time: 15:51
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.InnerHolder> {

    ArrayList<ContactsItem> contactsItemArrayList = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContactsBinding itemContactsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_contacts,parent,false);
        return new InnerHolder(itemContactsBinding.getRoot(),itemContactsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //拿到对应位置的数据
        ContactsItem itemData = contactsItemArrayList.get(position);
        //绑定数据，向binding里设置数据
        //要有binding
        holder.itemContactsBinding.setItemData(itemData);//拿到对应item的数据a
        //根据position获取首字母作为目录catalog
        String catalog = contactsItemArrayList.get(position).getFirstLetter();
        if(position == getPositionForSection(catalog)){
            holder.itemContactsBinding.setIsFirst(View.VISIBLE);
        }else {
            holder.itemContactsBinding.setIsFirst(View.GONE);
        }
        holder.itemContactsBinding.setEventHandler(new CommonHandler());
    }

    @Override
    public int getItemCount() {
        return contactsItemArrayList.size();
    }

    public void setData(ArrayList<ContactsItem> contactsItems) {
        contactsItemArrayList.clear();
        contactsItemArrayList.addAll(contactsItems);
        //如果是通过添加到头部，或者添加到底部的方式
        //可以局部更新
        this.notifyDataSetChanged();
    }

    static class InnerHolder extends RecyclerView.ViewHolder{

        ItemContactsBinding itemContactsBinding;

        public InnerHolder(@NonNull View itemView, ItemContactsBinding itemBinding) {
            super(itemView);
            this.itemContactsBinding = itemBinding;
        }
    }

    /**
     * 获取catalog首次出现位置
     */
    public int getPositionForSection(String catalog) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = contactsItemArrayList.get(i).getFirstLetter();
            if (catalog.equalsIgnoreCase(sortStr)) {
                return i;
            }
        }
        return -1;
    }
}
