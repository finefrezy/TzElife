package com.elife.tzelife.pager.homesub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.elife.tzelife.R;
import com.elife.tzelife.adapter.NormalPagerAdapter;
import com.elife.tzelife.base.BasePager;
import com.elife.tzelife.model.CategoryModel;
import com.elife.tzelife.model.OrderModel;
import com.elife.tzelife.net.RxJavaApply;
import com.elife.tzelife.space.SpacesItemDecoration;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by tzhang on 2016/9/26.
 */
public class NormalPager extends BasePager {

    private static final String TAG = NormalPager.class.getSimpleName();

    private static final int PAGE_SIZE= 20;

    private RecyclerView mRecyclerView;
    private CategoryModel mCategoryModel;
    private NormalPagerAdapter normalPagerAdapter;
    ;
    // 程序中全局/成员变量的变化过程，实例存在，他就存在
    private int mCurrPage = 1;
    private int mTotalPage = 0;
    private ArrayList<OrderModel> mListDelivery;

    public NormalPager(Context context, CategoryModel categoryModel) {
        super(context);
        this.mCategoryModel = categoryModel;
    }

    @Override
    public View initView() {
        mPageRootView = View.inflate(mContex, R.layout.pager_normal, null);
        mRecyclerView = (RecyclerView) mPageRootView.findViewById(R.id.normal_recycler);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(6);
        mRecyclerView.addItemDecoration(decoration);

        mListDelivery = new ArrayList<OrderModel>();

        normalPagerAdapter = new NormalPagerAdapter(mContex, mListDelivery);
        mRecyclerView.setAdapter(normalPagerAdapter);

        normalPagerAdapter.setOnItemClickListener(new NormalPagerAdapter.IOnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
            }
        });
        return mPageRootView;
    }



    @Override
    public void initData() {
        Subscriber<OrderModel> subscriber = new Subscriber<OrderModel>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onNext(OrderModel responseBody) {
                Log.e(TAG, "onNext-》" + responseBody.getTotal());

            }
        };
        switch (mCategoryModel.cateId) {
            case 1:
                RxJavaApply.getInstance().outBillList(subscriber,mCurrPage, PAGE_SIZE );
                break;
            case 2:
                RxJavaApply.getInstance().inBillList(subscriber,mCurrPage, PAGE_SIZE );
                break;
            case 3:
                RxJavaApply.getInstance().invList(subscriber,mCurrPage, PAGE_SIZE );
                break;
            case 4:
                break;
            case 5:
                break;

        }
    }
}
