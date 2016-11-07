package com.elife.tzelife.net;

import rx.Subscriber;

/**
 * Created by tzhang on 2016/11/7.
 */
public class ProgressSubscriber<T> extends Subscriber<T> {


//    private SubscriberOnNextListener mSubscriberOnNextListener;
//    private Context context;
//
//    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context context) {
//        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
//        this.context = context;
//    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
