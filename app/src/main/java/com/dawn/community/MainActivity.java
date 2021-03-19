package com.dawn.community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化页面
     */
    private void initView() {
        //获取BottomNavigationViews实例
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        /*设置下方导航栏文字和图标同时显示*/
        mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        //绑定Navigation和BottomNavigationView
        //方法一：去fragment管理器里通过id找到NavHostFragment，在Xml里使用的是androidx.fragment.app.FragmentContainerView
        /*NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
        if(navHostFragment!=null){
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(mBottomNavigationView, navController);
        }*/

        //方法二：在Xml里使用的是fragment
        NavController navController = Navigation.findNavController(this, R.id.fragment_container_view);
        NavigationUI.setupWithNavController(mBottomNavigationView, navController);
    }
}