package com.alimuzaffar.loopingviewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class SecondApproachActivity extends AppCompatActivity {

    ViewPager mPager;
    ViewGroup mFrameLayout;
    CustomPagerAdapter2 mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_approach);
        mPager = (ViewPager) findViewById(R.id.pager);
        mFrameLayout = (ViewGroup) findViewById(R.id.pagesContainer);

        mAdapter = new CustomPagerAdapter2(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

        CirclePageIndicator circlePageIndicator = new CirclePageIndicator(this);
        circlePageIndicator.setViewPager(mPager);
        mFrameLayout.addView(circlePageIndicator);
    }

    static class CustomPagerAdapter2 extends FragmentStatePagerAdapter {

        List<Fragment> mFrags = new ArrayList<>();
        public CustomPagerAdapter2(FragmentManager fm) {
            super(fm);
            mFrags.add(ContentFragment.newInstance("Hello"));
            mFrags.add(ContentFragment.newInstance("World"));
            mFrags.add(ContentFragment.newInstance("!!!!!"));
            mFrags.add(ContentFragment.newInstance("~~~~"));
        }

        @Override
        public Fragment getItem(int position) {
            int index = position%mFrags.size();
            return mFrags.get(index);
        }

        @Override
        public int getCount() {
            return 100;
        }
    }
}
