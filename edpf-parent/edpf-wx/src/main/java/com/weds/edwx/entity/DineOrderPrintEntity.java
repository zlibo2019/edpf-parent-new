package com.weds.edwx.entity;

import java.util.List;

public class DineOrderPrintEntity {
    private String title;
    private String mealName;
    private String orderDate;
    private String sendAddr;
    private String sendTime;
    private boolean sendFlag;
    private List<EdDineOrderDetailEntity> list;
    private String orderPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public boolean isSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(boolean sendFlag) {
        this.sendFlag = sendFlag;
    }

    public List<EdDineOrderDetailEntity> getList() {
        return list;
    }

    public void setList(List<EdDineOrderDetailEntity> list) {
        this.list = list;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }
}
