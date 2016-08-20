package com.duanlian.tablayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.duanlian.tablayoutdemo.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTab;
    private MyViewPagerAdapter mAdapter;
    private List<ImageView> mList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 实例化控件
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        //设置ViewPager里面也要显示的图片
        mList = new ArrayList<>();
        ImageView yuanYuan = new ImageView(this);
        ImageView yiYan = new ImageView(this);
        ImageView liYa = new ImageView(this);
        yuanYuan.setImageResource(R.mipmap.gaoyuanyuan);
        yiYan.setImageResource(R.mipmap.jiangyiyan);
        liYa.setImageResource(R.mipmap.tongliya);
        //设置图片显示全屏
        yuanYuan.setScaleType(ImageView.ScaleType.FIT_XY);
        yiYan.setScaleType(ImageView.ScaleType.FIT_XY);
        liYa.setScaleType(ImageView.ScaleType.FIT_XY);
        mList.add(yuanYuan);
        mList.add(yiYan);
        mList.add(liYa);
        //设置标题
        titleList = new ArrayList<>();
        titleList.add("高圆圆");
        titleList.add("江一燕");
        titleList.add("佟丽娅");
        mTab = (TabLayout) findViewById(R.id.main_tab);
        //设置tab的模式
        mTab.setTabMode(TabLayout.MODE_FIXED);
        //添加tab选项卡
        for (int i = 0; i < titleList.size(); i++) {
            mTab.addTab(mTab.newTab().setText(titleList.get(i)));
        }
        //把TabLayout和ViewPager关联起来
        mTab.setupWithViewPager(mViewPager);
        //实例化adapter
        mAdapter = new MyViewPagerAdapter(mList,titleList);
        //给ViewPager绑定Adapter
        mViewPager.setAdapter(mAdapter);


    }
}
