package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

public class DoorRealEntity extends ExportRptEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 物理门名称
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门名称")
    private String doorName;

    /**
     * 门编号
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门编号")
    private String bh;

    /**
     * 区分模块
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "区分模块")
    private Integer fxFlg;

    /**
     * 门控器默认规则（一体机常开规则）
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门控器默认规则（一体机常开规则）")
    private Integer mjgz1;

    /**
     * 门控器在线规则（一体机常闭规则）
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门控器在线规则（一体机常闭规则）")
    private Integer mjgz2;

    /**
     * 门控器常开规则
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门控器常开规则")
    private Integer mjgz3;

    /**
     * 门控器常闭规则
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门控器常闭规则")
    private Integer mjgz4;

    /**
     * 按钮开门
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "按钮开门")
    private Integer dButton;

    /**
     * 开门延时
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "开门延时")
    private String dDelay;

    /**
     * 门锁类型
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门锁类型")
    private Integer dLock;

    /**
     * 电锁动作时间
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "电锁动作时间")
    private Integer dDotime;

    /**
     * 电子地图的x坐标
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "电子地图的x坐标")
    private Integer dXPoint;

    /**
     * 电子地图的y坐标
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "电子地图的y坐标")
    private Integer dYPoint;

    /**
     * 门创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-29 14:49:39", value = "门创建时间")
    private Date sj;

    /**
     * 是否启用首卡开门
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用首卡开门")
    private Integer cFirst;

    /**
     * 是否启用多卡开门
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用多卡开门")
    private Integer cMore;

    /**
     * 是否启用管理卡
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用管理卡")
    private Integer cGly;

    /**
     * 首卡规则
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "首卡规则")
    private Integer mjgzFirst;

    /**
     * 多卡规则
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡规则")
    private Integer mjgzMore;

    /**
     * 首卡人员组号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "首卡人员组号")
    private Integer groupFirst;

    /**
     * 管理卡人员组号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "管理卡人员组号")
    private Integer groupGly;

    /**
     * 多卡组1人员组号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组1人员组号")
    private Integer groupMore1;

    /**
     * 多卡组2人员组号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组2人员组号")
    private Integer groupMore2;

    /**
     * 多卡组3人员组号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组3人员组号")
    private Integer groupMore3;

    /**
     * 多卡组4人员组号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组4人员组号")
    private Integer groupMore4;

    /**
     * 多卡组1需要人数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组1需要人数")
    private Integer userMore1;

    /**
     * 多卡组2需要人数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组2需要人数")
    private Integer userMore2;

    /**
     * 多卡组3需要人数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组3需要人数")
    private Integer userMore3;

    /**
     * 多卡组4需要人数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡组4需要人数")
    private Integer userMore4;

    /**
     * 是否启用门磁（是否启用未关门报警）
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用门磁（是否启用未关门报警）")
    private Integer isMagnetism;

    /**
     * 未关门报警时间
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未关门报警时间")
    private Integer openAlarm;

    /**
     * 非法闯入
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "非法闯入")
    private Integer isForcein;

    /**
     * 是否启用管理卡验证密码
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用管理卡验证密码")
    private Integer cGlypass;

    /**
     * 首卡后常开
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "首卡后常开")
    private Integer alwaysOpen;

    /**
     * 门类型
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门类型")
    @Dict("04002")
    private Integer doorLx;

    /**
     * 记录是否插入考勤表中
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "记录是否插入考勤表中")
    private Integer kqFlg;

    /**
     * 通知备注
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "通知备注")
    private String notice;

    /**
     * 多卡常开的连续刷卡次数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "多卡常开的连续刷卡次数")
    private Integer openTimes;

    /**
     * 是否允许访客卡访问
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否允许访客卡访问")
    @Dict("01001")
    private Integer visFlg;

    /**
     * 门禁区分
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁区分")
    @Dict("04003")
    private Integer doorType;

    /**
     * 通道位置
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "通道位置")
    private Integer typeFx;

    /**
     * 通道安装方向
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "通道安装方向")
    private Integer devFx;

    /**
     * 读卡器安装反向
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "读卡器安装反向")
    private Integer cardFx;

    /**
     * 是否允许请假出入
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否允许请假出入")
    @Dict("01001")
    private Integer qjFlg;

    @ApiModelProperty(required = true, dataType = "string", example = "0010001", value = "关联的设备编号")
    private String devSerial;

    @ApiModelProperty(required = true, dataType = "int", example = "1", value = "关联的设备的门序号")
    @Dict("04006")
    private Integer devOrder;

    @ApiModelProperty(required = true, dataType = "int", example = "1", value = "门的场所编号")
    private Integer acdepSerial;

    @ApiModelProperty(required = true, dataType = "int", example = "1", value = "进门的刷卡方式")
    @Dict("04004")
    private Integer cTypeIn;

    @ApiModelProperty(required = true, dataType = "int", example = "1", value = "出门的刷卡方式")
    @Dict("04004")
    private Integer cTypeOut;

    @ApiModelProperty(required = true, dataType = "string", example = "设备名称", value = "关联设备名称")
    private String mc;

    @ApiModelProperty(required = true, dataType = "string", example = "192.168.1.1", value = "关联设备IP")
    private String ip;

    @ApiModelProperty(required = true, dataType = "string", example = "001", value = "关联设备ID")
    private String devId;

    @ApiModelProperty(required = true, dataType = "list", example = "001", value = "场所列表")
    private List<Integer> acdepList;

    @ApiModelProperty(required = true, dataType = "list", example = "001", value = "门列表")
    private List<String> gateList;

    @ApiModelProperty(required = true, dataType = "string", example = "场所名称", value = "场所名称")
    private String depName;

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Integer> getAcdepList() {
        return acdepList;
    }

    public void setAcdepList(List<Integer> acdepList) {
        this.acdepList = acdepList;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Integer getCTypeIn() {
        return cTypeIn;
    }

    public void setCTypeIn(Integer cTypeIn) {
        this.cTypeIn = cTypeIn;
    }

    public Integer getCTypeOut() {
        return cTypeOut;
    }

    public void setCTypeOut(Integer cTypeOut) {
        this.cTypeOut = cTypeOut;
    }

    public Integer getAcdepSerial() {
        return acdepSerial;
    }

    public void setAcdepSerial(Integer acdepSerial) {
        this.acdepSerial = acdepSerial;
    }

    public String getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    public Integer getDevOrder() {
        return devOrder;
    }

    public void setDevOrder(Integer devOrder) {
        this.devOrder = devOrder;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column st_door_real.xh
     *
     * @return the value of st_door_real.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public DoorRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.xh
     *
     * @param xh the value for st_door_real.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column st_door_real.door_name
     *
     * @return the value of st_door_real.door_name
     */
    public String getDoorName() {
        return doorName;
    }

    /**
     */
    public DoorRealEntity withDoorName(String doorName) {
        this.setDoorName(doorName);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.door_name
     *
     * @param doorName the value for st_door_real.door_name
     */
    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    /**
     * This method returns the value of the database column st_door_real.bh
     *
     * @return the value of st_door_real.bh
     */
    public String getBh() {
        return bh;
    }

    /**
     */
    public DoorRealEntity withBh(String bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.bh
     *
     * @param bh the value for st_door_real.bh
     */
    public void setBh(String bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column st_door_real.fx_flg
     *
     * @return the value of st_door_real.fx_flg
     */
    public Integer getFxFlg() {
        return fxFlg;
    }

    /**
     */
    public DoorRealEntity withFxFlg(Integer fxFlg) {
        this.setFxFlg(fxFlg);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.fx_flg
     *
     * @param fxFlg the value for st_door_real.fx_flg
     */
    public void setFxFlg(Integer fxFlg) {
        this.fxFlg = fxFlg;
    }

    /**
     * This method returns the value of the database column st_door_real.mjgz_1
     *
     * @return the value of st_door_real.mjgz_1
     */
    public Integer getMjgz1() {
        return mjgz1;
    }

    /**
     */
    public DoorRealEntity withMjgz1(Integer mjgz1) {
        this.setMjgz1(mjgz1);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.mjgz_1
     *
     * @param mjgz1 the value for st_door_real.mjgz_1
     */
    public void setMjgz1(Integer mjgz1) {
        this.mjgz1 = mjgz1;
    }

    /**
     * This method returns the value of the database column st_door_real.mjgz_2
     *
     * @return the value of st_door_real.mjgz_2
     */
    public Integer getMjgz2() {
        return mjgz2;
    }

    /**
     */
    public DoorRealEntity withMjgz2(Integer mjgz2) {
        this.setMjgz2(mjgz2);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.mjgz_2
     *
     * @param mjgz2 the value for st_door_real.mjgz_2
     */
    public void setMjgz2(Integer mjgz2) {
        this.mjgz2 = mjgz2;
    }

    /**
     * This method returns the value of the database column st_door_real.mjgz_3
     *
     * @return the value of st_door_real.mjgz_3
     */
    public Integer getMjgz3() {
        return mjgz3;
    }

    /**
     */
    public DoorRealEntity withMjgz3(Integer mjgz3) {
        this.setMjgz3(mjgz3);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.mjgz_3
     *
     * @param mjgz3 the value for st_door_real.mjgz_3
     */
    public void setMjgz3(Integer mjgz3) {
        this.mjgz3 = mjgz3;
    }

    /**
     * This method returns the value of the database column st_door_real.mjgz_4
     *
     * @return the value of st_door_real.mjgz_4
     */
    public Integer getMjgz4() {
        return mjgz4;
    }

    /**
     */
    public DoorRealEntity withMjgz4(Integer mjgz4) {
        this.setMjgz4(mjgz4);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.mjgz_4
     *
     * @param mjgz4 the value for st_door_real.mjgz_4
     */
    public void setMjgz4(Integer mjgz4) {
        this.mjgz4 = mjgz4;
    }

    /**
     * This method returns the value of the database column st_door_real.d_button
     *
     * @return the value of st_door_real.d_button
     */
    public Integer getdButton() {
        return dButton;
    }

    /**
     */
    public DoorRealEntity withdButton(Integer dButton) {
        this.setdButton(dButton);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.d_button
     *
     * @param dButton the value for st_door_real.d_button
     */
    public void setdButton(Integer dButton) {
        this.dButton = dButton;
    }

    /**
     * This method returns the value of the database column st_door_real.d_delay
     *
     * @return the value of st_door_real.d_delay
     */
    public String getdDelay() {
        return dDelay;
    }

    /**
     */
    public DoorRealEntity withdDelay(String dDelay) {
        this.setdDelay(dDelay);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.d_delay
     *
     * @param dDelay the value for st_door_real.d_delay
     */
    public void setdDelay(String dDelay) {
        this.dDelay = dDelay;
    }

    /**
     * This method returns the value of the database column st_door_real.d_lock
     *
     * @return the value of st_door_real.d_lock
     */
    public Integer getdLock() {
        return dLock;
    }

    /**
     */
    public DoorRealEntity withdLock(Integer dLock) {
        this.setdLock(dLock);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.d_lock
     *
     * @param dLock the value for st_door_real.d_lock
     */
    public void setdLock(Integer dLock) {
        this.dLock = dLock;
    }

    /**
     * This method returns the value of the database column st_door_real.d_dotime
     *
     * @return the value of st_door_real.d_dotime
     */
    public Integer getdDotime() {
        return dDotime;
    }

    /**
     */
    public DoorRealEntity withdDotime(Integer dDotime) {
        this.setdDotime(dDotime);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.d_dotime
     *
     * @param dDotime the value for st_door_real.d_dotime
     */
    public void setdDotime(Integer dDotime) {
        this.dDotime = dDotime;
    }

    /**
     * This method returns the value of the database column st_door_real.d_x_point
     *
     * @return the value of st_door_real.d_x_point
     */
    public Integer getdXPoint() {
        return dXPoint;
    }

    /**
     */
    public DoorRealEntity withdXPoint(Integer dXPoint) {
        this.setdXPoint(dXPoint);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.d_x_point
     *
     * @param dXPoint the value for st_door_real.d_x_point
     */
    public void setdXPoint(Integer dXPoint) {
        this.dXPoint = dXPoint;
    }

    /**
     * This method returns the value of the database column st_door_real.d_y_point
     *
     * @return the value of st_door_real.d_y_point
     */
    public Integer getdYPoint() {
        return dYPoint;
    }

    /**
     */
    public DoorRealEntity withdYPoint(Integer dYPoint) {
        this.setdYPoint(dYPoint);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.d_y_point
     *
     * @param dYPoint the value for st_door_real.d_y_point
     */
    public void setdYPoint(Integer dYPoint) {
        this.dYPoint = dYPoint;
    }

    /**
     * This method returns the value of the database column st_door_real.sj
     *
     * @return the value of st_door_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DoorRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.sj
     *
     * @param sj the value for st_door_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column st_door_real.c_first
     *
     * @return the value of st_door_real.c_first
     */
    public Integer getcFirst() {
        return cFirst;
    }

    /**
     */
    public DoorRealEntity withcFirst(Integer cFirst) {
        this.setcFirst(cFirst);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.c_first
     *
     * @param cFirst the value for st_door_real.c_first
     */
    public void setcFirst(Integer cFirst) {
        this.cFirst = cFirst;
    }

    /**
     * This method returns the value of the database column st_door_real.c_more
     *
     * @return the value of st_door_real.c_more
     */
    public Integer getcMore() {
        return cMore;
    }

    /**
     */
    public DoorRealEntity withcMore(Integer cMore) {
        this.setcMore(cMore);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.c_more
     *
     * @param cMore the value for st_door_real.c_more
     */
    public void setcMore(Integer cMore) {
        this.cMore = cMore;
    }

    /**
     * This method returns the value of the database column st_door_real.c_gly
     *
     * @return the value of st_door_real.c_gly
     */
    public Integer getcGly() {
        return cGly;
    }

    /**
     */
    public DoorRealEntity withcGly(Integer cGly) {
        this.setcGly(cGly);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.c_gly
     *
     * @param cGly the value for st_door_real.c_gly
     */
    public void setcGly(Integer cGly) {
        this.cGly = cGly;
    }

    /**
     * This method returns the value of the database column st_door_real.mjgz_First
     *
     * @return the value of st_door_real.mjgz_First
     */
    public Integer getMjgzFirst() {
        return mjgzFirst;
    }

    /**
     */
    public DoorRealEntity withMjgzFirst(Integer mjgzFirst) {
        this.setMjgzFirst(mjgzFirst);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.mjgz_First
     *
     * @param mjgzFirst the value for st_door_real.mjgz_First
     */
    public void setMjgzFirst(Integer mjgzFirst) {
        this.mjgzFirst = mjgzFirst;
    }

    /**
     * This method returns the value of the database column st_door_real.mjgz_more
     *
     * @return the value of st_door_real.mjgz_more
     */
    public Integer getMjgzMore() {
        return mjgzMore;
    }

    /**
     */
    public DoorRealEntity withMjgzMore(Integer mjgzMore) {
        this.setMjgzMore(mjgzMore);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.mjgz_more
     *
     * @param mjgzMore the value for st_door_real.mjgz_more
     */
    public void setMjgzMore(Integer mjgzMore) {
        this.mjgzMore = mjgzMore;
    }

    /**
     * This method returns the value of the database column st_door_real.Group_First
     *
     * @return the value of st_door_real.Group_First
     */
    public Integer getGroupFirst() {
        return groupFirst;
    }

    /**
     */
    public DoorRealEntity withGroupFirst(Integer groupFirst) {
        this.setGroupFirst(groupFirst);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Group_First
     *
     * @param groupFirst the value for st_door_real.Group_First
     */
    public void setGroupFirst(Integer groupFirst) {
        this.groupFirst = groupFirst;
    }

    /**
     * This method returns the value of the database column st_door_real.Group_gly
     *
     * @return the value of st_door_real.Group_gly
     */
    public Integer getGroupGly() {
        return groupGly;
    }

    /**
     */
    public DoorRealEntity withGroupGly(Integer groupGly) {
        this.setGroupGly(groupGly);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Group_gly
     *
     * @param groupGly the value for st_door_real.Group_gly
     */
    public void setGroupGly(Integer groupGly) {
        this.groupGly = groupGly;
    }

    /**
     * This method returns the value of the database column st_door_real.Group_more1
     *
     * @return the value of st_door_real.Group_more1
     */
    public Integer getGroupMore1() {
        return groupMore1;
    }

    /**
     */
    public DoorRealEntity withGroupMore1(Integer groupMore1) {
        this.setGroupMore1(groupMore1);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Group_more1
     *
     * @param groupMore1 the value for st_door_real.Group_more1
     */
    public void setGroupMore1(Integer groupMore1) {
        this.groupMore1 = groupMore1;
    }

    /**
     * This method returns the value of the database column st_door_real.Group_more2
     *
     * @return the value of st_door_real.Group_more2
     */
    public Integer getGroupMore2() {
        return groupMore2;
    }

    /**
     */
    public DoorRealEntity withGroupMore2(Integer groupMore2) {
        this.setGroupMore2(groupMore2);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Group_more2
     *
     * @param groupMore2 the value for st_door_real.Group_more2
     */
    public void setGroupMore2(Integer groupMore2) {
        this.groupMore2 = groupMore2;
    }

    /**
     * This method returns the value of the database column st_door_real.Group_more3
     *
     * @return the value of st_door_real.Group_more3
     */
    public Integer getGroupMore3() {
        return groupMore3;
    }

    /**
     */
    public DoorRealEntity withGroupMore3(Integer groupMore3) {
        this.setGroupMore3(groupMore3);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Group_more3
     *
     * @param groupMore3 the value for st_door_real.Group_more3
     */
    public void setGroupMore3(Integer groupMore3) {
        this.groupMore3 = groupMore3;
    }

    /**
     * This method returns the value of the database column st_door_real.Group_more4
     *
     * @return the value of st_door_real.Group_more4
     */
    public Integer getGroupMore4() {
        return groupMore4;
    }

    /**
     */
    public DoorRealEntity withGroupMore4(Integer groupMore4) {
        this.setGroupMore4(groupMore4);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Group_more4
     *
     * @param groupMore4 the value for st_door_real.Group_more4
     */
    public void setGroupMore4(Integer groupMore4) {
        this.groupMore4 = groupMore4;
    }

    /**
     * This method returns the value of the database column st_door_real.User_more1
     *
     * @return the value of st_door_real.User_more1
     */
    public Integer getUserMore1() {
        return userMore1;
    }

    /**
     */
    public DoorRealEntity withUserMore1(Integer userMore1) {
        this.setUserMore1(userMore1);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.User_more1
     *
     * @param userMore1 the value for st_door_real.User_more1
     */
    public void setUserMore1(Integer userMore1) {
        this.userMore1 = userMore1;
    }

    /**
     * This method returns the value of the database column st_door_real.User_more2
     *
     * @return the value of st_door_real.User_more2
     */
    public Integer getUserMore2() {
        return userMore2;
    }

    /**
     */
    public DoorRealEntity withUserMore2(Integer userMore2) {
        this.setUserMore2(userMore2);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.User_more2
     *
     * @param userMore2 the value for st_door_real.User_more2
     */
    public void setUserMore2(Integer userMore2) {
        this.userMore2 = userMore2;
    }

    /**
     * This method returns the value of the database column st_door_real.User_more3
     *
     * @return the value of st_door_real.User_more3
     */
    public Integer getUserMore3() {
        return userMore3;
    }

    /**
     */
    public DoorRealEntity withUserMore3(Integer userMore3) {
        this.setUserMore3(userMore3);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.User_more3
     *
     * @param userMore3 the value for st_door_real.User_more3
     */
    public void setUserMore3(Integer userMore3) {
        this.userMore3 = userMore3;
    }

    /**
     * This method returns the value of the database column st_door_real.User_more4
     *
     * @return the value of st_door_real.User_more4
     */
    public Integer getUserMore4() {
        return userMore4;
    }

    /**
     */
    public DoorRealEntity withUserMore4(Integer userMore4) {
        this.setUserMore4(userMore4);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.User_more4
     *
     * @param userMore4 the value for st_door_real.User_more4
     */
    public void setUserMore4(Integer userMore4) {
        this.userMore4 = userMore4;
    }

    /**
     * This method returns the value of the database column st_door_real.is_magnetism
     *
     * @return the value of st_door_real.is_magnetism
     */
    public Integer getIsMagnetism() {
        return isMagnetism;
    }

    /**
     */
    public DoorRealEntity withIsMagnetism(Integer isMagnetism) {
        this.setIsMagnetism(isMagnetism);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.is_magnetism
     *
     * @param isMagnetism the value for st_door_real.is_magnetism
     */
    public void setIsMagnetism(Integer isMagnetism) {
        this.isMagnetism = isMagnetism;
    }

    /**
     * This method returns the value of the database column st_door_real.open_alarm
     *
     * @return the value of st_door_real.open_alarm
     */
    public Integer getOpenAlarm() {
        return openAlarm;
    }

    /**
     */
    public DoorRealEntity withOpenAlarm(Integer openAlarm) {
        this.setOpenAlarm(openAlarm);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.open_alarm
     *
     * @param openAlarm the value for st_door_real.open_alarm
     */
    public void setOpenAlarm(Integer openAlarm) {
        this.openAlarm = openAlarm;
    }

    /**
     * This method returns the value of the database column st_door_real.is_forcein
     *
     * @return the value of st_door_real.is_forcein
     */
    public Integer getIsForcein() {
        return isForcein;
    }

    /**
     */
    public DoorRealEntity withIsForcein(Integer isForcein) {
        this.setIsForcein(isForcein);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.is_forcein
     *
     * @param isForcein the value for st_door_real.is_forcein
     */
    public void setIsForcein(Integer isForcein) {
        this.isForcein = isForcein;
    }

    /**
     * This method returns the value of the database column st_door_real.c_glypass
     *
     * @return the value of st_door_real.c_glypass
     */
    public Integer getcGlypass() {
        return cGlypass;
    }

    /**
     */
    public DoorRealEntity withcGlypass(Integer cGlypass) {
        this.setcGlypass(cGlypass);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.c_glypass
     *
     * @param cGlypass the value for st_door_real.c_glypass
     */
    public void setcGlypass(Integer cGlypass) {
        this.cGlypass = cGlypass;
    }

    /**
     * This method returns the value of the database column st_door_real.always_open
     *
     * @return the value of st_door_real.always_open
     */
    public Integer getAlwaysOpen() {
        return alwaysOpen;
    }

    /**
     */
    public DoorRealEntity withAlwaysOpen(Integer alwaysOpen) {
        this.setAlwaysOpen(alwaysOpen);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.always_open
     *
     * @param alwaysOpen the value for st_door_real.always_open
     */
    public void setAlwaysOpen(Integer alwaysOpen) {
        this.alwaysOpen = alwaysOpen;
    }

    /**
     * This method returns the value of the database column st_door_real.door_lx
     *
     * @return the value of st_door_real.door_lx
     */
    public Integer getDoorLx() {
        return doorLx;
    }

    /**
     */
    public DoorRealEntity withDoorLx(Integer doorLx) {
        this.setDoorLx(doorLx);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.door_lx
     *
     * @param doorLx the value for st_door_real.door_lx
     */
    public void setDoorLx(Integer doorLx) {
        this.doorLx = doorLx;
    }

    /**
     * This method returns the value of the database column st_door_real.kq_flg
     *
     * @return the value of st_door_real.kq_flg
     */
    public Integer getKqFlg() {
        return kqFlg;
    }

    /**
     */
    public DoorRealEntity withKqFlg(Integer kqFlg) {
        this.setKqFlg(kqFlg);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.kq_flg
     *
     * @param kqFlg the value for st_door_real.kq_flg
     */
    public void setKqFlg(Integer kqFlg) {
        this.kqFlg = kqFlg;
    }

    /**
     * This method returns the value of the database column st_door_real.notice
     *
     * @return the value of st_door_real.notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     */
    public DoorRealEntity withNotice(String notice) {
        this.setNotice(notice);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.notice
     *
     * @param notice the value for st_door_real.notice
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * This method returns the value of the database column st_door_real.open_times
     *
     * @return the value of st_door_real.open_times
     */
    public Integer getOpenTimes() {
        return openTimes;
    }

    /**
     */
    public DoorRealEntity withOpenTimes(Integer openTimes) {
        this.setOpenTimes(openTimes);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.open_times
     *
     * @param openTimes the value for st_door_real.open_times
     */
    public void setOpenTimes(Integer openTimes) {
        this.openTimes = openTimes;
    }

    /**
     * This method returns the value of the database column st_door_real.Vis_flg
     *
     * @return the value of st_door_real.Vis_flg
     */
    public Integer getVisFlg() {
        return visFlg;
    }

    /**
     */
    public DoorRealEntity withVisFlg(Integer visFlg) {
        this.setVisFlg(visFlg);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Vis_flg
     *
     * @param visFlg the value for st_door_real.Vis_flg
     */
    public void setVisFlg(Integer visFlg) {
        this.visFlg = visFlg;
    }

    /**
     * This method returns the value of the database column st_door_real.Door_type
     *
     * @return the value of st_door_real.Door_type
     */
    public Integer getDoorType() {
        return doorType;
    }

    /**
     */
    public DoorRealEntity withDoorType(Integer doorType) {
        this.setDoorType(doorType);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Door_type
     *
     * @param doorType the value for st_door_real.Door_type
     */
    public void setDoorType(Integer doorType) {
        this.doorType = doorType;
    }

    /**
     * This method returns the value of the database column st_door_real.Type_fx
     *
     * @return the value of st_door_real.Type_fx
     */
    public Integer getTypeFx() {
        return typeFx;
    }

    /**
     */
    public DoorRealEntity withTypeFx(Integer typeFx) {
        this.setTypeFx(typeFx);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.Type_fx
     *
     * @param typeFx the value for st_door_real.Type_fx
     */
    public void setTypeFx(Integer typeFx) {
        this.typeFx = typeFx;
    }

    /**
     * This method returns the value of the database column st_door_real.dev_fx
     *
     * @return the value of st_door_real.dev_fx
     */
    public Integer getDevFx() {
        return devFx;
    }

    /**
     */
    public DoorRealEntity withDevFx(Integer devFx) {
        this.setDevFx(devFx);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.dev_fx
     *
     * @param devFx the value for st_door_real.dev_fx
     */
    public void setDevFx(Integer devFx) {
        this.devFx = devFx;
    }

    /**
     * This method returns the value of the database column st_door_real.card_fx
     *
     * @return the value of st_door_real.card_fx
     */
    public Integer getCardFx() {
        return cardFx;
    }

    /**
     */
    public DoorRealEntity withCardFx(Integer cardFx) {
        this.setCardFx(cardFx);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.card_fx
     *
     * @param cardFx the value for st_door_real.card_fx
     */
    public void setCardFx(Integer cardFx) {
        this.cardFx = cardFx;
    }

    /**
     * This method returns the value of the database column st_door_real.qj_flg
     *
     * @return the value of st_door_real.qj_flg
     */
    public Integer getQjFlg() {
        return qjFlg;
    }

    /**
     */
    public DoorRealEntity withQjFlg(Integer qjFlg) {
        this.setQjFlg(qjFlg);
        return this;
    }

    /**
     * This method sets the value of the database column st_door_real.qj_flg
     *
     * @param qjFlg the value for st_door_real.qj_flg
     */
    public void setQjFlg(Integer qjFlg) {
        this.qjFlg = qjFlg;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}