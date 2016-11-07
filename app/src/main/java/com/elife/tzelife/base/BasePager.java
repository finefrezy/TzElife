package com.elife.tzelife.base;

import android.content.Context;
import android.view.View;

/**
 * Created by tzhang on 2016/9/22.
 */
public abstract class BasePager {

    protected View mPageRootView;
    protected Context mContex;


    public BasePager(Context context) {
        this.mContex = context;
        mPageRootView = initView();
    }

    public abstract View initView();

    public abstract void initData();

    public View getmPageRootView() {
        return mPageRootView;
    }

    public void setmPageRootView(View mPageRootView) {
        this.mPageRootView = mPageRootView;
    }
}
