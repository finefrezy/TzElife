package com.elife.tzelife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elife.tzelife.TzElifeApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by tzhang on 2016/9/22.
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = initView(inflater);
        return mRootView;
    }

    public  abstract  void initData();
    public abstract View initView(LayoutInflater inflater);


    /**
     * 工作机制
     *
     1、RefWatcher.watch() 创建一个 KeyedWeakReference 到要被监控的对象。
     2、然后在后台线程检查引用是否被清除，如果没有，调用GC。
     3、如果引用还是未被清除，把 heap 内存 dump 到 APP 对应的文件系统中的一个 .hprof 文件中。
     4、在另外一个进程中的 HeapAnalyzerService 有一个 HeapAnalyzer 使用HAHA 解析这个文件。
     5、得益于唯一的 reference key, HeapAnalyzer 找到 KeyedWeakReference，定位内存泄露。
     6、HeapAnalyzer 计算 到 GC roots 的最短强引用路径，并确定是否是泄露。如果是的话，建立导致泄露的引用链。
     7、引用链传递到 APP 进程中的 DisplayLeakService， 并以通知的形式展示出来。
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = TzElifeApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
