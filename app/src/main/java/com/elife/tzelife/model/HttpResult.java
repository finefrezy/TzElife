package com.elife.tzelife.model;

/**
 * Created by tzhang on 2016/11/1.
 */
public class HttpResult<T> {
    private String resultCode;
    private String resultMessage;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
