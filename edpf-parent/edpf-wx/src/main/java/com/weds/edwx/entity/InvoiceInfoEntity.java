package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class InvoiceInfoEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String companyName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String taxNum;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String address;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String phone;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String acctBank;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String acctNum;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 13:33:22", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    private String qrCode;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column INVOICE_INFO.XH
     *
     * @return the value of INVOICE_INFO.XH
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public InvoiceInfoEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.XH
     *
     * @param xh the value for INVOICE_INFO.XH
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.COMPANY_NAME
     *
     * @return the value of INVOICE_INFO.COMPANY_NAME
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     */
    public InvoiceInfoEntity withCompanyName(String companyName) {
        this.setCompanyName(companyName);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.COMPANY_NAME
     *
     * @param companyName the value for INVOICE_INFO.COMPANY_NAME
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.TAX_NUM
     *
     * @return the value of INVOICE_INFO.TAX_NUM
     */
    public String getTaxNum() {
        return taxNum;
    }

    /**
     */
    public InvoiceInfoEntity withTaxNum(String taxNum) {
        this.setTaxNum(taxNum);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.TAX_NUM
     *
     * @param taxNum the value for INVOICE_INFO.TAX_NUM
     */
    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.ADDRESS
     *
     * @return the value of INVOICE_INFO.ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     */
    public InvoiceInfoEntity withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.ADDRESS
     *
     * @param address the value for INVOICE_INFO.ADDRESS
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.PHONE
     *
     * @return the value of INVOICE_INFO.PHONE
     */
    public String getPhone() {
        return phone;
    }

    /**
     */
    public InvoiceInfoEntity withPhone(String phone) {
        this.setPhone(phone);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.PHONE
     *
     * @param phone the value for INVOICE_INFO.PHONE
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.ACCT_BANK
     *
     * @return the value of INVOICE_INFO.ACCT_BANK
     */
    public String getAcctBank() {
        return acctBank;
    }

    /**
     */
    public InvoiceInfoEntity withAcctBank(String acctBank) {
        this.setAcctBank(acctBank);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.ACCT_BANK
     *
     * @param acctBank the value for INVOICE_INFO.ACCT_BANK
     */
    public void setAcctBank(String acctBank) {
        this.acctBank = acctBank;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.ACCT_NUM
     *
     * @return the value of INVOICE_INFO.ACCT_NUM
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     */
    public InvoiceInfoEntity withAcctNum(String acctNum) {
        this.setAcctNum(acctNum);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.ACCT_NUM
     *
     * @param acctNum the value for INVOICE_INFO.ACCT_NUM
     */
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.REMARK
     *
     * @return the value of INVOICE_INFO.REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public InvoiceInfoEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.REMARK
     *
     * @param remark the value for INVOICE_INFO.REMARK
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.SPARE_COL1
     *
     * @return the value of INVOICE_INFO.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public InvoiceInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.SPARE_COL1
     *
     * @param spareCol1 the value for INVOICE_INFO.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.SPARE_COL2
     *
     * @return the value of INVOICE_INFO.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public InvoiceInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.SPARE_COL2
     *
     * @param spareCol2 the value for INVOICE_INFO.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.SPARE_COL3
     *
     * @return the value of INVOICE_INFO.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public InvoiceInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.SPARE_COL3
     *
     * @param spareCol3 the value for INVOICE_INFO.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.SJ
     *
     * @return the value of INVOICE_INFO.SJ
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public InvoiceInfoEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.SJ
     *
     * @param sj the value for INVOICE_INFO.SJ
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column INVOICE_INFO.GLY_NO
     *
     * @return the value of INVOICE_INFO.GLY_NO
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public InvoiceInfoEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column INVOICE_INFO.GLY_NO
     *
     * @param glyNo the value for INVOICE_INFO.GLY_NO
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}