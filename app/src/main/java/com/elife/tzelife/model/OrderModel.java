package com.elife.tzelife.model;

import java.util.List;

/**
 * Created by tzhang on 2016/10/24.
 */
public class OrderModel {


    /**
     * total : 7
     * rows : [{"typeName":"饮料","typeCode":"100100","billId":102,"amount":100,"totalPrice":8800,"productId":102,"price":88,"disable":0,"productName":"红牛","des":"","billNo":"20161019143050","realMoney":0,"realAmount":100,"realPrice":88,"id":106,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 15:00:37","updater":null,"updateTime":null},{"typeName":"饮料","typeCode":"100100","billId":102,"amount":100,"totalPrice":990,"productId":100,"price":9.9,"disable":0,"productName":"雪碧330","des":"","billNo":"20161019143050","realMoney":0,"realAmount":100,"realPrice":9.9,"id":105,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 14:57:08","updater":null,"updateTime":null},{"typeName":"酒","typeCode":"100200","billId":100,"amount":50,"totalPrice":5000,"productId":104,"price":100,"disable":0,"productName":"海之蓝","des":"","billNo":"20161019131102","realMoney":0,"realAmount":50,"realPrice":100,"id":104,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 13:12:11","updater":null,"updateTime":null},{"typeName":"香烟","typeCode":"100300","billId":100,"amount":100,"totalPrice":10000,"productId":103,"price":100,"disable":0,"productName":"中华","des":"","billNo":"20161019131102","realMoney":0,"realAmount":100,"realPrice":100,"id":103,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 13:11:56","updater":null,"updateTime":null},{"typeName":"饮料","typeCode":"100100","billId":100,"amount":200,"totalPrice":17600,"productId":102,"price":88,"disable":0,"productName":"红牛","des":"","billNo":"20161019131102","realMoney":0,"realAmount":200,"realPrice":88,"id":102,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 13:11:45","updater":null,"updateTime":null},{"typeName":"饮料","typeCode":"100100","billId":100,"amount":200,"totalPrice":1980,"productId":101,"price":9.9,"disable":0,"productName":"可乐330","des":"","billNo":"20161019131102","realMoney":0,"realAmount":200,"realPrice":9.9,"id":101,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 13:11:32","updater":null,"updateTime":null},{"typeName":"饮料","typeCode":"100100","billId":100,"amount":200,"totalPrice":1980,"productId":100,"price":9.9,"disable":0,"productName":"雪碧330","des":"","billNo":"20161019131102","realMoney":0,"realAmount":200,"realPrice":9.9,"id":100,"left":null,"right":null,"creater":null,"createTime":"2016-10-19 13:11:18","updater":null,"updateTime":null}]
     */

    private int total;
    /**
     * typeName : 饮料
     * typeCode : 100100
     * billId : 102
     * amount : 100.0
     * totalPrice : 8800.0
     * productId : 102
     * price : 88.0
     * disable : 0
     * productName : 红牛
     * des :
     * billNo : 20161019143050
     * realMoney : 0.0
     * realAmount : 100.0
     * realPrice : 88.0
     * id : 106
     * left : null
     * right : null
     * creater : null
     * createTime : 2016-10-19 15:00:37
     * updater : null
     * updateTime : null
     */

    private List<GoodOrderBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<GoodOrderBean> getRows() {
        return rows;
    }

    public void setRows(List<GoodOrderBean> rows) {
        this.rows = rows;
    }

    public static class GoodOrderBean {
        private String typeName;
        private String typeCode;
        private int billId;
        private double amount;
        private double totalPrice;
        private int productId;
        private double price;
        private int disable;
        private String productName;
        private String des;
        private String billNo;
        private double realMoney;
        private double realAmount;
        private double realPrice;
        private int id;
        private Object left;
        private Object right;
        private Object creater;
        private String createTime;
        private Object updater;
        private Object updateTime;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public int getBillId() {
            return billId;
        }

        public void setBillId(int billId) {
            this.billId = billId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getDisable() {
            return disable;
        }

        public void setDisable(int disable) {
            this.disable = disable;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getBillNo() {
            return billNo;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public double getRealMoney() {
            return realMoney;
        }

        public void setRealMoney(double realMoney) {
            this.realMoney = realMoney;
        }

        public double getRealAmount() {
            return realAmount;
        }

        public void setRealAmount(double realAmount) {
            this.realAmount = realAmount;
        }

        public double getRealPrice() {
            return realPrice;
        }

        public void setRealPrice(double realPrice) {
            this.realPrice = realPrice;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getLeft() {
            return left;
        }

        public void setLeft(Object left) {
            this.left = left;
        }

        public Object getRight() {
            return right;
        }

        public void setRight(Object right) {
            this.right = right;
        }

        public Object getCreater() {
            return creater;
        }

        public void setCreater(Object creater) {
            this.creater = creater;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdater() {
            return updater;
        }

        public void setUpdater(Object updater) {
            this.updater = updater;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }
    }
}
