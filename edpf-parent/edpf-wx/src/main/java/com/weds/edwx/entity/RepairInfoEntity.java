package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RepairInfoEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String id;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer companyId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer initiatorUser;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String repairType;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-02-23 14:01:01", value = "")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-02-23", value = "")
    private Date start;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-02-23", value = "")
    private Date end;

    private String initiatorUserName;

    private String repairUserName;

    private String initiatorTel;

    private String repairResult;

    private String resultRemark;

    private String repairTypeName;

    private String resultPhoto;

    private List<String> resultPhotoList;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String repairAddress;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String repairState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String repairPhoto;

    private List<String> photoList;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String initiatorRemark;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String readFlag;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer repairUser;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-02-23 14:01:01", value = "")
    private Date endDate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String repairRemark;

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

    public List<String> getResultPhotoList() {
        return resultPhotoList;
    }

    public void setResultPhotoList(List<String> resultPhotoList) {
        this.resultPhotoList = resultPhotoList;
    }

    public String getResultPhoto() {
        return resultPhoto;
    }

    public void setResultPhoto(String resultPhoto) {
        this.resultPhoto = resultPhoto;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column REPAIR_INFO.ID
     *
     * @return the value of REPAIR_INFO.ID
     */
    public String getId() {
        return id;
    }

    /**
     */
    public RepairInfoEntity withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.ID
     *
     * @param id the value for REPAIR_INFO.ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.COMPANY_ID
     *
     * @return the value of REPAIR_INFO.COMPANY_ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     */
    public RepairInfoEntity withCompanyId(Integer companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.COMPANY_ID
     *
     * @param companyId the value for REPAIR_INFO.COMPANY_ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.INITIATOR_USER
     *
     * @return the value of REPAIR_INFO.INITIATOR_USER
     */
    public Integer getInitiatorUser() {
        return initiatorUser;
    }

    /**
     */
    public RepairInfoEntity withInitiatorUser(Integer initiatorUser) {
        this.setInitiatorUser(initiatorUser);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.INITIATOR_USER
     *
     * @param initiatorUser the value for REPAIR_INFO.INITIATOR_USER
     */
    public void setInitiatorUser(Integer initiatorUser) {
        this.initiatorUser = initiatorUser;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.REPAIR_TYPE
     *
     * @return the value of REPAIR_INFO.REPAIR_TYPE
     */
    public String getRepairType() {
        return repairType;
    }

    /**
     */
    public RepairInfoEntity withRepairType(String repairType) {
        this.setRepairType(repairType);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.REPAIR_TYPE
     *
     * @param repairType the value for REPAIR_INFO.REPAIR_TYPE
     */
    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.START_DATE
     *
     * @return the value of REPAIR_INFO.START_DATE
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     */
    public RepairInfoEntity withStartDate(Date startDate) {
        this.setStartDate(startDate);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.START_DATE
     *
     * @param startDate the value for REPAIR_INFO.START_DATE
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.REPAIR_ADDRESS
     *
     * @return the value of REPAIR_INFO.REPAIR_ADDRESS
     */
    public String getRepairAddress() {
        return repairAddress;
    }

    /**
     */
    public RepairInfoEntity withRepairAddress(String repairAddress) {
        this.setRepairAddress(repairAddress);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.REPAIR_ADDRESS
     *
     * @param repairAddress the value for REPAIR_INFO.REPAIR_ADDRESS
     */
    public void setRepairAddress(String repairAddress) {
        this.repairAddress = repairAddress;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.REPAIR_STATE
     *
     * @return the value of REPAIR_INFO.REPAIR_STATE
     */
    public String getRepairState() {
        return repairState;
    }

    /**
     */
    public RepairInfoEntity withRepairState(String repairState) {
        this.setRepairState(repairState);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.REPAIR_STATE
     *
     * @param repairState the value for REPAIR_INFO.REPAIR_STATE
     */
    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.REPAIR_PHOTO
     *
     * @return the value of REPAIR_INFO.REPAIR_PHOTO
     */
    public String getRepairPhoto() {
        return repairPhoto;
    }

    /**
     */
    public RepairInfoEntity withRepairPhoto(String repairPhoto) {
        this.setRepairPhoto(repairPhoto);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.REPAIR_PHOTO
     *
     * @param repairPhoto the value for REPAIR_INFO.REPAIR_PHOTO
     */
    public void setRepairPhoto(String repairPhoto) {
        this.repairPhoto = repairPhoto;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.INITIATOR_REMARK
     *
     * @return the value of REPAIR_INFO.INITIATOR_REMARK
     */
    public String getInitiatorRemark() {
        return initiatorRemark;
    }

    /**
     */
    public RepairInfoEntity withInitiatorRemark(String initiatorRemark) {
        this.setInitiatorRemark(initiatorRemark);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.INITIATOR_REMARK
     *
     * @param initiatorRemark the value for REPAIR_INFO.INITIATOR_REMARK
     */
    public void setInitiatorRemark(String initiatorRemark) {
        this.initiatorRemark = initiatorRemark;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.READ_FLAG
     *
     * @return the value of REPAIR_INFO.READ_FLAG
     */
    public String getReadFlag() {
        return readFlag;
    }

    /**
     */
    public RepairInfoEntity withReadFlag(String readFlag) {
        this.setReadFlag(readFlag);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.READ_FLAG
     *
     * @param readFlag the value for REPAIR_INFO.READ_FLAG
     */
    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.REPAIR_USER
     *
     * @return the value of REPAIR_INFO.REPAIR_USER
     */
    public Integer getRepairUser() {
        return repairUser;
    }

    /**
     */
    public RepairInfoEntity withRepairUser(Integer repairUser) {
        this.setRepairUser(repairUser);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.REPAIR_USER
     *
     * @param repairUser the value for REPAIR_INFO.REPAIR_USER
     */
    public void setRepairUser(Integer repairUser) {
        this.repairUser = repairUser;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.END_DATE
     *
     * @return the value of REPAIR_INFO.END_DATE
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     */
    public RepairInfoEntity withEndDate(Date endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.END_DATE
     *
     * @param endDate the value for REPAIR_INFO.END_DATE
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.REPAIR_REMARK
     *
     * @return the value of REPAIR_INFO.REPAIR_REMARK
     */
    public String getRepairRemark() {
        return repairRemark;
    }

    /**
     */
    public RepairInfoEntity withRepairRemark(String repairRemark) {
        this.setRepairRemark(repairRemark);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.REPAIR_REMARK
     *
     * @param repairRemark the value for REPAIR_INFO.REPAIR_REMARK
     */
    public void setRepairRemark(String repairRemark) {
        this.repairRemark = repairRemark;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.SPARE_COL1
     *
     * @return the value of REPAIR_INFO.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public RepairInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.SPARE_COL1
     *
     * @param spareCol1 the value for REPAIR_INFO.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.SPARE_COL2
     *
     * @return the value of REPAIR_INFO.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public RepairInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.SPARE_COL2
     *
     * @param spareCol2 the value for REPAIR_INFO.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.SPARE_COL3
     *
     * @return the value of REPAIR_INFO.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public RepairInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.SPARE_COL3
     *
     * @param spareCol3 the value for REPAIR_INFO.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.CT_USER
     *
     * @return the value of REPAIR_INFO.CT_USER
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public RepairInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.CT_USER
     *
     * @param ctUser the value for REPAIR_INFO.CT_USER
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.CT_DATE
     *
     * @return the value of REPAIR_INFO.CT_DATE
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public RepairInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.CT_DATE
     *
     * @param ctDate the value for REPAIR_INFO.CT_DATE
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.LT_USER
     *
     * @return the value of REPAIR_INFO.LT_USER
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public RepairInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.LT_USER
     *
     * @param ltUser the value for REPAIR_INFO.LT_USER
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column REPAIR_INFO.LT_DATE
     *
     * @return the value of REPAIR_INFO.LT_DATE
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public RepairInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column REPAIR_INFO.LT_DATE
     *
     * @param ltDate the value for REPAIR_INFO.LT_DATE
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }

    public String getInitiatorUserName() {
        return initiatorUserName;
    }

    public void setInitiatorUserName(String initiatorUserName) {
        this.initiatorUserName = initiatorUserName;
    }

    public String getRepairUserName() {
        return repairUserName;
    }

    public void setRepairUserName(String repairUserName) {
        this.repairUserName = repairUserName;
    }

    public String getInitiatorTel() {
        return initiatorTel;
    }

    public void setInitiatorTel(String initiatorTel) {
        this.initiatorTel = initiatorTel;
    }

    public String getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(String repairResult) {
        this.repairResult = repairResult;
    }

    public String getResultRemark() {
        return resultRemark;
    }

    public void setResultRemark(String resultRemark) {
        this.resultRemark = resultRemark;
    }

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }
}