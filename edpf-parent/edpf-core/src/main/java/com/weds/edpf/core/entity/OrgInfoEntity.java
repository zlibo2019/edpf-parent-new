package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 机构基本信息
 * @Date 2019-09-25
 */
public class OrgInfoEntity extends ExportRptEntity implements Serializable {
    /**
     * 机构编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构编号")
    private String orgId;

    /**
     * 机构名称#1#1##0#
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构名称#1#1##0#")
    private String orgName;

    /**
     * 机构简称##1##0#
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构简称##1##0#")
    private String orgAlais;

    /**
     * 机构类型##1##9#05001
     */
    @Size(max = 10)
    @Dict("05001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构类型##1##9#05001")
    private String orgType;

    /**
     * logo图片#1#1##0#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "logo图片#1#1##0#")
    private String orgLogo;

    /**
     * 背景图片##1##0#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "背景图片##1##0#")
    private String backImg;

    /**
     * 机构描述##1##1#
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构描述##1##1#")
    private String orgDesc;


    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构序号##1##1#")
    private Integer orgIndex;

    /**
     * 营业开始时间#1#1##7#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "营业开始时间#1#1##7#")
    private String startTime;

    /**
     * 营业结束时间#1#1##7#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "营业结束时间#1#1##7#")
    private String endTime;

    /**
     * 机构地址#1#1##1#
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "机构地址#1#1##1#")
    private String orgAddr;

    /**
     * 联系电话#1#1##0#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "联系电话#1#1##0#")
    private String orgTel;

    /**
     * 备注##1##1#
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注##1##1#")
    private String remakr;

    /**
     * 创建时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    private Date ctDate;

    /**
     * 创建人员
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建人员")
    private String ctUser;

    /**
     * 修改时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    /**
     * 修改人员
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改人员")
    private String ltUser;

    /**
     * 预留字段1
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol3;

    /**
     * 预留字段4
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol4;

    /**
     * 预留字段5
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol5;

    /**
     * 预留字段6
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol6;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 机构编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "父机构编号")
    private String parentOrgId;

    private String keys;

    /**
     * This method returns the value of the database column ed_org_info.org_id
     *
     * @return the value of ed_org_info.org_id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     */
    public OrgInfoEntity withOrgId(String orgId) {
        this.setOrgId(orgId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_id
     *
     * @param orgId the value for ed_org_info.org_id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_name
     *
     * @return the value of ed_org_info.org_name
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     */
    public OrgInfoEntity withOrgName(String orgName) {
        this.setOrgName(orgName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_name
     *
     * @param orgName the value for ed_org_info.org_name
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_alais
     *
     * @return the value of ed_org_info.org_alais
     */
    public String getOrgAlais() {
        return orgAlais;
    }

    /**
     */
    public OrgInfoEntity withOrgAlais(String orgAlais) {
        this.setOrgAlais(orgAlais);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_alais
     *
     * @param orgAlais the value for ed_org_info.org_alais
     */
    public void setOrgAlais(String orgAlais) {
        this.orgAlais = orgAlais;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_type
     *
     * @return the value of ed_org_info.org_type
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     */
    public OrgInfoEntity withOrgType(String orgType) {
        this.setOrgType(orgType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_type
     *
     * @param orgType the value for ed_org_info.org_type
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_logo
     *
     * @return the value of ed_org_info.org_logo
     */
    public String getOrgLogo() {
        return orgLogo;
    }

    /**
     */
    public OrgInfoEntity withOrgLogo(String orgLogo) {
        this.setOrgLogo(orgLogo);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_logo
     *
     * @param orgLogo the value for ed_org_info.org_logo
     */
    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    /**
     * This method returns the value of the database column ed_org_info.back_img
     *
     * @return the value of ed_org_info.back_img
     */
    public String getBackImg() {
        return backImg;
    }

    /**
     */
    public OrgInfoEntity withBackImg(String backImg) {
        this.setBackImg(backImg);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.back_img
     *
     * @param backImg the value for ed_org_info.back_img
     */
    public void setBackImg(String backImg) {
        this.backImg = backImg;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_desc
     *
     * @return the value of ed_org_info.org_desc
     */
    public String getOrgDesc() {
        return orgDesc;
    }

    /**
     */
    public OrgInfoEntity withOrgDesc(String orgDesc) {
        this.setOrgDesc(orgDesc);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_desc
     *
     * @param orgDesc the value for ed_org_info.org_desc
     */
    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    /**
     * This method returns the value of the database column ed_org_info.start_time
     *
     * @return the value of ed_org_info.start_time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     */
    public OrgInfoEntity withStartTime(String startTime) {
        this.setStartTime(startTime);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.start_time
     *
     * @param startTime the value for ed_org_info.start_time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * This method returns the value of the database column ed_org_info.end_time
     *
     * @return the value of ed_org_info.end_time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     */
    public OrgInfoEntity withEndTime(String endTime) {
        this.setEndTime(endTime);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.end_time
     *
     * @param endTime the value for ed_org_info.end_time
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_addr
     *
     * @return the value of ed_org_info.org_addr
     */
    public String getOrgAddr() {
        return orgAddr;
    }

    /**
     */
    public OrgInfoEntity withOrgAddr(String orgAddr) {
        this.setOrgAddr(orgAddr);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_addr
     *
     * @param orgAddr the value for ed_org_info.org_addr
     */
    public void setOrgAddr(String orgAddr) {
        this.orgAddr = orgAddr;
    }

    /**
     * This method returns the value of the database column ed_org_info.org_tel
     *
     * @return the value of ed_org_info.org_tel
     */
    public String getOrgTel() {
        return orgTel;
    }

    /**
     */
    public OrgInfoEntity withOrgTel(String orgTel) {
        this.setOrgTel(orgTel);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.org_tel
     *
     * @param orgTel the value for ed_org_info.org_tel
     */
    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel;
    }

    /**
     * This method returns the value of the database column ed_org_info.remakr
     *
     * @return the value of ed_org_info.remakr
     */
    public String getRemakr() {
        return remakr;
    }

    /**
     */
    public OrgInfoEntity withRemakr(String remakr) {
        this.setRemakr(remakr);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.remakr
     *
     * @param remakr the value for ed_org_info.remakr
     */
    public void setRemakr(String remakr) {
        this.remakr = remakr;
    }

    /**
     * This method returns the value of the database column ed_org_info.ct_date
     *
     * @return the value of ed_org_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public OrgInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.ct_date
     *
     * @param ctDate the value for ed_org_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_org_info.ct_user
     *
     * @return the value of ed_org_info.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public OrgInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.ct_user
     *
     * @param ctUser the value for ed_org_info.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_org_info.lt_date
     *
     * @return the value of ed_org_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public OrgInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.lt_date
     *
     * @param ltDate the value for ed_org_info.lt_date
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    /**
     * This method returns the value of the database column ed_org_info.lt_user
     *
     * @return the value of ed_org_info.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public OrgInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.lt_user
     *
     * @param ltUser the value for ed_org_info.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_org_info.spare_col1
     *
     * @return the value of ed_org_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public OrgInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.spare_col1
     *
     * @param spareCol1 the value for ed_org_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_org_info.spare_col2
     *
     * @return the value of ed_org_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public OrgInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.spare_col2
     *
     * @param spareCol2 the value for ed_org_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_org_info.spare_col3
     *
     * @return the value of ed_org_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public OrgInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.spare_col3
     *
     * @param spareCol3 the value for ed_org_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_org_info.spare_col4
     *
     * @return the value of ed_org_info.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public OrgInfoEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.spare_col4
     *
     * @param spareCol4 the value for ed_org_info.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_org_info.spare_col5
     *
     * @return the value of ed_org_info.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public OrgInfoEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.spare_col5
     *
     * @param spareCol5 the value for ed_org_info.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_org_info.spare_col6
     *
     * @return the value of ed_org_info.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public OrgInfoEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_org_info.spare_col6
     *
     * @param spareCol6 the value for ed_org_info.spare_col6
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

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public Integer getOrgIndex() {
        return orgIndex;
    }

    public void setOrgIndex(Integer orgIndex) {
        this.orgIndex = orgIndex;
    }
}