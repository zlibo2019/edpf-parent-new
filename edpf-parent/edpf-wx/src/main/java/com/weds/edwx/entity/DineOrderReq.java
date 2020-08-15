package com.weds.edwx.entity;

import com.weds.core.base.BasePageSearch;

public class DineOrderReq extends BasePageSearch {

    private String userSerial;

    private String startDate;

    private String endDate;

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
