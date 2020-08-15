package com.weds.edwx.entity;

import java.util.List;

public class DineOrderListResp {
    private String orderDate;

    private List<EdDineOrderEntity> list;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<EdDineOrderEntity> getList() {
        return list;
    }

    public void setList(List<EdDineOrderEntity> list) {
        this.list = list;
    }
}
