package com.dawn.community.adapter.binding_adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dawn.community.R;
import com.dawn.community.adapter.PictureListAdapter;
import com.dawn.community.bean.discover.PictureItem;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 1:11
 */
public class RecyclerviewAdapter {

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
}
