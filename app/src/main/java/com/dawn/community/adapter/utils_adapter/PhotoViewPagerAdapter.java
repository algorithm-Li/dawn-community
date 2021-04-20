package com.dawn.community.adapter.utils_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.dawn.community.R;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/4/19/0019
 * @Time: 22:55
 */
public class PhotoViewPagerAdapter extends PagerAdapter {

    private ArrayList<Integer> imageList = new ArrayList<>();

    private Context context;

    public void setImageList(ArrayList<Integer> imageList) {
        this.imageList = imageList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int url = imageList.get(position);
        PhotoView photoView = new PhotoView(context);
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.message_image_default)
                .error(R.drawable.message_image_default)
                .into(photoView);
        container.addView(photoView);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return photoView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
