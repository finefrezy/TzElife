package com.elife.tzelife.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elife.tzelife.R;
import com.elife.tzelife.base.BaseFragment;
import com.elife.tzelife.net.RxJavaApply;
import com.elife.tzelife.pager.HomePager;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    public static final String TAG = MainFragment.class.getSimpleName();

    @BindView(R.id.page_content)
    LinearLayout pageContent;

    private HomePager mHomePager;

    // View的初始化  onCreateView
    @Override
    public View initView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_main, null);

        pageContent = (LinearLayout) mRootView.findViewById(R.id.page_content);
        mHomePager = new HomePager(getActivity());

        pageContent.addView(mHomePager.getmPageRootView());
        mHomePager.initData();

        return mRootView;
    }

    @Override
    public void initData() {
        Subscriber<ResponseBody> subscriber = new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                Log.e("------------", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("------------", e.getMessage());
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    Log.e("------------", responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        RxJavaApply.getInstance().getList(subscriber);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
