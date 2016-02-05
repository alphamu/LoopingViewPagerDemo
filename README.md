# LoopingViewPagerDemo
A demo app for trying to implement a looping ViewPager with a page indicator.
The demo shows how a ViewPager can implement infinite looping either by creating new fragments all the time, 
or by using FragmentStatePagerAdapter with at least 4 Fragment.

# About this code

You can read all about this code and why I wrote it on my medium blog.
[Looping/infinite ViewPager with ViewPagerIndicator](https://medium.com/@ali.muzaffar/looping-infinite-viewpager-with-page-indicator-in-android-ce741f25702a)

Note: If you're willing to hack it a bit, you can probably use one or two fragments as well. 

## Using [ViewPagerIndicator](https://github.com/JakeWharton/ViewPagerIndicator) by Jake Wharton

The library adds a `LoopingCirclePageIndicator` and a `LoopingLinePageIndicator` to the ViewPagerIndicator 
library that is included in the project in order to implement infinite looping using `ViewPagerIndicator`.
In order to use them, you have to `implement LoopingPagerAdapter` on your `FragmentPagerAdapter` or `FragmentStatePagerAdapter` which 
adds a `getRealCount()` method which is used to return the real number of pages. The `getCount()` method in your adpater can be 
set to a really large number or simply `Integer.MAX_INT`.

Note: If you have fewer than 4 fragments, and want to use FragmentStatePagerAdapter approach, you can probably get away 
with hardcoding getRealCount() to 2 or 3 and creating duplicates of all the fragments.

![Looping with ViewPagerIndicator](http://i.giphy.com/e5D7Yt2CBiFm8.gif)

## Custom approach

The demo demostrates how one can create their own Page indictors.

![Looping with Custom Page Indicator](http://i.giphy.com/13g5uRubiIcL5K.gif)


