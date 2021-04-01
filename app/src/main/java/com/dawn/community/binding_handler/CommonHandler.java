package com.dawn.community.binding_handler;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.dawn.community.R;
import com.dawn.community.activity.ChatActivity;
import com.dawn.community.activity.ShowVideoActivity;
import com.dawn.community.activity.CommentActivity;
import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.viewmodel.fragment.person_info.ChangeSexViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 * @Date: 2021/3/27/0027
 * @Time: 15:44
 */
public class CommonHandler {

    /**
     * 加载 ChatActivity
     * @param v 视图
     */
    public void startChatActivity(@NotNull View v){
        v.getContext().startActivity(new Intent(v.getContext(), ChatActivity.class));
    }

    /**
     * 加载 ShowVideoActivity
     * @param v 视图
     */
    public void startVideo(@NonNull View v){
        v.getContext().startActivity(new Intent(v.getContext(), ShowVideoActivity.class));
    }

    /**
     * 加载 CommentActivity
     * @param view 视图
     * @param itemData 数据
     */
    public void startComment(@NotNull View view, RecommendItem itemData){
        Intent intent = new Intent(view.getContext(), CommentActivity.class);
        intent.putExtra("itemData",itemData);
        view.getContext().startActivity(intent);
    }

    /**
     * 改变 选择的性别数据
     * @param view 视图
     * @param changeSexViewModel 数据
     */
    public void changeSexData(@NotNull View view, ChangeSexViewModel changeSexViewModel){
        String chooseSex;
        Log.d("changeSexData",view.getId()+"");
        switch (view.getId()){
            case R.id.relative_male:
            case R.id.tv_male:
            case R.id.icon_change_sex_male_choose:
                chooseSex = "男";
                break;
            case R.id.relative_female:
            case R.id.tv_female:
            case R.id.icon_change_sex_female_choose:
                chooseSex = "女";
                break;
            case R.id.relative_secret:
            case R.id.tv_secret:
            case R.id.icon_change_sex_secret_choose:
            default:
                chooseSex = "保密";
                break;
        }
        Log.d("changeSexData",chooseSex);
        changeSexViewModel.setSex(chooseSex);
    }
}
