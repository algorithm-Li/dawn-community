package com.dawn.community.binding_handler;

import android.content.Intent;
import android.view.View;

import com.dawn.community.activity.ChatActivity;

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





}
