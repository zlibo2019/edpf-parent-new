package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 机构关系信息
 * @Date 2019-09-27
 */
public class OrgRelaEntity extends BaseEntity implements Serializable {
    /**
     *   id
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "id")
    private String id;

    /**
     *   机构编号
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构编号")
    private String orgId;

    /**
     *   上级机构编号
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "上级机构编号")
    private String parentOrgId;

    /**
     *   开始日期
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-09-27 09:26:29", value = "开始日期")
    private Date startDate;

    /**
     *   结束日期
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-09-27 09:26:29", value = "结束日期")
    private Date endDate;

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
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_org_rela.id
     *
     * @return the value of ed_org_rela.id
     */
    public String getId() {
        return id;
    }

    /**
     */
    public OrgRelaEntity withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.id
     *
     * @param id the value for ed_org_rela.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column ed_org_rela.org_id
     *
     * @return the value of ed_org_rela.org_id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     */
    public OrgRelaEntity withOrgId(String orgId) {
        this.setOrgId(orgId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.org_id
     *
     * @param orgId the value for ed_org_rela.org_id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * This method returns the value of the database column ed_org_rela.parent_org_id
     *
     * @return the value of ed_org_rela.parent_org_id
     */
    public String getParentOrgId() {
        return parentOrgId;
    }

    /**
     */
    public OrgRelaEntity withParentOrgId(String parentOrgId) {
        this.setParentOrgId(parentOrgId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.parent_org_id
     *
     * @param parentOrgId the value for ed_org_rela.parent_org_id
     */
    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    /**
     * This method returns the value of the database column ed_org_rela.start_date
     *
     * @return the value of ed_org_rela.start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     */
    public OrgRelaEntity withStartDate(Date startDate) {
        this.setStartDate(startDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.start_date
     *
     * @param startDate the value for ed_org_rela.start_date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the value of the database column ed_org_rela.end_date
     *
     * @return the value of ed_org_rela.end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     */
    public OrgRelaEntity withEndDate(Date endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.end_date
     *
     * @param endDate the value for ed_org_rela.end_date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the value of the database column ed_org_rela.spare_col1
     *
     * @return the value of ed_org_rela.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public OrgRelaEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.spare_col1
     *
     * @param spareCol1 the value for ed_org_rela.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_org_rela.spare_col2
     *
     * @return the value of ed_org_rela.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public OrgRelaEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.spare_col2
     *
     * @param spareCol2 the value for ed_org_rela.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_org_rela.spare_col3
     *
     * @return the value of ed_org_rela.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public OrgRelaEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.spare_col3
     *
     * @param spareCol3 the value for ed_org_rela.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_org_rela.spare_col4
     *
     * @return the value of ed_org_rela.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public OrgRelaEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.spare_col4
     *
     * @param spareCol4 the value for ed_org_rela.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_org_rela.spare_col5
     *
     * @return the value of ed_org_rela.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public OrgRelaEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.spare_col5
     *
     * @param spareCol5 the value for ed_org_rela.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_org_rela.spare_col6
     *
     * @return the value of ed_org_rela.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public OrgRelaEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_rela.spare_col6
     *
     * @param spareCol6 the value for ed_org_rela.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}