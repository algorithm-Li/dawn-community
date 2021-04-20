package com.dawn.community.activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.dawn.community.R;
import com.dawn.community.adapter.utils_adapter.PhotoViewPagerAdapter;
import com.dawn.community.base.BaseVmActivity;
import com.dawn.community.databinding.ActivityShowPicBinding;
import com.dawn.community.viewmodel.activity.ShowPicViewModel;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class ShowPicActivity extends BaseVmActivity<ActivityShowPicBinding, ShowPicViewModel>{

    private ArrayList<Integer> imageList = new ArrayList<>();

    private int current = 0;

    private PhotoViewPagerAdapter photoViewPagerAdapter = new PhotoViewPagerAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void startLoadData() {
        super.startLoadData();
        if(getIntent()!=null){
            imageList = getIntent().getIntegerArrayListExtra("list");
            current = getIntent().getIntExtra("position",0);
        }
        photoViewPagerAdapter.setImageList(imageList);
        photoViewPagerAdapter.setContext(this);

        viewDataBinding.viewPager.setAdapter(photoViewPagerAdapter);
        viewDataBinding.viewPager.setCurrentItem(current);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        viewDataBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                current = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_show_pic;
    }

    @Override
    public Class<ShowPicViewModel> getSubVMClass() {
        return ShowPicViewModel.class;
    }

}