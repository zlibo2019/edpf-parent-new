package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class TtSexEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @Size(max = 5)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Short ttOrder;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ttName;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column tt_sex.tt_order
     *
     * @return the value of tt_sex.tt_order
     */
    public Short getTtOrder() {
        return ttOrder;
    }

    /**
     */
    public TtSexEntity withTtOrder(Short ttOrder) {
        this.setTtOrder(ttOrder);
        return this;
    }

    /**
     * This method sets the value of the database column tt_sex.tt_order
     *
     * @param ttOrder the value for tt_sex.tt_order
     */
    public void setTtOrder(Short ttOrder) {
        this.ttOrder = ttOrder;
    }

    /**
     * This method returns the value of the database column tt_sex.tt_name
     *
     * @return the value of tt_sex.tt_name
     */
    public String getTtName() {
        return ttName;
    }

    /**
     */
    public TtSexEntity withTtName(String ttName) {
        this.setTtName(ttName);
        return this;
    }

    /**
     * This method sets the value of the database column tt_sex.tt_name
     *
     * @param ttName the value for tt_sex.tt_name
     */
    public void setTtName(String ttName) {
        this.ttName = ttName;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}