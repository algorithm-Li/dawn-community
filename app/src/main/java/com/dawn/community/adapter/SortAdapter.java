package com.dawn.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dawn.community.bean.message.ContactsItem;

import java.util.ArrayList;
import java.util.List;
import com.dawn.community.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Algorithm
 * @Date: 2021/3/25/0025
 * @Time: 14:24
 */
@Deprecated
public class SortAdapter extends BaseAdapter {

    private ArrayList<ContactsItem> list = new ArrayList<>();
    private Context mContext;

    public SortAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public SortAdapter(Context mContext, ArrayList<ContactsItem> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public void setData(ArrayList<ContactsItem> contactsItems){
        this.list.clear();
        this.list.addAll(contactsItems);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder;
        final ContactsItem contacts = list.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_contacts, null);
            viewHolder.lyCatalog = (LinearLayout)view.findViewById(R.id.ly_catalog);
            viewHolder.rlName = (RelativeLayout)view.findViewById(R.id.rl_name);
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.catalog = (TextView) view.findViewById(R.id.catalog);
            viewHolder.circleImageView = (CircleImageView)view.findViewById(R.id.contacts_img);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //根据position获取首字母作为目录catalog
        String catalog = list.get(position).getFirstLetter();

        //如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if(position == getPositionForSection(catalog)){
            viewHolder.lyCatalog.setVisibility(View.VISIBLE);
            viewHolder.catalog.setVisibility(View.VISIBLE);
            viewHolder.catalog.setText(contacts.getFirstLetter().toUpperCase());
        }else{
            viewHolder.catalog.setVisibility(View.GONE);
            viewHolder.lyCatalog.setVisibility(View.GONE);
        }
        viewHolder.name.setText(this.list.get(position).getName());
        Glide.with(viewHolder.circleImageView).load(list.get(position).getImage()).into(viewHolder.circleImageView);
        return view;
    }

    final static class ViewHolder {
        LinearLayout lyCatalog;
        RelativeLayout rlName;
        TextView catalog;
        TextView name;
        CircleImageView circleImageView;
    }

    /**
     * 获取catalog首次出现位置
     */
    public int getPositionForSection(String catalog) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getFirstLetter();
            if (catalog.equalsIgnoreCase(sortStr)) {
                return i;
            }
        }
        return -1;
    }
}
