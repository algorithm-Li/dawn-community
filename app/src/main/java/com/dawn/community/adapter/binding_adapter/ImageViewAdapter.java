package com.dawn.community.adapter.binding_adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * @author Algorithm
 */
public class ImageViewAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView,int imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
}
