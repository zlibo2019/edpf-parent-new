package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class JrealUpdate0Entity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jsig;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jdevId;

    /**
     *
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jdevBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jdodata;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer juserId;

    /**
     *
     */
    @Size(max = 1000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jdataStr;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jextType;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-31 09:12:43", value = "")
    private Date jtime;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String joperator;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jipAddr;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column jreal_update_0.jsig
     *
     * @return the value of jreal_update_0.jsig
     */
    public Integer getJsig() {
        return jsig;
    }

    /**
     */
    public JrealUpdate0Entity withJsig(Integer jsig) {
        this.setJsig(jsig);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jsig
     *
     * @param jsig the value for jreal_update_0.jsig
     */
    public void setJsig(Integer jsig) {
        this.jsig = jsig;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jdev_id
     *
     * @return the value of jreal_update_0.jdev_id
     */
    public Integer getJdevId() {
        return jdevId;
    }

    /**
     */
    public JrealUpdate0Entity withJdevId(Integer jdevId) {
        this.setJdevId(jdevId);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jdev_id
     *
     * @param jdevId the value for jreal_update_0.jdev_id
     */
    public void setJdevId(Integer jdevId) {
        this.jdevId = jdevId;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jdev_bh
     *
     * @return the value of jreal_update_0.jdev_bh
     */
    public String getJdevBh() {
        return jdevBh;
    }

    /**
     */
    public JrealUpdate0Entity withJdevBh(String jdevBh) {
        this.setJdevBh(jdevBh);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jdev_bh
     *
     * @param jdevBh the value for jreal_update_0.jdev_bh
     */
    public void setJdevBh(String jdevBh) {
        this.jdevBh = jdevBh;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jdodata
     *
     * @return the value of jreal_update_0.jdodata
     */
    public Integer getJdodata() {
        return jdodata;
    }

    /**
     */
    public JrealUpdate0Entity withJdodata(Integer jdodata) {
        this.setJdodata(jdodata);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jdodata
     *
     * @param jdodata the value for jreal_update_0.jdodata
     */
    public void setJdodata(Integer jdodata) {
        this.jdodata = jdodata;
    }

    /**
     * This method returns the value of the database column jreal_update_0.juser_id
     *
     * @return the value of jreal_update_0.juser_id
     */
    public Integer getJuserId() {
        return juserId;
    }

    /**
     */
    public JrealUpdate0Entity withJuserId(Integer juserId) {
        this.setJuserId(juserId);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.juser_id
     *
     * @param juserId the value for jreal_update_0.juser_id
     */
    public void setJuserId(Integer juserId) {
        this.juserId = juserId;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jdata_str
     *
     * @return the value of jreal_update_0.jdata_str
     */
    public String getJdataStr() {
        return jdataStr;
    }

    /**
     */
    public JrealUpdate0Entity withJdataStr(String jdataStr) {
        this.setJdataStr(jdataStr);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jdata_str
     *
     * @param jdataStr the value for jreal_update_0.jdata_str
     */
    public void setJdataStr(String jdataStr) {
        this.jdataStr = jdataStr;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jext_type
     *
     * @return the value of jreal_update_0.jext_type
     */
    public Integer getJextType() {
        return jextType;
    }

    /**
     */
    public JrealUpdate0Entity withJextType(Integer jextType) {
        this.setJextType(jextType);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jext_type
     *
     * @param jextType the value for jreal_update_0.jext_type
     */
    public void setJextType(Integer jextType) {
        this.jextType = jextType;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jtime
     *
     * @return the value of jreal_update_0.jtime
     */
    public Date getJtime() {
        return jtime;
    }

    /**
     */
    public JrealUpdate0Entity withJtime(Date jtime) {
        this.setJtime(jtime);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jtime
     *
     * @param jtime the value for jreal_update_0.jtime
     */
    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }

    /**
     * This method returns the value of the database column jreal_update_0.joperator
     *
     * @return the value of jreal_update_0.joperator
     */
    public String getJoperator() {
        return joperator;
    }

    /**
     */
    public JrealUpdate0Entity withJoperator(String joperator) {
        this.setJoperator(joperator);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.joperator
     *
     * @param joperator the value for jreal_update_0.joperator
     */
    public void setJoperator(String joperator) {
        this.joperator = joperator;
    }

    /**
     * This method returns the value of the database column jreal_update_0.jip_addr
     *
     * @return the value of jreal_update_0.jip_addr
     */
    public String getJipAddr() {
        return jipAddr;
    }

    /**
     */
    public JrealUpdate0Entity withJipAddr(String jipAddr) {
        this.setJipAddr(jipAddr);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_update_0.jip_addr
     *
     * @param jipAddr the value for jreal_update_0.jip_addr
     */
    public void setJipAddr(String jipAddr) {
        this.jipAddr = jipAddr;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}