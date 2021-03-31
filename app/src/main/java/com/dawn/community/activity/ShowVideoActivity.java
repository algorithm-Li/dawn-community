package com.dawn.community.activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.dawn.community.R;
import com.dawn.community.api.HttpConfig;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivityShowVideoBinding;
import com.dawn.community.viewmodel.activity.ShowVideoViewModel;

import java.util.ArrayList;
import java.util.Random;

import cn.jzvd.Jzvd;

/**
 * @author Algorithm
 */
public class ShowVideoActivity extends BaseVmActivity<ActivityShowVideoBinding, ShowVideoViewModel>{

    String[] video_url = new String[]{
            "video_1.mp4",
            "video_2.mp4",
    };

    Random random = new Random(10);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        viewDataBinding.videoPlayer.setUp(HttpConfig.BASE_URL + "/mp4/" + video_url[random.nextInt(video_url.length)] ,"视频动态");
        Glide.with(this).load(R.drawable.naeun_1).into(viewDataBinding.videoPlayer.posterImageView);
        viewDataBinding.videoPlayer.startVideo();
    }

    @Override
    public void onBackPressed() {
        if(Jzvd.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_show_video;
    }

    @Override
    public Class<ShowVideoViewModel> getSubVMClass() {
        return ShowVideoViewModel.class;
    }

}