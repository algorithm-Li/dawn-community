package com.dawn.community.adapter.binding_adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.dawn.community.R;

/**
 * @author Algorithm
 */
public class ImageViewAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView,int imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("isFollow")
    public static void isFollowOrNot(ImageView imageView,boolean isFollow){
        if(!isFollow){
            Glide.with(imageView.getContext()).load(R.drawable.follow_256px).into(imageView);
        }else{
            Glide.with(imageView.getContext()).load(R.drawable.follow_after_256px).into(imageView);
        }
    }
}
