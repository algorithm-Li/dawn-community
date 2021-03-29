package com.dawn.community.widget;

import android.content.Context;
import android.util.AttributeSet;

import cn.jzvd.JzvdStd;

/**
 * @author Algorithm
 * @Date: 2021/3/30/0030
 * @Time: 0:02
 */
public class MyVideoPlayer extends JzvdStd {

    public MyVideoPlayer(Context context) {
        super(context);
    }

    public MyVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 左右两边不会有明显的黑边
     */
    @Override
    public void onVideoSizeChanged(int width, int height) {
        if(textureView!=null){
            textureView.setVideoSize(textureViewContainer.getWidth(),textureViewContainer.getHeight());
        }
    }
}
