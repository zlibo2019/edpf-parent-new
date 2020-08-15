package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class VisSettingEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String id;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer setType;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String setValue;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visKssj;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visJssj;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spareCol1;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spareCol2;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spareCol3;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spareCol4;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ctUser;

    /**
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Date ctDate;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ltUser;

    /**
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column vis_setting.id
     *
     * @return the value of vis_setting.id
     */
    public String getId() {
        return id;
    }

    /**
     */
    public VisSettingEntity withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.id
     *
     * @param id the value for vis_setting.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column vis_setting.set_type
     *
     * @return the value of vis_setting.set_type
     */
    public Integer getSetType() {
        return setType;
    }

    /**
     */
    public VisSettingEntity withSetType(Integer setType) {
        this.setSetType(setType);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.set_type
     *
     * @param setType the value for vis_setting.set_type
     */
    public void setSetType(Integer setType) {
        this.setType = setType;
    }

    /**
     * This method returns the value of the database column vis_setting.set_value
     *
     * @return the value of vis_setting.set_value
     */
    public String getSetValue() {
        return setValue;
    }

    /**
     */
    public VisSettingEntity withSetValue(String setValue) {
        this.setSetValue(setValue);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.set_value
     *
     * @param setValue the value for vis_setting.set_value
     */
    public void setSetValue(String setValue) {
        this.setValue = setValue;
    }

    /**
     * This method returns the value of the database column vis_setting.vis_kssj
     *
     * @return the value of vis_setting.vis_kssj
     */
    public String getVisKssj() {
        return visKssj;
    }

    /**
     */
    public VisSettingEntity withVisKssj(String visKssj) {
        this.setVisKssj(visKssj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.vis_kssj
     *
     * @param visKssj the value for vis_setting.vis_kssj
     */
    public void setVisKssj(String visKssj) {
        this.visKssj = visKssj;
    }

    /**
     * This method returns the value of the database column vis_setting.vis_jssj
     *
     * @return the value of vis_setting.vis_jssj
     */
    public String getVisJssj() {
        return visJssj;
    }

    /**
     */
    public VisSettingEntity withVisJssj(String visJssj) {
        this.setVisJssj(visJssj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.vis_jssj
     *
     * @param visJssj the value for vis_setting.vis_jssj
     */
    public void setVisJssj(String visJssj) {
        this.visJssj = visJssj;
    }

    /**
     * This method returns the value of the database column vis_setting.spare_col1
     *
     * @return the value of vis_setting.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public VisSettingEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.spare_col1
     *
     * @param spareCol1 the value for vis_setting.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column vis_setting.spare_col2
     *
     * @return the value of vis_setting.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public VisSettingEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.spare_col2
     *
     * @param spareCol2 the value for vis_setting.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column vis_setting.spare_col3
     *
     * @return the value of vis_setting.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public VisSettingEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.spare_col3
     *
     * @param spareCol3 the value for vis_setting.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column vis_setting.spare_col4
     *
     * @return the value of vis_setting.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public VisSettingEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.spare_col4
     *
     * @param spareCol4 the value for vis_setting.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column vis_setting.ct_user
     *
     * @return the value of vis_setting.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public VisSettingEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.ct_user
     *
     * @param ctUser the value for vis_setting.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column vis_setting.ct_date
     *
     * @return the value of vis_setting.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public VisSettingEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.ct_date
     *
     * @param ctDate the value for vis_setting.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column vis_setting.lt_user
     *
     * @return the value of vis_setting.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public VisSettingEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.lt_user
     *
     * @param ltUser the value for vis_setting.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column vis_setting.lt_date
     *
     * @return the value of vis_setting.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public VisSettingEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column vis_setting.lt_date
     *
     * @param ltDate the value for vis_setting.lt_date
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