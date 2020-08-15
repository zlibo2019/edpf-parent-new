package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 配置手机开门人员
 * @Date 2019-08-07
 */
public class WtMjMobileEntity extends BaseEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 人员序号#1####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员序号#1####")
    private Long userSerial;

    /**
     * 记录类型
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "记录类型")
    private Integer lx;

    /**
     * 物理门编号#1####
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门编号#1####")
    private String gateBh;

    /**
     * 档案更新的日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-07 16:07:00", value = "档案更新的日期")
    private Date sj;

    /**
     * 操作员
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer gateOrder;

    private String userNo;
    private String userLname;
    private String userDepname;
    private String doorName;

    private List<Integer> userList;
    private List<Integer> deptList;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column WT_mj_mobile.xh
     *
     * @return the value of WT_mj_mobile.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public WtMjMobileEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.xh
     *
     * @param xh the value for WT_mj_mobile.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.user_serial
     *
     * @return the value of WT_mj_mobile.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public WtMjMobileEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.user_serial
     *
     * @param userSerial the value for WT_mj_mobile.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.lx
     *
     * @return the value of WT_mj_mobile.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public WtMjMobileEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.lx
     *
     * @param lx the value for WT_mj_mobile.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.gate_bh
     *
     * @return the value of WT_mj_mobile.gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public WtMjMobileEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.gate_bh
     *
     * @param gateBh the value for WT_mj_mobile.gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.sj
     *
     * @return the value of WT_mj_mobile.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public WtMjMobileEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.sj
     *
     * @param sj the value for WT_mj_mobile.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.gly_no
     *
     * @return the value of WT_mj_mobile.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public WtMjMobileEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.gly_no
     *
     * @param glyNo the value for WT_mj_mobile.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.gate_order
     *
     * @return the value of WT_mj_mobile.gate_order
     */
    public Integer getGateOrder() {
        return gateOrder;
    }

    /**
     */
    public WtMjMobileEntity withGateOrder(Integer gateOrder) {
        this.setGateOrder(gateOrder);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.gate_order
     *
     * @param gateOrder the value for WT_mj_mobile.gate_order
     */
    public void setGateOrder(Integer gateOrder) {
        this.gateOrder = gateOrder;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserDepname() {
        return userDepname;
    }

    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public List<Integer> getUserList() {
        return userList;
    }

    public void setUserList(List<Integer> userList) {
        this.userList = userList;
    }

    public List<Integer> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Integer> deptList) {
        this.deptList = deptList;
    }
}