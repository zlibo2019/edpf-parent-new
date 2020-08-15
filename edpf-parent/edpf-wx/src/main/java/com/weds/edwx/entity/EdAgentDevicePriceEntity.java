package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 代理商设备报备信息
 * @Date 2019-11-23
 */
public class EdAgentDevicePriceEntity extends BaseEntity implements Serializable {
    /**
     *   id
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "id")
    private String id;

    /**
     *   用户编号
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号")
    private String userSerial;

    /**
     *   公司名称
     *
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "公司名称")
    private String companyName;

    /**
     *   报备型号
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报备型号")
    private String deviceNo;

    /**
     *   报备报价
     *
     */
    @Digits(integer = 8, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "报备报价")
    private BigDecimal devicePrice;

    /**
     *   大区区域
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "大区区域")
    @Dict("09001")
    private String area;

    /**
     *   备注
     *
     */
    @Size(max = 1000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String remark;

    /**
     *   预留字段1
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     *   预留字段2
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     *   预留字段3
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol3;

    /**
     *   预留字段4
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol4;

    /**
     *   预留字段5
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol5;

    /**
     *   预留字段6
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol6;

    /**
     *   创建用户
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建用户")
    private String ctUser;

    /**
     *   创建时间
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctDate;

    /**
     *   修改用户
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改用户")
    private String ltUser;

    /**
     *   修改时间
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_agent_device_price.id
     *
     * @return the value of ed_agent_device_price.id
     */
    public String getId() {
        return id;
    }

    /**
     */
    public EdAgentDevicePriceEntity withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.id
     *
     * @param id the value for ed_agent_device_price.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.user_serial
     *
     * @return the value of ed_agent_device_price.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public EdAgentDevicePriceEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.user_serial
     *
     * @param userSerial the value for ed_agent_device_price.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.company_name
     *
     * @return the value of ed_agent_device_price.company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     */
    public EdAgentDevicePriceEntity withCompanyName(String companyName) {
        this.setCompanyName(companyName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.company_name
     *
     * @param companyName the value for ed_agent_device_price.company_name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.device_no
     *
     * @return the value of ed_agent_device_price.device_no
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     */
    public EdAgentDevicePriceEntity withDeviceNo(String deviceNo) {
        this.setDeviceNo(deviceNo);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.device_no
     *
     * @param deviceNo the value for ed_agent_device_price.device_no
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.device_price
     *
     * @return the value of ed_agent_device_price.device_price
     */
    public BigDecimal getDevicePrice() {
        return devicePrice;
    }

    /**
     */
    public EdAgentDevicePriceEntity withDevicePrice(BigDecimal devicePrice) {
        this.setDevicePrice(devicePrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.device_price
     *
     * @param devicePrice the value for ed_agent_device_price.device_price
     */
    public void setDevicePrice(BigDecimal devicePrice) {
        this.devicePrice = devicePrice;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.area
     *
     * @return the value of ed_agent_device_price.area
     */
    public String getArea() {
        return area;
    }

    /**
     */
    public EdAgentDevicePriceEntity withArea(String area) {
        this.setArea(area);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.area
     *
     * @param area the value for ed_agent_device_price.area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.remark
     *
     * @return the value of ed_agent_device_price.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdAgentDevicePriceEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.remark
     *
     * @param remark the value for ed_agent_device_price.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.spare_col1
     *
     * @return the value of ed_agent_device_price.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdAgentDevicePriceEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.spare_col1
     *
     * @param spareCol1 the value for ed_agent_device_price.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.spare_col2
     *
     * @return the value of ed_agent_device_price.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdAgentDevicePriceEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.spare_col2
     *
     * @param spareCol2 the value for ed_agent_device_price.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.spare_col3
     *
     * @return the value of ed_agent_device_price.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdAgentDevicePriceEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.spare_col3
     *
     * @param spareCol3 the value for ed_agent_device_price.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.spare_col4
     *
     * @return the value of ed_agent_device_price.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdAgentDevicePriceEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.spare_col4
     *
     * @param spareCol4 the value for ed_agent_device_price.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.spare_col5
     *
     * @return the value of ed_agent_device_price.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdAgentDevicePriceEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.spare_col5
     *
     * @param spareCol5 the value for ed_agent_device_price.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.spare_col6
     *
     * @return the value of ed_agent_device_price.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdAgentDevicePriceEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.spare_col6
     *
     * @param spareCol6 the value for ed_agent_device_price.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.ct_user
     *
     * @return the value of ed_agent_device_price.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdAgentDevicePriceEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.ct_user
     *
     * @param ctUser the value for ed_agent_device_price.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.ct_date
     *
     * @return the value of ed_agent_device_price.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdAgentDevicePriceEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.ct_date
     *
     * @param ctDate the value for ed_agent_device_price.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.lt_user
     *
     * @return the value of ed_agent_device_price.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdAgentDevicePriceEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.lt_user
     *
     * @param ltUser the value for ed_agent_device_price.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_agent_device_price.lt_date
     *
     * @return the value of ed_agent_device_price.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdAgentDevicePriceEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_agent_device_price.lt_date
     *
     * @param ltDate the value for ed_agent_device_price.lt_date
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}