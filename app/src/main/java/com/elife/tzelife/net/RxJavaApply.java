package com.elife.tzelife.net;

import com.elife.tzelife.model.OrderModel;

import java.util.HashMap;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tzhang on 2016/11/1.
 */
public class RxJavaApply {

    //获取单例
    public static RxJavaApply getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getList(Subscriber<ResponseBody> subscriber) {
        RetrofitService retrofitService = RetrofitClient.getClient();
        retrofitService.getList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void login(Subscriber<HashMap<String, String>> subscriber, String userName, String password) {
        RetrofitService retrofitService = RetrofitClient.getClient();
        retrofitService.login(userName, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 入库订单明细
     *
     * @param subscriber
     * @param page
     * @param rows
     */
    public void inBillList(Subscriber<OrderModel> subscriber, int page, int rows) {
        RetrofitService retrofitService = RetrofitClient.getClient();
        retrofitService.inBillList(page, rows).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 出库订单明细
     *
     * @param subscriber
     * @param page
     * @param rows
     */
    public void outBillList(Subscriber<OrderModel> subscriber, int page, int rows) {
        RetrofitService retrofitService = RetrofitClient.getClient();
        retrofitService.outBillList(page, rows).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 库存汇总
     *
     * @param subscriber
     * @param page
     * @param rows
     */
    public void invList(Subscriber<OrderModel> subscriber, int page, int rows) {
        RetrofitService retrofitService = RetrofitClient.getClient();
        retrofitService.invList(page, rows).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RxJavaApply INSTANCE = new RxJavaApply();
    }
}
