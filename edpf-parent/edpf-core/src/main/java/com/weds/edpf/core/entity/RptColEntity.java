package com.weds.edpf.core.entity;

import java.util.List;

public class RptColEntity {

    private String prop;
    private String label;
    private String width;
    private String align;
    private String headerAlign;
    private String formatter;
    private List<RptColEntity> child;

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getHeaderAlign() {
        return headerAlign;
    }

    public void setHeaderAlign(String headerAlign) {
        this.headerAlign = headerAlign;
    }

    public List<RptColEntity> getChild() {
        return child;
    }

    public void setChild(List<RptColEntity> child) {
        this.child = child;
    }
}
