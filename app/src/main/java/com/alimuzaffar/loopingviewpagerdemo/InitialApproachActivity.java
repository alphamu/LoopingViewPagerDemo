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

public class InitialApproachActivity extends AppCompatActivity {

    ViewPager mPager;
    ViewGroup mFrameLayout;
    CustomPagerAdapter mAdapter;
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

    static class CustomPagerAdapter extends FragmentPagerAdapter {

        final int MAX = 3;
        public CustomPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int index = position%MAX;
            switch (index) {
                case 0:
                    return ContentFragment.newInstance("Hello");
                case 1:
                    return ContentFragment.newInstance("World");
                case 2:
                    return ContentFragment.newInstance("!!!!!");
            }
            return null;
        }

        @Override
        public int getCount() {
            return 100;
        }
    }

    static class CustomPagerAdapter2 extends CustomPagerAdapter {

        List<Fragment> mFrags = new ArrayList<>();
        FragmentManager mFragMan;
        public CustomPagerAdapter2(FragmentManager fm) {
            super(fm);
            mFrags.add(ContentFragment.newInstance("Hello"));
            mFrags.add(ContentFragment.newInstance("World"));
            mFrags.add(ContentFragment.newInstance("!!!!!"));
            mFrags.add(ContentFragment.newInstance("~~~~~"));
            mFragMan = fm;
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

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            ContentFragment cf = (ContentFragment) object;
            mFragMan.beginTransaction().remove(cf).commit();
            mFrags.add(position, ContentFragment.newInstance(cf.getmParam1()));
            mFrags.remove(position + 1);
        }
    }
}
