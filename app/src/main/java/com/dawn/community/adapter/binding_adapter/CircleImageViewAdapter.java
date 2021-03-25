package com.dawn.community.adapter.binding_adapter;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Algorithm
 */
public class CircleImageViewAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(@NotNull CircleImageView circleImageView, int imageUrl){
        Glide.with(circleImageView.getContext()).load(imageUrl).into(circleImageView);
    }
}
