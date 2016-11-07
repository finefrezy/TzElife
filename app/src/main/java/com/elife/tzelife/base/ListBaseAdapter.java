package com.elife.tzelife.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by tzhang on 2016/9/27.
 */
public abstract class ListBaseAdapter<T> extends BaseAdapter {

    public List<T> mListObject;

    public ListBaseAdapter(List<T> listObject) {
        this.mListObject = listObject;
    }

    @Override
    public int getCount() {
        if (null == mListObject) {
            return 0;
        }
        return mListObject.size();
    }

    @Override
    public Object getItem(int i) {
        return mListObject.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
