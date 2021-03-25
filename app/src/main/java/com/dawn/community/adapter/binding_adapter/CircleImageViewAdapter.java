package com.dawn.community.adapter.binding_adapter;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class CircleImageViewAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(CircleImageView circleImageView, int imageUrl){
        Glide.with(circleImageView.getContext()).load(imageUrl).into(circleImageView);
    }
}
