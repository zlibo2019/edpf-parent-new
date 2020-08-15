package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class DoorfxRealEntity extends BaseEntity implements Serializable {
    /**
     *   门编号
     *
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门编号")
    private String gateBh;

    /**
     *   自增序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     *   门方向序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门方向序号")
    private Integer fx;

    /**
     *   关联设备编号
     *
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "关联设备编号")
    private String devSerial;

    /**
     *   关联对应门控器的门顺序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "关联对应门控器的门顺序号")
    private Integer devOrder;

    /**
     *   关联对应门控器的读头顺序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "关联对应门控器的读头顺序号")
    private Integer devHead;

    /**
     *   是否启用首卡
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用首卡")
    private Integer cFirst;

    /**
     *   门禁首卡规则
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁首卡规则")
    private Integer mjgzSk;

    /**
     *   是否启用多卡
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用多卡")
    private Integer cMore;

    /**
     *   门禁多卡规则
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁多卡规则")
    private Integer migzMore;

    /**
     *   多卡组1组号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组1组号")
    private Integer dMoreUser1;

    /**
     *   多卡组2组号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组2组号")
    private Integer dMoreUser2;

    /**
     *   多卡组3组号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组3组号")
    private Integer dMoreUser3;

    /**
     *   多卡组4组号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组4组号")
    private Integer dMoreUser4;

    /**
     *   胁迫密码
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "胁迫密码")
    private Integer cStressM;

    /**
     *   超级密码
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "超级密码")
    private Integer cSuperM;

    /**
     *   刷卡方式
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "刷卡方式")
    private Integer cType;

    /**
     *   超级卡
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "超级卡")
    private Integer cSuperC;

    /**
     *   密码键盘
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "密码键盘")
    private Integer cPassKey;

    /**
     *   员工密码
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "员工密码")
    private Integer cSimcard;

    /**
     *   卡头方向
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "卡头方向")
    private Integer cDirection;

    /**
     *   门属性创建时间:
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-29 17:40:44", value = "门属性创建时间:")
    private Date sj;

    /**
     *   关联对应门控器的读头顺序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "关联对应门控器的读头顺序号")
    private Integer devHead2;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column st_doorfx_real.gate_bh
     *
     * @return the value of st_doorfx_real.gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public DoorfxRealEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.gate_bh
     *
     * @param gateBh the value for st_doorfx_real.gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.xh
     *
     * @return the value of st_doorfx_real.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public DoorfxRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.xh
     *
     * @param xh the value for st_doorfx_real.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.fx
     *
     * @return the value of st_doorfx_real.fx
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public DoorfxRealEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.fx
     *
     * @param fx the value for st_doorfx_real.fx
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.dev_serial
     *
     * @return the value of st_doorfx_real.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public DoorfxRealEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.dev_serial
     *
     * @param devSerial the value for st_doorfx_real.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.dev_order
     *
     * @return the value of st_doorfx_real.dev_order
     */
    public Integer getDevOrder() {
        return devOrder;
    }

    /**
     */
    public DoorfxRealEntity withDevOrder(Integer devOrder) {
        this.setDevOrder(devOrder);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.dev_order
     *
     * @param devOrder the value for st_doorfx_real.dev_order
     */
    public void setDevOrder(Integer devOrder) {
        this.devOrder = devOrder;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.dev_head
     *
     * @return the value of st_doorfx_real.dev_head
     */
    public Integer getDevHead() {
        return devHead;
    }

    /**
     */
    public DoorfxRealEntity withDevHead(Integer devHead) {
        this.setDevHead(devHead);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.dev_head
     *
     * @param devHead the value for st_doorfx_real.dev_head
     */
    public void setDevHead(Integer devHead) {
        this.devHead = devHead;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_first
     *
     * @return the value of st_doorfx_real.c_first
     */
    public Integer getcFirst() {
        return cFirst;
    }

    /**
     */
    public DoorfxRealEntity withcFirst(Integer cFirst) {
        this.setcFirst(cFirst);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_first
     *
     * @param cFirst the value for st_doorfx_real.c_first
     */
    public void setcFirst(Integer cFirst) {
        this.cFirst = cFirst;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.Mjgz_sk
     *
     * @return the value of st_doorfx_real.Mjgz_sk
     */
    public Integer getMjgzSk() {
        return mjgzSk;
    }

    /**
     */
    public DoorfxRealEntity withMjgzSk(Integer mjgzSk) {
        this.setMjgzSk(mjgzSk);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.Mjgz_sk
     *
     * @param mjgzSk the value for st_doorfx_real.Mjgz_sk
     */
    public void setMjgzSk(Integer mjgzSk) {
        this.mjgzSk = mjgzSk;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_more
     *
     * @return the value of st_doorfx_real.c_more
     */
    public Integer getcMore() {
        return cMore;
    }

    /**
     */
    public DoorfxRealEntity withcMore(Integer cMore) {
        this.setcMore(cMore);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_more
     *
     * @param cMore the value for st_doorfx_real.c_more
     */
    public void setcMore(Integer cMore) {
        this.cMore = cMore;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.migz_more
     *
     * @return the value of st_doorfx_real.migz_more
     */
    public Integer getMigzMore() {
        return migzMore;
    }

    /**
     */
    public DoorfxRealEntity withMigzMore(Integer migzMore) {
        this.setMigzMore(migzMore);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.migz_more
     *
     * @param migzMore the value for st_doorfx_real.migz_more
     */
    public void setMigzMore(Integer migzMore) {
        this.migzMore = migzMore;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.d_more_user1
     *
     * @return the value of st_doorfx_real.d_more_user1
     */
    public Integer getdMoreUser1() {
        return dMoreUser1;
    }

    /**
     */
    public DoorfxRealEntity withdMoreUser1(Integer dMoreUser1) {
        this.setdMoreUser1(dMoreUser1);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.d_more_user1
     *
     * @param dMoreUser1 the value for st_doorfx_real.d_more_user1
     */
    public void setdMoreUser1(Integer dMoreUser1) {
        this.dMoreUser1 = dMoreUser1;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.d_more_user2
     *
     * @return the value of st_doorfx_real.d_more_user2
     */
    public Integer getdMoreUser2() {
        return dMoreUser2;
    }

    /**
     */
    public DoorfxRealEntity withdMoreUser2(Integer dMoreUser2) {
        this.setdMoreUser2(dMoreUser2);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.d_more_user2
     *
     * @param dMoreUser2 the value for st_doorfx_real.d_more_user2
     */
    public void setdMoreUser2(Integer dMoreUser2) {
        this.dMoreUser2 = dMoreUser2;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.d_more_user3
     *
     * @return the value of st_doorfx_real.d_more_user3
     */
    public Integer getdMoreUser3() {
        return dMoreUser3;
    }

    /**
     */
    public DoorfxRealEntity withdMoreUser3(Integer dMoreUser3) {
        this.setdMoreUser3(dMoreUser3);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.d_more_user3
     *
     * @param dMoreUser3 the value for st_doorfx_real.d_more_user3
     */
    public void setdMoreUser3(Integer dMoreUser3) {
        this.dMoreUser3 = dMoreUser3;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.d_more_user4
     *
     * @return the value of st_doorfx_real.d_more_user4
     */
    public Integer getdMoreUser4() {
        return dMoreUser4;
    }

    /**
     */
    public DoorfxRealEntity withdMoreUser4(Integer dMoreUser4) {
        this.setdMoreUser4(dMoreUser4);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.d_more_user4
     *
     * @param dMoreUser4 the value for st_doorfx_real.d_more_user4
     */
    public void setdMoreUser4(Integer dMoreUser4) {
        this.dMoreUser4 = dMoreUser4;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_stress_m
     *
     * @return the value of st_doorfx_real.c_stress_m
     */
    public Integer getcStressM() {
        return cStressM;
    }

    /**
     */
    public DoorfxRealEntity withcStressM(Integer cStressM) {
        this.setcStressM(cStressM);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_stress_m
     *
     * @param cStressM the value for st_doorfx_real.c_stress_m
     */
    public void setcStressM(Integer cStressM) {
        this.cStressM = cStressM;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_super_m
     *
     * @return the value of st_doorfx_real.c_super_m
     */
    public Integer getcSuperM() {
        return cSuperM;
    }

    /**
     */
    public DoorfxRealEntity withcSuperM(Integer cSuperM) {
        this.setcSuperM(cSuperM);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_super_m
     *
     * @param cSuperM the value for st_doorfx_real.c_super_m
     */
    public void setcSuperM(Integer cSuperM) {
        this.cSuperM = cSuperM;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_type
     *
     * @return the value of st_doorfx_real.c_type
     */
    public Integer getcType() {
        return cType;
    }

    /**
     */
    public DoorfxRealEntity withcType(Integer cType) {
        this.setcType(cType);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_type
     *
     * @param cType the value for st_doorfx_real.c_type
     */
    public void setcType(Integer cType) {
        this.cType = cType;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_super_c
     *
     * @return the value of st_doorfx_real.c_super_c
     */
    public Integer getcSuperC() {
        return cSuperC;
    }

    /**
     */
    public DoorfxRealEntity withcSuperC(Integer cSuperC) {
        this.setcSuperC(cSuperC);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_super_c
     *
     * @param cSuperC the value for st_doorfx_real.c_super_c
     */
    public void setcSuperC(Integer cSuperC) {
        this.cSuperC = cSuperC;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.c_pass_key
     *
     * @return the value of st_doorfx_real.c_pass_key
     */
    public Integer getcPassKey() {
        return cPassKey;
    }

    /**
     */
    public DoorfxRealEntity withcPassKey(Integer cPassKey) {
        this.setcPassKey(cPassKey);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.c_pass_key
     *
     * @param cPassKey the value for st_doorfx_real.c_pass_key
     */
    public void setcPassKey(Integer cPassKey) {
        this.cPassKey = cPassKey;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.C_simcard
     *
     * @return the value of st_doorfx_real.C_simcard
     */
    public Integer getcSimcard() {
        return cSimcard;
    }

    /**
     */
    public DoorfxRealEntity withcSimcard(Integer cSimcard) {
        this.setcSimcard(cSimcard);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.C_simcard
     *
     * @param cSimcard the value for st_doorfx_real.C_simcard
     */
    public void setcSimcard(Integer cSimcard) {
        this.cSimcard = cSimcard;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.C_direction
     *
     * @return the value of st_doorfx_real.C_direction
     */
    public Integer getcDirection() {
        return cDirection;
    }

    /**
     */
    public DoorfxRealEntity withcDirection(Integer cDirection) {
        this.setcDirection(cDirection);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.C_direction
     *
     * @param cDirection the value for st_doorfx_real.C_direction
     */
    public void setcDirection(Integer cDirection) {
        this.cDirection = cDirection;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.sj
     *
     * @return the value of st_doorfx_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DoorfxRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.sj
     *
     * @param sj the value for st_doorfx_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column st_doorfx_real.Dev_head2
     *
     * @return the value of st_doorfx_real.Dev_head2
     */
    public Integer getDevHead2() {
        return devHead2;
    }

    /**
     */
    public DoorfxRealEntity withDevHead2(Integer devHead2) {
        this.setDevHead2(devHead2);
        return this;
    }

    /**
     * This method sets the value of the database column st_doorfx_real.Dev_head2
     *
     * @param devHead2 the value for st_doorfx_real.Dev_head2
     */
    public void setDevHead2(Integer devHead2) {
        this.devHead2 = devHead2;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}