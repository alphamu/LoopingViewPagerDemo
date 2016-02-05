package com.alimuzaffar.loopingviewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.alimuzaffar.loopingviewpagerdemo.customindicator.MyPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class DiyApproachActivity extends AppCompatActivity {

    ViewPager mPager;
    LinearLayout mLinearLayout;
    CustomPagerAdapter2 mAdapter;
    MyPageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_approach);
        mPager = (ViewPager) findViewById(R.id.pager);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ContentFragment.newInstance("Hello"));
        fragments.add(ContentFragment.newInstance("World"));
        fragments.add(ContentFragment.newInstance("!!!!!"));
        fragments.add(ContentFragment.newInstance("~~~~"));
        mAdapter = new CustomPagerAdapter2(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mAdapter);
        mIndicator = new MyPageIndicator(this, mLinearLayout, mPager, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIndicator.cleanup();
    }

    static class CustomPagerAdapter2 extends FragmentStatePagerAdapter {

        List<Fragment> mFrags = new ArrayList<>();

        public CustomPagerAdapter2(FragmentManager fm, List<Fragment> frags) {
            super(fm);
            mFrags = frags;
        }

        @Override
        public Fragment getItem(int position) {
            int index = position % mFrags.size();
            return mFrags.get(index);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

    }
}
