package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 消息参数管理
 * @Date 2019-04-03
 */

/**
 * @Author
 * @Description 消息参数管理
 * @Date 2019-04-03
 */
public class MsgParamsEntity extends BaseEntity implements Serializable {
    /**
     * 参数ID#1#1###
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数ID#1#1###")
    private String paramId;

    /**
     * 模板ID##1###
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "模板ID##1###")
    private String templateId;

    /**
     * 参数名称#1#1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数名称#1#1###")
    private String paramName;

    /**
     * 参数值#1#1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数值#1#1###")
    private String paramValue;

    /**
     * 预留字段1#1#1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1#1#1###")
    private String spareCol1;

    /**
     * 预留字段2#1#1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2#1#1###")
    private String spareCol2;

    /**
     * 预留字段3##1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3##1###")
    private String spareCol3;

    /**
     * 创建者
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建者")
    private String ctUser;

    /**
     * 创建时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    private Date ctDate;

    /**
     * 修改者
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改者")
    private String ltUserId;

    /**
     * 修改时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column MSG_PARAMS.PARAM_ID
     *
     * @return the value of MSG_PARAMS.PARAM_ID
     */
    public String getParamId() {
        return paramId;
    }

    /**
     */
    public MsgParamsEntity withParamId(String paramId) {
        this.setParamId(paramId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.PARAM_ID
     *
     * @param paramId the value for MSG_PARAMS.PARAM_ID
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.TEMPLATE_ID
     *
     * @return the value of MSG_PARAMS.TEMPLATE_ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     */
    public MsgParamsEntity withTemplateId(String templateId) {
        this.setTemplateId(templateId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.TEMPLATE_ID
     *
     * @param templateId the value for MSG_PARAMS.TEMPLATE_ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.PARAM_NAME
     *
     * @return the value of MSG_PARAMS.PARAM_NAME
     */
    public String getParamName() {
        return paramName;
    }

    /**
     */
    public MsgParamsEntity withParamName(String paramName) {
        this.setParamName(paramName);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.PARAM_NAME
     *
     * @param paramName the value for MSG_PARAMS.PARAM_NAME
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.PARAM_VALUE
     *
     * @return the value of MSG_PARAMS.PARAM_VALUE
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     */
    public MsgParamsEntity withParamValue(String paramValue) {
        this.setParamValue(paramValue);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.PARAM_VALUE
     *
     * @param paramValue the value for MSG_PARAMS.PARAM_VALUE
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.SPARE_COL1
     *
     * @return the value of MSG_PARAMS.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public MsgParamsEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.SPARE_COL1
     *
     * @param spareCol1 the value for MSG_PARAMS.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.SPARE_COL2
     *
     * @return the value of MSG_PARAMS.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public MsgParamsEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.SPARE_COL2
     *
     * @param spareCol2 the value for MSG_PARAMS.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.SPARE_COL3
     *
     * @return the value of MSG_PARAMS.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public MsgParamsEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.SPARE_COL3
     *
     * @param spareCol3 the value for MSG_PARAMS.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.CT_USER
     *
     * @return the value of MSG_PARAMS.CT_USER
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public MsgParamsEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.CT_USER
     *
     * @param ctUser the value for MSG_PARAMS.CT_USER
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.CT_DATE
     *
     * @return the value of MSG_PARAMS.CT_DATE
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public MsgParamsEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.CT_DATE
     *
     * @param ctDate the value for MSG_PARAMS.CT_DATE
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.LT_USER_ID
     *
     * @return the value of MSG_PARAMS.LT_USER_ID
     */
    public String getLtUserId() {
        return ltUserId;
    }

    /**
     */
    public MsgParamsEntity withLtUserId(String ltUserId) {
        this.setLtUserId(ltUserId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.LT_USER_ID
     *
     * @param ltUserId the value for MSG_PARAMS.LT_USER_ID
     */
    public void setLtUserId(String ltUserId) {
        this.ltUserId = ltUserId;
    }

    /**
     * This method returns the value of the database column MSG_PARAMS.LT_DATE
     *
     * @return the value of MSG_PARAMS.LT_DATE
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public MsgParamsEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_PARAMS.LT_DATE
     *
     * @param ltDate the value for MSG_PARAMS.LT_DATE
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