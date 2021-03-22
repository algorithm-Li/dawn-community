package com.dawn.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.dawn.community.adapter.utils_adapter.ViewPagerAdapter;
import com.dawn.community.fragment.discover.DiscoverFragment;
import com.dawn.community.fragment.DistinguishFragment;
import com.dawn.community.fragment.MineFragment;
import com.dawn.community.fragment.social.SocialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private ViewPager mainViewPager;
    //ViewPager2实例
    //private ViewPager2 mainViewPager;

    //Fragment数组
    private ArrayList<Fragment> myFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    /**
     * 初始化页面
     */
    private void initView() {
        //获取BottomNavigationViews实例
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        /*设置下方导航栏文字和图标同时显示*/
        mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        /*
        //采用绑定Navigation和BottomNavigationView的页面
        //方法一：去fragment管理器里通过id找到NavHostFragment，在Xml里使用的是androidx.fragment.app.FragmentContainerView
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
        if(navHostFragment!=null){
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(mBottomNavigationView, navController);
        }
        //或者采用下面方法
        //方法二：在Xml里使用的是fragment
        NavController navController = Navigation.findNavController(this, R.id.fragment_container_view);
        NavigationUI.setupWithNavController(mBottomNavigationView, navController);
        */

        /*
        //采用绑定ViewPager2和BottomNavigationView的页面
        //fragmentList加载数据
        myFragmentList.add(new DistinguishFragment());
        myFragmentList.add(new SocialFragment());
        myFragmentList.add(new DiscoverFragment());
        myFragmentList.add(new MineFragment());
        //ViewPager加载适配器
        mainViewPager = findViewById(R.id.main_viewPager);
        mainViewPager.setAdapter(new ViewPagerAdapter(this,myFragmentList));
         */

        //采用绑定ViewPager和BottomNavigationView的页面
        myFragmentList.add(new DistinguishFragment());
        myFragmentList.add(new SocialFragment());
        myFragmentList.add(new DiscoverFragment());
        myFragmentList.add(new MineFragment());
        //ViewPager加载适配器
        mainViewPager = findViewById(R.id.main_viewPager);
        mainViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),myFragmentList));

    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        //绑定mBottomNavigationView与mainViewPager
        //mBottomNavigationView页面切换viewPager跟着切换
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //注意 currentItem下标的切换以及break的使用
                switch(item.getItemId()){
                    case R.id.distinguish_Fragment:
                        mainViewPager.setCurrentItem(0);
                        mBottomNavigationView.getMenu().findItem(R.id.distinguish_Fragment).setChecked(true);
                        break;
                    case R.id.social_Fragment:
                        mainViewPager.setCurrentItem(1);
                        mBottomNavigationView.getMenu().findItem(R.id.social_Fragment).setChecked(true);
                        break;
                    case R.id.discover_Fragment:
                        mainViewPager.setCurrentItem(2);
                        mBottomNavigationView.getMenu().findItem(R.id.discover_Fragment).setChecked(true);
                        break;
                    case R.id.mine_Fragment:
                        mainViewPager.setCurrentItem(3);
                        mBottomNavigationView.getMenu().findItem(R.id.mine_Fragment).setChecked(true);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        //viewPager页面切换mBottomNavigationView跟着切换
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.distinguish_Fragment).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.social_Fragment).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.discover_Fragment).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.mine_Fragment).setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

}