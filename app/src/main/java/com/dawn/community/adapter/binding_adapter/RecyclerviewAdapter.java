package com.dawn.community.adapter.binding_adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dawn.community.R;
import com.dawn.community.adapter.PictureListAdapter;
import com.dawn.community.adapter.utils_adapter.FollowPictureListAdapter;
import com.dawn.community.bean.discover.PictureItem;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 1:11
 */
public class RecyclerviewAdapter {

    /**
     * RecommendFragment 页面的 Recyclerview的属性加载器
     * @param recyclerView Recyclerview控件
     * @param isVideo 是否是视频
     * @param pictureItemArrayList 图片数组资源
     * @param context 上下文
     */
    @BindingAdapter(value = {"isVideo","imageArrayList","fragmentContext",})
    public static void isFollowOrNot(RecyclerView recyclerView, boolean isVideo, ArrayList<PictureItem> pictureItemArrayList, Context context){

        Log.d("RecyclerviewAdapter",isVideo+"");

        if(!isVideo){
            Log.d("RecyclerviewAdapter",pictureItemArrayList.size()+"");
            recyclerView.setLayoutManager(new GridLayoutManager(context,3));

            PictureListAdapter pictureListAdapter = new PictureListAdapter();
            pictureListAdapter.setData(pictureItemArrayList);

            recyclerView.setAdapter(pictureListAdapter);
        }
    }

    /**
     * item_follow中的Recyclerview的加载器
     * @param recyclerView Recyclerview控件
     * @param pictureItemArrayList 图片资源数组
     * @param context 上下文
     */
    @BindingAdapter(value = {"imageArrayList","fragmentContext"})
    public static void pictureList(RecyclerView recyclerView, ArrayList<PictureItem> pictureItemArrayList, Context context){

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        //设置方向为水平方向
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FollowPictureListAdapter followPictureListAdapter = new FollowPictureListAdapter();
        followPictureListAdapter.setData(pictureItemArrayList);
        recyclerView.setAdapter(followPictureListAdapter);
    }


}
