package com.weds.edmj.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Size;

public class RoleEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ttName;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ttOrder;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column tt_role.tt_name
     *
     * @return the value of tt_role.tt_name
     */
    public String getTtName() {
        return ttName;
    }

    /**
     */
    public RoleEntity withTtName(String ttName) {
        this.setTtName(ttName);
        return this;
    }

    /**
     * This method sets the value of the database column tt_role.tt_name
     *
     * @param ttName the value for tt_role.tt_name
     */
    public void setTtName(String ttName) {
        this.ttName = ttName;
    }

    /**
     * This method returns the value of the database column tt_role.tt_order
     *
     * @return the value of tt_role.tt_order
     */
    public String getTtOrder() {
        return ttOrder;
    }

    /**
     */
    public RoleEntity withTtOrder(String ttOrder) {
        this.setTtOrder(ttOrder);
        return this;
    }

    /**
     * This method sets the value of the database column tt_role.tt_order
     *
     * @param ttOrder the value for tt_role.tt_order
     */
    public void setTtOrder(String ttOrder) {
        this.ttOrder = ttOrder;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}