package com.elife.tzelife.pager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.elife.tzelife.R;
import com.elife.tzelife.base.BasePager;
import com.elife.tzelife.indicator.PagerSlidingTabStrip;
import com.elife.tzelife.model.CategoryModel;
import com.elife.tzelife.pager.homesub.NormalPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzhang on 2016/9/22.
 * http://cxg.139club.com/index.php?g=api_test&m=Item&a=getCate
 */
public class HomePager extends BasePager {

    private ViewPager mViewPager;
    private PagerSlidingTabStrip mPagerSlidingStrip;

    private List<CategoryModel> mListTitle;

    private HomePagerAdapter mHomePageAdapter;

    private List<BasePager> mSubPager;

    public HomePager(Context ctx) {
        super(ctx);
    }

    @Override
    public View initView() {
        // 解析布局获取view
        mPageRootView = View.inflate(mContex, R.layout.pager_home, null);
        mPagerSlidingStrip = (PagerSlidingTabStrip) mPageRootView.findViewById(R.id.tabs);
        mViewPager = (ViewPager) mPageRootView.findViewById(R.id.view_pager_home);
        mPagerSlidingStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mSubPager.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initTabsValue();
        initTabValue();

        return mPageRootView;
    }

    private void initTabValue() {
        mSubPager = new ArrayList<>();
        mListTitle = new ArrayList<>();
        CategoryModel cate1 = new CategoryModel(1,mContex.getResources().getString(R.string.deliver_good));
        CategoryModel cate3 = new CategoryModel(2,mContex.getResources().getString(R.string.take_deliver_good));
        CategoryModel cate2 = new CategoryModel(3,mContex.getResources().getString(R.string.storage));
        CategoryModel cate4 = new CategoryModel(4,mContex.getResources().getString(R.string.pay_order));
        CategoryModel cate5 = new CategoryModel(5,mContex.getResources().getString(R.string.take_pay_order));
        mListTitle.add(cate1);
        mListTitle.add(cate2);
        mListTitle.add(cate3);
        mListTitle.add(cate4);
        mListTitle.add(cate5);
        for(int i = 0; i < mListTitle.size(); i++) {
            NormalPager normalPager = new NormalPager(mContex, mListTitle.get(i));
            mSubPager.add(normalPager);
        }

        mHomePageAdapter = new HomePagerAdapter();
        mViewPager.setAdapter(mHomePageAdapter);
        mPagerSlidingStrip.setViewPager(mViewPager);
    }

    @Override
    public void initData() {
        mSubPager.get(0).initData();

    }

    /**
     * mPageSliding默认值配置
     */
    private void initTabsValue() {
        // 底部游标颜色
        mPagerSlidingStrip.setIndicatorColor(Color.TRANSPARENT);
        // tab的分割线颜色
        mPagerSlidingStrip.setDividerColor(Color.TRANSPARENT);
        // tab背景
        mPagerSlidingStrip.setBackgroundColor(Color.TRANSPARENT);
        // tab底线高度
        mPagerSlidingStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                1, mContex.getResources().getDisplayMetrics()));
        // 游标高度  选中时的那条线
        mPagerSlidingStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5, mContex.getResources().getDisplayMetrics()));
        mPagerSlidingStrip.setSelectedTextSize(18.0f);
        // 选中的文字颜色
        mPagerSlidingStrip.setSelectedTextColor(Color.parseColor("#80ca1a"));
        // 正常文字颜色
        mPagerSlidingStrip.setTextColor(Color.parseColor("#fcc600"));
    }

    class HomePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mSubPager.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(mSubPager.get(position).getmPageRootView());
            return mSubPager.get(position).getmPageRootView();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mListTitle.get(position).cateName;
        }
    }


}
