package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 字典类型
 * @Date 2019-03-07
 */
public class DictTypeEntity extends BaseEntity implements Serializable {
    /**
     *   类型编号#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "类型编号#1#1##")
    private String typeCode;

    /**
     *   类型名称#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "类型名称#1#1##")
    private String typeName;

    /**
     *   是否启用#1#1#9#01001
     *
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "是否启用#1#1#9#01001")
    private String useFlag;

    /**
     *   类型备注##1#1#
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "类型备注##1#1#")
    private String remark;

    /**
     *   预留字段1####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段1####")
    private String spareCol1;

    /**
     *   预留字段2####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段2####")
    private String spareCol2;

    /**
     *   预留字段3####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段3####")
    private String spareCol3;

    /**
     *   创建者####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建者####")
    private String ctUserId;

    /**
     *   创建时间####
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建时间####")
    private Date ctDate;

    /**
     *   修改者####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改者####")
    private String ltUserId;

    /**
     *   修改时间####
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改时间####")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_dict_type.type_code
     *
     * @return the value of ed_dict_type.type_code
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     */
    public DictTypeEntity withTypeCode(String typeCode) {
        this.setTypeCode(typeCode);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.type_code
     *
     * @param typeCode the value for ed_dict_type.type_code
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * This method returns the value of the database column ed_dict_type.type_name
     *
     * @return the value of ed_dict_type.type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     */
    public DictTypeEntity withTypeName(String typeName) {
        this.setTypeName(typeName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.type_name
     *
     * @param typeName the value for ed_dict_type.type_name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * This method returns the value of the database column ed_dict_type.use_flag
     *
     * @return the value of ed_dict_type.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public DictTypeEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.use_flag
     *
     * @param useFlag the value for ed_dict_type.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_dict_type.remark
     *
     * @return the value of ed_dict_type.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public DictTypeEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.remark
     *
     * @param remark the value for ed_dict_type.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dict_type.spare_col1
     *
     * @return the value of ed_dict_type.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public DictTypeEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.spare_col1
     *
     * @param spareCol1 the value for ed_dict_type.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dict_type.spare_col2
     *
     * @return the value of ed_dict_type.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public DictTypeEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.spare_col2
     *
     * @param spareCol2 the value for ed_dict_type.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dict_type.spare_col3
     *
     * @return the value of ed_dict_type.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public DictTypeEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.spare_col3
     *
     * @param spareCol3 the value for ed_dict_type.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dict_type.ct_user_id
     *
     * @return the value of ed_dict_type.ct_user_id
     */
    public String getCtUserId() {
        return ctUserId;
    }

    /**
     */
    public DictTypeEntity withCtUserId(String ctUserId) {
        this.setCtUserId(ctUserId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.ct_user_id
     *
     * @param ctUserId the value for ed_dict_type.ct_user_id
     */
    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId;
    }

    /**
     * This method returns the value of the database column ed_dict_type.ct_date
     *
     * @return the value of ed_dict_type.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public DictTypeEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.ct_date
     *
     * @param ctDate the value for ed_dict_type.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dict_type.lt_user_id
     *
     * @return the value of ed_dict_type.lt_user_id
     */
    public String getLtUserId() {
        return ltUserId;
    }

    /**
     */
    public DictTypeEntity withLtUserId(String ltUserId) {
        this.setLtUserId(ltUserId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.lt_user_id
     *
     * @param ltUserId the value for ed_dict_type.lt_user_id
     */
    public void setLtUserId(String ltUserId) {
        this.ltUserId = ltUserId;
    }

    /**
     * This method returns the value of the database column ed_dict_type.lt_date
     *
     * @return the value of ed_dict_type.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public DictTypeEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_type.lt_date
     *
     * @param ltDate the value for ed_dict_type.lt_date
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