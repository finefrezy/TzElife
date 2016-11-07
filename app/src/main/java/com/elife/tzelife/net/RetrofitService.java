package com.elife.tzelife.net;

import com.elife.tzelife.model.OrderModel;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by tzhang on 2016/9/23.
 */
public interface RetrofitService {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Observable<ResponseBody> loginUser1(@Field("username") String username, @Field("password") String password);


    @POST("list")
    Observable<ResponseBody> getList();

    @FormUrlEncoded
    @POST("login")
    Observable<HashMap<String, String>> login(@Field("username") String userName, @Field("password") String password);

    @POST
    Observable<OrderModel> inBillList();

    /**
     *
     * @param page
     *   默认  1
     * @return
     */
    @FormUrlEncoded
    @POST("inBillList")
    Observable<OrderModel> inBillList(@Field("page") int page);

    /**
     *
     * @param page
     *   默认  1
     * @param rows
     *   默认  20
     * @return
     */
    @FormUrlEncoded
    @POST("inBillList")
    Observable<OrderModel> inBillList(@Field("page") int page, @Field("rows") int rows);

    @FormUrlEncoded
    @POST("outBillList")
    Observable<OrderModel> outBillList(@Field("page") int page, @Field("rows") int rows);
    @FormUrlEncoded
    @POST("invList")
    Observable<OrderModel> invList(@Field("page") int page, @Field("rows") int rows);

// productName 单号  billNo  类型  typeCode
//@FormUrlEncoded
//@POST("inBillList")
//Observable<DeliveryOrderModel> inBillList(@Field("productName") String productName);

}
