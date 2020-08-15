package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class RepairTypeParamEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String companyId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String typeId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String typeName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer typeIndex;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String useFlag;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String remark;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String spareCol1;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String spareCol2;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String spareCol3;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String ctUser;

    /**
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Date ctDate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String ltUser;

    /**
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.COMPANY_ID
     *
     * @return the value of REPAIR_TYPE_PARAM.COMPANY_ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     */
    public RepairTypeParamEntity withCompanyId(String companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.COMPANY_ID
     *
     * @param companyId the value for REPAIR_TYPE_PARAM.COMPANY_ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.TYPE_ID
     *
     * @return the value of REPAIR_TYPE_PARAM.TYPE_ID
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     */
    public RepairTypeParamEntity withTypeId(String typeId) {
        this.setTypeId(typeId);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.TYPE_ID
     *
     * @param typeId the value for REPAIR_TYPE_PARAM.TYPE_ID
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.TYPE_NAME
     *
     * @return the value of REPAIR_TYPE_PARAM.TYPE_NAME
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     */
    public RepairTypeParamEntity withTypeName(String typeName) {
        this.setTypeName(typeName);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.TYPE_NAME
     *
     * @param typeName the value for REPAIR_TYPE_PARAM.TYPE_NAME
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.TYPE_INDEX
     *
     * @return the value of REPAIR_TYPE_PARAM.TYPE_INDEX
     */
    public Integer getTypeIndex() {
        return typeIndex;
    }

    /**
     */
    public RepairTypeParamEntity withTypeIndex(Integer typeIndex) {
        this.setTypeIndex(typeIndex);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.TYPE_INDEX
     *
     * @param typeIndex the value for REPAIR_TYPE_PARAM.TYPE_INDEX
     */
    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.USER_SERIAL
     *
     * @return the value of REPAIR_TYPE_PARAM.USER_SERIAL
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public RepairTypeParamEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.USER_SERIAL
     *
     * @param userSerial the value for REPAIR_TYPE_PARAM.USER_SERIAL
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.USE_FLAG
     *
     * @return the value of REPAIR_TYPE_PARAM.USE_FLAG
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public RepairTypeParamEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.USE_FLAG
     *
     * @param useFlag the value for REPAIR_TYPE_PARAM.USE_FLAG
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.REMARK
     *
     * @return the value of REPAIR_TYPE_PARAM.REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public RepairTypeParamEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.REMARK
     *
     * @param remark the value for REPAIR_TYPE_PARAM.REMARK
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.SPARE_COL1
     *
     * @return the value of REPAIR_TYPE_PARAM.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public RepairTypeParamEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.SPARE_COL1
     *
     * @param spareCol1 the value for REPAIR_TYPE_PARAM.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.SPARE_COL2
     *
     * @return the value of REPAIR_TYPE_PARAM.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public RepairTypeParamEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.SPARE_COL2
     *
     * @param spareCol2 the value for REPAIR_TYPE_PARAM.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.SPARE_COL3
     *
     * @return the value of REPAIR_TYPE_PARAM.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public RepairTypeParamEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.SPARE_COL3
     *
     * @param spareCol3 the value for REPAIR_TYPE_PARAM.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.CT_USER
     *
     * @return the value of REPAIR_TYPE_PARAM.CT_USER
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public RepairTypeParamEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.CT_USER
     *
     * @param ctUser the value for REPAIR_TYPE_PARAM.CT_USER
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.CT_DATE
     *
     * @return the value of REPAIR_TYPE_PARAM.CT_DATE
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public RepairTypeParamEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.CT_DATE
     *
     * @param ctDate the value for REPAIR_TYPE_PARAM.CT_DATE
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.LT_USER
     *
     * @return the value of REPAIR_TYPE_PARAM.LT_USER
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public RepairTypeParamEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.LT_USER
     *
     * @param ltUser the value for REPAIR_TYPE_PARAM.LT_USER
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column REPAIR_TYPE_PARAM.LT_DATE
     *
     * @return the value of REPAIR_TYPE_PARAM.LT_DATE
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public RepairTypeParamEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_TYPE_PARAM.LT_DATE
     *
     * @param ltDate the value for REPAIR_TYPE_PARAM.LT_DATE
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }
}