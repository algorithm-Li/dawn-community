package com.dawn.community.utils;

import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * 单例类 动画工具类
 */
public class MyAnimations {

    private static MyAnimations instance = new MyAnimations();

    public MyAnimations() {
    }

    public static MyAnimations getInstance(){
        if(instance == null){
            instance = new MyAnimations();
        }
        return instance;
    }

    public ScaleAnimation scaleAnimation(){
        return this.scaleAnimation(400L);
    }

    public ScaleAnimation scaleAnimation(Long durationMillis){
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0f,
                1f,
                0f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );
        scaleAnimation.setDuration(durationMillis);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    public ScaleAnimation overshootAnimate(){
        return this.overshootAnimate(200L);
    }

    public ScaleAnimation overshootAnimate(Long durationMillis){
        ScaleAnimation scaleAnimation = this.scaleAnimation(durationMillis);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        return scaleAnimation;
    }
}

