package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 门通行记录表
 * @Date 2019-08-06
 */
public class MjJlRealEntity extends ExportRptEntity implements Serializable {
    /**
     * 门禁进出时间#1##1##
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-06 10:58:10", value = "门禁进出时间#1##1##")
    private Date jlSj;

    /**
     * 自增序号#1####
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号#1####")
    private Integer xh;

    /**
     * 物理门编号#1####
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门编号#1####")
    private String gateBh;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-06 10:58:10", value = "门禁进出时间#1##1##")
    private Date kssj;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-06 10:58:10", value = "门禁进出时间#1##1##")
    private Date jssj;

    private List<String> gateBhs;

    private List<Integer> acdepSerials;

    private List<Integer> jlTypes;

    private List<Integer> userDeps;

    private List<Integer> userSerials;

    private List<String> devSerials;

    private Integer acdepSerial;
    private String mc;
    private String ip;
    @Dict("04002")
    private Integer devLb;
    private String userNo;
    private String doorName;
    private String placeName;

    /**
     * 门方向序号#1####
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门方向序号#1####")
    @Dict("04001")
    private Integer fx;

    /**
     * 设备编号#1####
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "设备编号#1####")
    private String devSerial;

    /**
     * 人员序号#1####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员序号#1####")
    private Long userSerial;

    /**
     * 记录卡号#1####
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "记录卡号#1####")
    private String userCard;

    /**
     * 设备记录流水号#1####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "设备记录流水号#1####")
    private Long devBh;

    /**
     * 门顺序号#1####
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门顺序号#1####")
    private Integer devDoor;

    /**
     * 卡头序号#1####
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "卡头序号#1####")
    private Integer cardOrder;

    /**
     * 记录类型#1##1#9#04010
     */
    @Dict("04010")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "记录类型#1##1#9#04010")
    private Integer jlType;

    /**
     * 导入记录的时间#1####
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-06 10:58:10", value = "导入记录的时间#1####")
    private Date sj;

    /**
     * 记录状态#1####
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "记录状态#1####")
    private Integer state;

    /**
     * 操作员#1####
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员#1####")
    private String glyNo;

    /**
     * 门禁一体机照片编号#1####
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁一体机照片编号#1####")
    private Integer jframeId;

    /**
     * 人员分类#1####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员分类#1####")
    @Dict("01011")
    private Byte userLx;

    /**
     * 人员姓名#1####
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员姓名#1####")
    private String userName;

    /**
     * 部门名称#1####
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "部门名称#1####")
    private String depName;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column mj_jl_real.jl_sj
     *
     * @return the value of mj_jl_real.jl_sj
     */
    public Date getJlSj() {
        return jlSj;
    }

    /**
     */
    public MjJlRealEntity withJlSj(Date jlSj) {
        this.setJlSj(jlSj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.jl_sj
     *
     * @param jlSj the value for mj_jl_real.jl_sj
     */
    public void setJlSj(Date jlSj) {
        this.jlSj = jlSj;
    }

    /**
     * This method returns the value of the database column mj_jl_real.xh
     *
     * @return the value of mj_jl_real.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MjJlRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.xh
     *
     * @param xh the value for mj_jl_real.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column mj_jl_real.Gate_bh
     *
     * @return the value of mj_jl_real.Gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public MjJlRealEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.Gate_bh
     *
     * @param gateBh the value for mj_jl_real.Gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column mj_jl_real.fx
     *
     * @return the value of mj_jl_real.fx
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public MjJlRealEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.fx
     *
     * @param fx the value for mj_jl_real.fx
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column mj_jl_real.dev_serial
     *
     * @return the value of mj_jl_real.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public MjJlRealEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.dev_serial
     *
     * @param devSerial the value for mj_jl_real.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column mj_jl_real.user_serial
     *
     * @return the value of mj_jl_real.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public MjJlRealEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.user_serial
     *
     * @param userSerial the value for mj_jl_real.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column mj_jl_real.user_card
     *
     * @return the value of mj_jl_real.user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     */
    public MjJlRealEntity withUserCard(String userCard) {
        this.setUserCard(userCard);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.user_card
     *
     * @param userCard the value for mj_jl_real.user_card
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    /**
     * This method returns the value of the database column mj_jl_real.dev_bh
     *
     * @return the value of mj_jl_real.dev_bh
     */
    public Long getDevBh() {
        return devBh;
    }

    /**
     */
    public MjJlRealEntity withDevBh(Long devBh) {
        this.setDevBh(devBh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.dev_bh
     *
     * @param devBh the value for mj_jl_real.dev_bh
     */
    public void setDevBh(Long devBh) {
        this.devBh = devBh;
    }

    /**
     * This method returns the value of the database column mj_jl_real.dev_door
     *
     * @return the value of mj_jl_real.dev_door
     */
    public Integer getDevDoor() {
        return devDoor;
    }

    /**
     */
    public MjJlRealEntity withDevDoor(Integer devDoor) {
        this.setDevDoor(devDoor);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.dev_door
     *
     * @param devDoor the value for mj_jl_real.dev_door
     */
    public void setDevDoor(Integer devDoor) {
        this.devDoor = devDoor;
    }

    /**
     * This method returns the value of the database column mj_jl_real.card_order
     *
     * @return the value of mj_jl_real.card_order
     */
    public Integer getCardOrder() {
        return cardOrder;
    }

    /**
     */
    public MjJlRealEntity withCardOrder(Integer cardOrder) {
        this.setCardOrder(cardOrder);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.card_order
     *
     * @param cardOrder the value for mj_jl_real.card_order
     */
    public void setCardOrder(Integer cardOrder) {
        this.cardOrder = cardOrder;
    }

    /**
     * This method returns the value of the database column mj_jl_real.jl_type
     *
     * @return the value of mj_jl_real.jl_type
     */
    public Integer getJlType() {
        return jlType;
    }

    /**
     */
    public MjJlRealEntity withJlType(Integer jlType) {
        this.setJlType(jlType);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.jl_type
     *
     * @param jlType the value for mj_jl_real.jl_type
     */
    public void setJlType(Integer jlType) {
        this.jlType = jlType;
    }

    /**
     * This method returns the value of the database column mj_jl_real.sj
     *
     * @return the value of mj_jl_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MjJlRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.sj
     *
     * @param sj the value for mj_jl_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column mj_jl_real.state
     *
     * @return the value of mj_jl_real.state
     */
    public Integer getState() {
        return state;
    }

    /**
     */
    public MjJlRealEntity withState(Integer state) {
        this.setState(state);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.state
     *
     * @param state the value for mj_jl_real.state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method returns the value of the database column mj_jl_real.gly_no
     *
     * @return the value of mj_jl_real.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjJlRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.gly_no
     *
     * @param glyNo the value for mj_jl_real.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column mj_jl_real.jframe_id
     *
     * @return the value of mj_jl_real.jframe_id
     */
    public Integer getJframeId() {
        return jframeId;
    }

    /**
     */
    public MjJlRealEntity withJframeId(Integer jframeId) {
        this.setJframeId(jframeId);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.jframe_id
     *
     * @param jframeId the value for mj_jl_real.jframe_id
     */
    public void setJframeId(Integer jframeId) {
        this.jframeId = jframeId;
    }

    /**
     * This method returns the value of the database column mj_jl_real.user_lx
     *
     * @return the value of mj_jl_real.user_lx
     */
    public Byte getUserLx() {
        return userLx;
    }

    /**
     */
    public MjJlRealEntity withUserLx(Byte userLx) {
        this.setUserLx(userLx);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.user_lx
     *
     * @param userLx the value for mj_jl_real.user_lx
     */
    public void setUserLx(Byte userLx) {
        this.userLx = userLx;
    }

    /**
     * This method returns the value of the database column mj_jl_real.user_name
     *
     * @return the value of mj_jl_real.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     */
    public MjJlRealEntity withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.user_name
     *
     * @param userName the value for mj_jl_real.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the value of the database column mj_jl_real.dep_name
     *
     * @return the value of mj_jl_real.dep_name
     */
    public String getDepName() {
        return depName;
    }

    /**
     */
    public MjJlRealEntity withDepName(String depName) {
        this.setDepName(depName);
        return this;
    }

    /**
     * This method sets the value of the database column mj_jl_real.dep_name
     *
     * @param depName the value for mj_jl_real.dep_name
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    public List<String> getGateBhs() {
        return gateBhs;
    }

    public void setGateBhs(List<String> gateBhs) {
        this.gateBhs = gateBhs;
    }

    public List<Integer> getAcdepSerials() {
        return acdepSerials;
    }

    public void setAcdepSerials(List<Integer> acdepSerials) {
        this.acdepSerials = acdepSerials;
    }

    public List<Integer> getJlTypes() {
        return jlTypes;
    }

    public void setJlTypes(List<Integer> jlTypes) {
        this.jlTypes = jlTypes;
    }

    public List<Integer> getUserDeps() {
        return userDeps;
    }

    public void setUserDeps(List<Integer> userDeps) {
        this.userDeps = userDeps;
    }

    public List<Integer> getUserSerials() {
        return userSerials;
    }

    public void setUserSerials(List<Integer> userSerials) {
        this.userSerials = userSerials;
    }

    public List<String> getDevSerials() {
        return devSerials;
    }

    public void setDevSerials(List<String> devSerials) {
        this.devSerials = devSerials;
    }

    public Integer getAcdepSerial() {
        return acdepSerial;
    }

    public void setAcdepSerial(Integer acdepSerial) {
        this.acdepSerial = acdepSerial;
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

    public Integer getDevLb() {
        return devLb;
    }

    public void setDevLb(Integer devLb) {
        this.devLb = devLb;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}