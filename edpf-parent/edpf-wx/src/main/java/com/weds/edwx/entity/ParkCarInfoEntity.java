package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ParkCarInfoEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String carNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-27 15:02:56", value = "")
    private Date pactBegin;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-27 15:02:56", value = "")
    private Date pactEnd;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-27 15:02:56", value = "")
    private Date jlSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isValid;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String cancelGlyNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-27 15:02:56", value = "")
    private Date cancelSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String bz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer carLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String userName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String company;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String userCard;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column park_car_info.xh
     *
     * @return the value of park_car_info.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public ParkCarInfoEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.xh
     *
     * @param xh the value for park_car_info.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column park_car_info.user_serial
     *
     * @return the value of park_car_info.user_serial
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public ParkCarInfoEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.user_serial
     *
     * @param userSerial the value for park_car_info.user_serial
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column park_car_info.car_no
     *
     * @return the value of park_car_info.car_no
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     */
    public ParkCarInfoEntity withCarNo(String carNo) {
        this.setCarNo(carNo);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.car_no
     *
     * @param carNo the value for park_car_info.car_no
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    /**
     * This method returns the value of the database column park_car_info.pact_begin
     *
     * @return the value of park_car_info.pact_begin
     */
    public Date getPactBegin() {
        return pactBegin;
    }

    /**
     */
    public ParkCarInfoEntity withPactBegin(Date pactBegin) {
        this.setPactBegin(pactBegin);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.pact_begin
     *
     * @param pactBegin the value for park_car_info.pact_begin
     */
    public void setPactBegin(Date pactBegin) {
        this.pactBegin = pactBegin;
    }

    /**
     * This method returns the value of the database column park_car_info.pact_end
     *
     * @return the value of park_car_info.pact_end
     */
    public Date getPactEnd() {
        return pactEnd;
    }

    /**
     */
    public ParkCarInfoEntity withPactEnd(Date pactEnd) {
        this.setPactEnd(pactEnd);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.pact_end
     *
     * @param pactEnd the value for park_car_info.pact_end
     */
    public void setPactEnd(Date pactEnd) {
        this.pactEnd = pactEnd;
    }

    /**
     * This method returns the value of the database column park_car_info.jl_sj
     *
     * @return the value of park_car_info.jl_sj
     */
    public Date getJlSj() {
        return jlSj;
    }

    /**
     */
    public ParkCarInfoEntity withJlSj(Date jlSj) {
        this.setJlSj(jlSj);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.jl_sj
     *
     * @param jlSj the value for park_car_info.jl_sj
     */
    public void setJlSj(Date jlSj) {
        this.jlSj = jlSj;
    }

    /**
     * This method returns the value of the database column park_car_info.gly_no
     *
     * @return the value of park_car_info.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public ParkCarInfoEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.gly_no
     *
     * @param glyNo the value for park_car_info.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column park_car_info.is_valid
     *
     * @return the value of park_car_info.is_valid
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     */
    public ParkCarInfoEntity withIsValid(Integer isValid) {
        this.setIsValid(isValid);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.is_valid
     *
     * @param isValid the value for park_car_info.is_valid
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * This method returns the value of the database column park_car_info.cancel_gly_no
     *
     * @return the value of park_car_info.cancel_gly_no
     */
    public String getCancelGlyNo() {
        return cancelGlyNo;
    }

    /**
     */
    public ParkCarInfoEntity withCancelGlyNo(String cancelGlyNo) {
        this.setCancelGlyNo(cancelGlyNo);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.cancel_gly_no
     *
     * @param cancelGlyNo the value for park_car_info.cancel_gly_no
     */
    public void setCancelGlyNo(String cancelGlyNo) {
        this.cancelGlyNo = cancelGlyNo;
    }

    /**
     * This method returns the value of the database column park_car_info.cancel_sj
     *
     * @return the value of park_car_info.cancel_sj
     */
    public Date getCancelSj() {
        return cancelSj;
    }

    /**
     */
    public ParkCarInfoEntity withCancelSj(Date cancelSj) {
        this.setCancelSj(cancelSj);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.cancel_sj
     *
     * @param cancelSj the value for park_car_info.cancel_sj
     */
    public void setCancelSj(Date cancelSj) {
        this.cancelSj = cancelSj;
    }

    /**
     * This method returns the value of the database column park_car_info.bz
     *
     * @return the value of park_car_info.bz
     */
    public String getBz() {
        return bz;
    }

    /**
     */
    public ParkCarInfoEntity withBz(String bz) {
        this.setBz(bz);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.bz
     *
     * @param bz the value for park_car_info.bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * This method returns the value of the database column park_car_info.car_lx
     *
     * @return the value of park_car_info.car_lx
     */
    public Integer getCarLx() {
        return carLx;
    }

    /**
     */
    public ParkCarInfoEntity withCarLx(Integer carLx) {
        this.setCarLx(carLx);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.car_lx
     *
     * @param carLx the value for park_car_info.car_lx
     */
    public void setCarLx(Integer carLx) {
        this.carLx = carLx;
    }

    /**
     * This method returns the value of the database column park_car_info.user_name
     *
     * @return the value of park_car_info.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     */
    public ParkCarInfoEntity withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.user_name
     *
     * @param userName the value for park_car_info.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the value of the database column park_car_info.company
     *
     * @return the value of park_car_info.company
     */
    public String getCompany() {
        return company;
    }

    /**
     */
    public ParkCarInfoEntity withCompany(String company) {
        this.setCompany(company);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.company
     *
     * @param company the value for park_car_info.company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * This method returns the value of the database column park_car_info.user_card
     *
     * @return the value of park_car_info.user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     */
    public ParkCarInfoEntity withUserCard(String userCard) {
        this.setUserCard(userCard);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_info.user_card
     *
     * @param userCard the value for park_car_info.user_card
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }
}