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
 * @Description 消息函数管理
 * @Date 2019-04-03
 */

/**
 * @Author
 * @Description 消息函数管理
 * @Date 2019-04-03
 */
public class MsgFunctionEntity extends BaseEntity implements Serializable {
    /**
     * 函数ID#1#1###
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "函数ID#1#1###")
    private String functionId;

    /**
     * 函数描述#1#1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "函数描述#1#1###")
    private String functionDesc;

    /**
     * 函数名#1#1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "函数名#1#1###")
    private String functionName;

    /**
     * 函数内容##1###
     */
    @Size(max = 4000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "函数内容##1###")
    private String functionContent;

    /**
     * 函数类型#1#1##9#01007
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "函数类型#1#1##9#01007")
    @Dict("01007")
    private String functionType;

    /**
     * 是否启用#1#1##9#01001
     */
    @Size(max = 10)
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用#1#1##9#01001")
    private String useFlg;

    /**
     * 函数备注##1##1#
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "函数备注##1##1#")
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
     * This method returns the value of the database column MSG_FUNCTION.FUNCTION_ID
     *
     * @return the value of MSG_FUNCTION.FUNCTION_ID
     */
    public String getFunctionId() {
        return functionId;
    }

    /**
     */
    public MsgFunctionEntity withFunctionId(String functionId) {
        this.setFunctionId(functionId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.FUNCTION_ID
     *
     * @param functionId the value for MSG_FUNCTION.FUNCTION_ID
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.FUNCTION_DESC
     *
     * @return the value of MSG_FUNCTION.FUNCTION_DESC
     */
    public String getFunctionDesc() {
        return functionDesc;
    }

    /**
     */
    public MsgFunctionEntity withFunctionDesc(String functionDesc) {
        this.setFunctionDesc(functionDesc);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.FUNCTION_DESC
     *
     * @param functionDesc the value for MSG_FUNCTION.FUNCTION_DESC
     */
    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.FUNCTION_NAME
     *
     * @return the value of MSG_FUNCTION.FUNCTION_NAME
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     */
    public MsgFunctionEntity withFunctionName(String functionName) {
        this.setFunctionName(functionName);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.FUNCTION_NAME
     *
     * @param functionName the value for MSG_FUNCTION.FUNCTION_NAME
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.FUNCTION_CONTENT
     *
     * @return the value of MSG_FUNCTION.FUNCTION_CONTENT
     */
    public String getFunctionContent() {
        return functionContent;
    }

    /**
     */
    public MsgFunctionEntity withFunctionContent(String functionContent) {
        this.setFunctionContent(functionContent);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.FUNCTION_CONTENT
     *
     * @param functionContent the value for MSG_FUNCTION.FUNCTION_CONTENT
     */
    public void setFunctionContent(String functionContent) {
        this.functionContent = functionContent;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.FUNCTION_TYPE
     *
     * @return the value of MSG_FUNCTION.FUNCTION_TYPE
     */
    public String getFunctionType() {
        return functionType;
    }

    /**
     */
    public MsgFunctionEntity withFunctionType(String functionType) {
        this.setFunctionType(functionType);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.FUNCTION_TYPE
     *
     * @param functionType the value for MSG_FUNCTION.FUNCTION_TYPE
     */
    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.USE_FLG
     *
     * @return the value of MSG_FUNCTION.USE_FLG
     */
    public String getUseFlg() {
        return useFlg;
    }

    /**
     */
    public MsgFunctionEntity withUseFlg(String useFlg) {
        this.setUseFlg(useFlg);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.USE_FLG
     *
     * @param useFlg the value for MSG_FUNCTION.USE_FLG
     */
    public void setUseFlg(String useFlg) {
        this.useFlg = useFlg;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.REMARK
     *
     * @return the value of MSG_FUNCTION.REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public MsgFunctionEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.REMARK
     *
     * @param remark the value for MSG_FUNCTION.REMARK
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.SPARE_COL1
     *
     * @return the value of MSG_FUNCTION.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public MsgFunctionEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.SPARE_COL1
     *
     * @param spareCol1 the value for MSG_FUNCTION.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.SPARE_COL2
     *
     * @return the value of MSG_FUNCTION.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public MsgFunctionEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.SPARE_COL2
     *
     * @param spareCol2 the value for MSG_FUNCTION.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.SPARE_COL3
     *
     * @return the value of MSG_FUNCTION.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public MsgFunctionEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.SPARE_COL3
     *
     * @param spareCol3 the value for MSG_FUNCTION.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.CT_USER
     *
     * @return the value of MSG_FUNCTION.CT_USER
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public MsgFunctionEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.CT_USER
     *
     * @param ctUser the value for MSG_FUNCTION.CT_USER
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.CT_DATE
     *
     * @return the value of MSG_FUNCTION.CT_DATE
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public MsgFunctionEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.CT_DATE
     *
     * @param ctDate the value for MSG_FUNCTION.CT_DATE
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.LT_USER_ID
     *
     * @return the value of MSG_FUNCTION.LT_USER_ID
     */
    public String getLtUserId() {
        return ltUserId;
    }

    /**
     */
    public MsgFunctionEntity withLtUserId(String ltUserId) {
        this.setLtUserId(ltUserId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.LT_USER_ID
     *
     * @param ltUserId the value for MSG_FUNCTION.LT_USER_ID
     */
    public void setLtUserId(String ltUserId) {
        this.ltUserId = ltUserId;
    }

    /**
     * This method returns the value of the database column MSG_FUNCTION.LT_DATE
     *
     * @return the value of MSG_FUNCTION.LT_DATE
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public MsgFunctionEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_FUNCTION.LT_DATE
     *
     * @param ltDate the value for MSG_FUNCTION.LT_DATE
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