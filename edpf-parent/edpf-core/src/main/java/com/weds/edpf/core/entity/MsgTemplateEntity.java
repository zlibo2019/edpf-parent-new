package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 消息模板管理
 * @Date 2019-04-03
 */

/**
 * @Author
 * @Description 消息模板管理
 * @Date 2019-04-03
 */
public class MsgTemplateEntity extends BaseEntity implements Serializable {
    /**
     * 模板ID#1#1###
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "模板ID#1#1###")
    private String templateId;

    /**
     * 模板名称#1#1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "模板名称#1#1###")
    private String templateName;

    /**
     * 模板内容#1#1###
     */
    @Size(max = 2000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "模板内容#1#1###")
    private String templateContent;

    /**
     * 模板类型#1#1##9#01006
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "模板类型#1#1##9#01006")
    @Dict("01006")
    private String msgType;

    /**
     * 是否启用#1#1##9#01001
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用#1#1##9#01001")
    @Dict("01001")
    private String useFlg;

    /**
     * 模板备注##1##1#
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "模板备注##1##1#")
    private String remark;

    /**
     * 预留字段1
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
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
     * This method returns the value of the database column MSG_TEMPLATE.TEMPLATE_ID
     *
     * @return the value of MSG_TEMPLATE.TEMPLATE_ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     */
    public MsgTemplateEntity withTemplateId(String templateId) {
        this.setTemplateId(templateId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.TEMPLATE_ID
     *
     * @param templateId the value for MSG_TEMPLATE.TEMPLATE_ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.TEMPLATE_NAME
     *
     * @return the value of MSG_TEMPLATE.TEMPLATE_NAME
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     */
    public MsgTemplateEntity withTemplateName(String templateName) {
        this.setTemplateName(templateName);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.TEMPLATE_NAME
     *
     * @param templateName the value for MSG_TEMPLATE.TEMPLATE_NAME
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.TEMPLATE_CONTENT
     *
     * @return the value of MSG_TEMPLATE.TEMPLATE_CONTENT
     */
    public String getTemplateContent() {
        return templateContent;
    }

    /**
     */
    public MsgTemplateEntity withTemplateContent(String templateContent) {
        this.setTemplateContent(templateContent);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.TEMPLATE_CONTENT
     *
     * @param templateContent the value for MSG_TEMPLATE.TEMPLATE_CONTENT
     */
    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.MSG_TYPE
     *
     * @return the value of MSG_TEMPLATE.MSG_TYPE
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     */
    public MsgTemplateEntity withMsgType(String msgType) {
        this.setMsgType(msgType);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.MSG_TYPE
     *
     * @param msgType the value for MSG_TEMPLATE.MSG_TYPE
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.USE_FLG
     *
     * @return the value of MSG_TEMPLATE.USE_FLG
     */
    public String getUseFlg() {
        return useFlg;
    }

    /**
     */
    public MsgTemplateEntity withUseFlg(String useFlg) {
        this.setUseFlg(useFlg);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.USE_FLG
     *
     * @param useFlg the value for MSG_TEMPLATE.USE_FLG
     */
    public void setUseFlg(String useFlg) {
        this.useFlg = useFlg;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.REMARK
     *
     * @return the value of MSG_TEMPLATE.REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public MsgTemplateEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.REMARK
     *
     * @param remark the value for MSG_TEMPLATE.REMARK
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.SPARE_COL1
     *
     * @return the value of MSG_TEMPLATE.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public MsgTemplateEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.SPARE_COL1
     *
     * @param spareCol1 the value for MSG_TEMPLATE.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.SPARE_COL2
     *
     * @return the value of MSG_TEMPLATE.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public MsgTemplateEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.SPARE_COL2
     *
     * @param spareCol2 the value for MSG_TEMPLATE.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.SPARE_COL3
     *
     * @return the value of MSG_TEMPLATE.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public MsgTemplateEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.SPARE_COL3
     *
     * @param spareCol3 the value for MSG_TEMPLATE.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.CT_USER
     *
     * @return the value of MSG_TEMPLATE.CT_USER
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public MsgTemplateEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.CT_USER
     *
     * @param ctUser the value for MSG_TEMPLATE.CT_USER
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.CT_DATE
     *
     * @return the value of MSG_TEMPLATE.CT_DATE
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public MsgTemplateEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.CT_DATE
     *
     * @param ctDate the value for MSG_TEMPLATE.CT_DATE
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.LT_USER_ID
     *
     * @return the value of MSG_TEMPLATE.LT_USER_ID
     */
    public String getLtUserId() {
        return ltUserId;
    }

    /**
     */
    public MsgTemplateEntity withLtUserId(String ltUserId) {
        this.setLtUserId(ltUserId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.LT_USER_ID
     *
     * @param ltUserId the value for MSG_TEMPLATE.LT_USER_ID
     */
    public void setLtUserId(String ltUserId) {
        this.ltUserId = ltUserId;
    }

    /**
     * This method returns the value of the database column MSG_TEMPLATE.LT_DATE
     *
     * @return the value of MSG_TEMPLATE.LT_DATE
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public MsgTemplateEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_TEMPLATE.LT_DATE
     *
     * @param ltDate the value for MSG_TEMPLATE.LT_DATE
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