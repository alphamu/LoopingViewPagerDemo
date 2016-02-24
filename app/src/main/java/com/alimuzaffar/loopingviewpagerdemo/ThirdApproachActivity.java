package com.alimuzaffar.loopingviewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.viewpagerindicator.LoopingCirclePageIndicator;
import com.viewpagerindicator.LoopingPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThirdApproachActivity extends AppCompatActivity {

    ViewPager mPager;
    ViewGroup mFrameLayout;
    CustomPagerAdapterAdapter2 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_approach);
        mPager = (ViewPager) findViewById(R.id.pager);
        mFrameLayout = (ViewGroup) findViewById(R.id.pagesContainer);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ContentFragment.newInstance("Hello"));
        fragments.add(ContentFragment.newInstance("World"));
        fragments.add(ContentFragment.newInstance("!!!!!"));
        fragments.add(ContentFragment.newInstance("~~~~"));
        mAdapter = new CustomPagerAdapterAdapter2(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mAdapter);

        //This put the initial page as close of 1000 as it can
        //So the user can scroll in both directions
        //Without reaching position 0 easily
        //giving him the sensation that he is interacting with an infinite viewpager
        //(It was hard to reach final position,
        //but so easy to reach position 0
        //so this fix this issue)
        mPager.setCurrentItem(1000 - (1000 % fragments.size()));

        LoopingCirclePageIndicator circlePageIndicator = new LoopingCirclePageIndicator(this);
        circlePageIndicator.setViewPager(mPager);
        mFrameLayout.addView(circlePageIndicator);


    }

    static class CustomPagerAdapterAdapter2 extends FragmentStatePagerAdapter implements LoopingPagerAdapter {

        List<Fragment> mFrags = new ArrayList<>();

        public CustomPagerAdapterAdapter2(FragmentManager fm, List<Fragment> frags) {
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

        @Override
        public int getRealCount() {
            return mFrags.size();
        }
    }
}
