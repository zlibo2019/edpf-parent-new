package com.weds.edpf.core.entity;

import com.weds.core.base.BaseEntity;

import java.util.List;

public class ExportRptEntity extends BaseEntity {
    private String rptTitle;

    private List<RptColEntity> colList;

    public String getRptTitle() {
        return rptTitle;
    }

    public void setRptTitle(String rptTitle) {
        this.rptTitle = rptTitle;
    }

    public List<RptColEntity> getColList() {
        return colList;
    }

    public void setColList(List<RptColEntity> colList) {
        this.colList = colList;
    }
}
