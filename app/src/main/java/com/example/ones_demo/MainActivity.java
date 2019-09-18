package com.example.ones_demo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import com.example.ones_demo.adapter.MyExpandableListViewAdapter;
import com.example.ones_demo.bean.ChildBean;
import com.example.ones_demo.bean.GroupBean;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[][] states;
    private int[] colors;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setNav();
        initView();
        initData();
        setLentse();

    }

    private void init() {

    }

    private void setNav() {
        states = new int[][] {
                new int[] { android.R.attr.state_selected}, // 选中状态
                new int[] { android.R.attr.state_enabled}  // 未选中状态
        };

        colors = new int[] {
                Color.BLUE,
                Color.GRAY
        };
        ColorStateList myList = new ColorStateList(states, colors);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemTextColor(myList);//设置item文字颜色
        navView.setItemIconTintList(myList);//设置item图片颜色
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void initView() {

    }

    private void initData() {

    }

    private void setLentse() {

    }

}
