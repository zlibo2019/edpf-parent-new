package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 字典信息
 * @Date 2019-03-07
 */
public class DictInfoEntity extends BaseEntity implements Serializable {
    /**
     *   类型编号#1#1#2#
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "类型编号#1#1#2#")
    private String typeCode;

    /**
     *   字典编号#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "字典编号#1#1##")
    private String dicCode;

    /**
     *   字典名称#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "字典名称#1#1##")
    private String dicName;

    /**
     *   字典顺序#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "字典顺序#1#1##")
    private Integer dicIndex;

    /**
     *   是否启用#1#1#9#01001
     *
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "是否启用#1#1#9#01001")
    private String useFlag;

    /**
     *   字典备注##1#1#
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "字典备注##1#1#")
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
     * This method returns the value of the database column ed_dict_info.type_code
     *
     * @return the value of ed_dict_info.type_code
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     */
    public DictInfoEntity withTypeCode(String typeCode) {
        this.setTypeCode(typeCode);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.type_code
     *
     * @param typeCode the value for ed_dict_info.type_code
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * This method returns the value of the database column ed_dict_info.dic_code
     *
     * @return the value of ed_dict_info.dic_code
     */
    public String getDicCode() {
        return dicCode;
    }

    /**
     */
    public DictInfoEntity withDicCode(String dicCode) {
        this.setDicCode(dicCode);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.dic_code
     *
     * @param dicCode the value for ed_dict_info.dic_code
     */
    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    /**
     * This method returns the value of the database column ed_dict_info.dic_name
     *
     * @return the value of ed_dict_info.dic_name
     */
    public String getDicName() {
        return dicName;
    }

    /**
     */
    public DictInfoEntity withDicName(String dicName) {
        this.setDicName(dicName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.dic_name
     *
     * @param dicName the value for ed_dict_info.dic_name
     */
    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    /**
     * This method returns the value of the database column ed_dict_info.dic_index
     *
     * @return the value of ed_dict_info.dic_index
     */
    public Integer getDicIndex() {
        return dicIndex;
    }

    /**
     */
    public DictInfoEntity withDicIndex(Integer dicIndex) {
        this.setDicIndex(dicIndex);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.dic_index
     *
     * @param dicIndex the value for ed_dict_info.dic_index
     */
    public void setDicIndex(Integer dicIndex) {
        this.dicIndex = dicIndex;
    }

    /**
     * This method returns the value of the database column ed_dict_info.use_flag
     *
     * @return the value of ed_dict_info.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public DictInfoEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.use_flag
     *
     * @param useFlag the value for ed_dict_info.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_dict_info.remark
     *
     * @return the value of ed_dict_info.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public DictInfoEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.remark
     *
     * @param remark the value for ed_dict_info.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dict_info.spare_col1
     *
     * @return the value of ed_dict_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public DictInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.spare_col1
     *
     * @param spareCol1 the value for ed_dict_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dict_info.spare_col2
     *
     * @return the value of ed_dict_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public DictInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.spare_col2
     *
     * @param spareCol2 the value for ed_dict_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dict_info.spare_col3
     *
     * @return the value of ed_dict_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public DictInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.spare_col3
     *
     * @param spareCol3 the value for ed_dict_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dict_info.ct_user_id
     *
     * @return the value of ed_dict_info.ct_user_id
     */
    public String getCtUserId() {
        return ctUserId;
    }

    /**
     */
    public DictInfoEntity withCtUserId(String ctUserId) {
        this.setCtUserId(ctUserId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.ct_user_id
     *
     * @param ctUserId the value for ed_dict_info.ct_user_id
     */
    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId;
    }

    /**
     * This method returns the value of the database column ed_dict_info.ct_date
     *
     * @return the value of ed_dict_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public DictInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.ct_date
     *
     * @param ctDate the value for ed_dict_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dict_info.lt_user_id
     *
     * @return the value of ed_dict_info.lt_user_id
     */
    public String getLtUserId() {
        return ltUserId;
    }

    /**
     */
    public DictInfoEntity withLtUserId(String ltUserId) {
        this.setLtUserId(ltUserId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.lt_user_id
     *
     * @param ltUserId the value for ed_dict_info.lt_user_id
     */
    public void setLtUserId(String ltUserId) {
        this.ltUserId = ltUserId;
    }

    /**
     * This method returns the value of the database column ed_dict_info.lt_date
     *
     * @return the value of ed_dict_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public DictInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dict_info.lt_date
     *
     * @param ltDate the value for ed_dict_info.lt_date
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