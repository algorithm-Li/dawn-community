package com.dawn.community.adapter.binding_adapter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.dawn.community.R;
import com.dawn.community.activity.ShowPicActivity;
import com.dawn.community.bean.discover.PictureItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class ImageViewAdapter {

    /**
     * ImageView加载图片
     * @param imageView ImageView控件
     * @param imageUrl 图片资源路径
     */
    @BindingAdapter("imageUrl")
    public static void setImageUrl(@NotNull ImageView imageView, int imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    /**
     * 根据是否已经是关注过的用户去决定加载的关注图标
     * @param imageView ImageView控件
     * @param isFollow 是否关注
     */
    @BindingAdapter("isFollow")
    public static void isFollowOrNot(ImageView imageView,boolean isFollow){
        if(!isFollow){
            Glide.with(imageView.getContext()).load(R.drawable.follow_256px).into(imageView);
        }else{
            Glide.with(imageView.getContext()).load(R.drawable.follow_after_256px).into(imageView);
        }
    }

    /**
     * 决定是否加载 video图片
     * @param imageView ImageView控件
     * @param isVideo 判断
     */
    @BindingAdapter("isVideo")
    public static void isVideoOrNot(ImageView imageView,boolean isVideo){
        if(isVideo){
            Glide.with(imageView.getContext()).load(R.drawable.video).into(imageView);
        }else{
            imageView.setVisibility(View.GONE);
        }
    }

    /**
     * 决定是否加载 选中性别图片
     * @param imageView ImageView控件
     * @param chooseSex 判断
     */
    @BindingAdapter("chooseSex")
    public static void chooseSex(@NotNull View imageView, String chooseSex){
        int id = imageView.getId();
        if(chooseSex!=null){
            if((chooseSex.equals("保密")&& id == R.id.icon_change_sex_secret_choose) ||
                    (chooseSex.equals("男")&& id == R.id.icon_change_sex_male_choose) ||
                    (chooseSex.equals("女")&& id == R.id.icon_change_sex_female_choose)) {
                imageView.setVisibility(View.VISIBLE);
            }else {
                imageView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * ImageView加载图片
     * @param imageView ImageView控件
     * @param imageUrl 图片资源路径
     * @param imageArrayList 图片数组
     * @param position 在Recyclerview里对应的下标
     */
    @BindingAdapter(value = {"imageUrl","imageArrayList","position"})
    public static void startShowPic(@NotNull ImageView imageView, int imageUrl, ArrayList<PictureItem> imageArrayList, int position){

        Log.d("startShowPic",imageArrayList.size()+"");
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageArrayList != null && imageArrayList.size() > 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    for (PictureItem pictureItem : imageArrayList) {
                        list.add(pictureItem.getImage());
                    }

                    Intent intent = new Intent(imageView.getContext(), ShowPicActivity.class);
                    intent.putIntegerArrayListExtra("list",list);
                    intent.putExtra("position",position);
                    imageView.getContext().startActivity(intent);
                }
            }
        });

    }
}
