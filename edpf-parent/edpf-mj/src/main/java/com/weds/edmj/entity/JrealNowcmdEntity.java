package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

public class JrealNowcmdEntity extends BaseEntity implements Serializable {
    /**
     *   自增序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer jcmdsig;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jdevId;

    /**
     *   门控器设备编号
     *
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门控器设备编号")
    private String jdevBh;

    /**
     *   通讯类型
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "通讯类型")
    private Integer jtype;

    /**
     *   指令的类型
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "指令的类型")
    private Integer jint;

    /**
     *   nofinger照片
     *
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "nofinger照片")
    private String jstr;

    /**
     *   指令创建时间
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "指令创建时间")
    private Integer jretPer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jretSubper;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jretInt;

    /**
     *
     */
    @Size(max = 1100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jretStr;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-31 09:10:35", value = "")
    private Date jtime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-31 09:10:35", value = "")
    private Date jlastTime;

    /**
     *   1考勤机通讯
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "1考勤机通讯")
    private Integer juserType;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String juserShow;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer juserGroup;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String joperator;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jipAddr;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column jreal_nowcmd.jcmdsig
     *
     * @return the value of jreal_nowcmd.jcmdsig
     */
    public Integer getJcmdsig() {
        return jcmdsig;
    }

    /**
     */
    public JrealNowcmdEntity withJcmdsig(Integer jcmdsig) {
        this.setJcmdsig(jcmdsig);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jcmdsig
     *
     * @param jcmdsig the value for jreal_nowcmd.jcmdsig
     */
    public void setJcmdsig(Integer jcmdsig) {
        this.jcmdsig = jcmdsig;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jdev_id
     *
     * @return the value of jreal_nowcmd.jdev_id
     */
    public Integer getJdevId() {
        return jdevId;
    }

    /**
     */
    public JrealNowcmdEntity withJdevId(Integer jdevId) {
        this.setJdevId(jdevId);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jdev_id
     *
     * @param jdevId the value for jreal_nowcmd.jdev_id
     */
    public void setJdevId(Integer jdevId) {
        this.jdevId = jdevId;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jdev_bh
     *
     * @return the value of jreal_nowcmd.jdev_bh
     */
    public String getJdevBh() {
        return jdevBh;
    }

    /**
     */
    public JrealNowcmdEntity withJdevBh(String jdevBh) {
        this.setJdevBh(jdevBh);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jdev_bh
     *
     * @param jdevBh the value for jreal_nowcmd.jdev_bh
     */
    public void setJdevBh(String jdevBh) {
        this.jdevBh = jdevBh;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jtype
     *
     * @return the value of jreal_nowcmd.jtype
     */
    public Integer getJtype() {
        return jtype;
    }

    /**
     */
    public JrealNowcmdEntity withJtype(Integer jtype) {
        this.setJtype(jtype);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jtype
     *
     * @param jtype the value for jreal_nowcmd.jtype
     */
    public void setJtype(Integer jtype) {
        this.jtype = jtype;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jint
     *
     * @return the value of jreal_nowcmd.jint
     */
    public Integer getJint() {
        return jint;
    }

    /**
     */
    public JrealNowcmdEntity withJint(Integer jint) {
        this.setJint(jint);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jint
     *
     * @param jint the value for jreal_nowcmd.jint
     */
    public void setJint(Integer jint) {
        this.jint = jint;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jstr
     *
     * @return the value of jreal_nowcmd.jstr
     */
    public String getJstr() {
        return jstr;
    }

    /**
     */
    public JrealNowcmdEntity withJstr(String jstr) {
        this.setJstr(jstr);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jstr
     *
     * @param jstr the value for jreal_nowcmd.jstr
     */
    public void setJstr(String jstr) {
        this.jstr = jstr;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jret_per
     *
     * @return the value of jreal_nowcmd.jret_per
     */
    public Integer getJretPer() {
        return jretPer;
    }

    /**
     */
    public JrealNowcmdEntity withJretPer(Integer jretPer) {
        this.setJretPer(jretPer);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jret_per
     *
     * @param jretPer the value for jreal_nowcmd.jret_per
     */
    public void setJretPer(Integer jretPer) {
        this.jretPer = jretPer;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jret_subper
     *
     * @return the value of jreal_nowcmd.jret_subper
     */
    public Integer getJretSubper() {
        return jretSubper;
    }

    /**
     */
    public JrealNowcmdEntity withJretSubper(Integer jretSubper) {
        this.setJretSubper(jretSubper);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jret_subper
     *
     * @param jretSubper the value for jreal_nowcmd.jret_subper
     */
    public void setJretSubper(Integer jretSubper) {
        this.jretSubper = jretSubper;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jret_int
     *
     * @return the value of jreal_nowcmd.jret_int
     */
    public Integer getJretInt() {
        return jretInt;
    }

    /**
     */
    public JrealNowcmdEntity withJretInt(Integer jretInt) {
        this.setJretInt(jretInt);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jret_int
     *
     * @param jretInt the value for jreal_nowcmd.jret_int
     */
    public void setJretInt(Integer jretInt) {
        this.jretInt = jretInt;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jret_str
     *
     * @return the value of jreal_nowcmd.jret_str
     */
    public String getJretStr() {
        return jretStr;
    }

    /**
     */
    public JrealNowcmdEntity withJretStr(String jretStr) {
        this.setJretStr(jretStr);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jret_str
     *
     * @param jretStr the value for jreal_nowcmd.jret_str
     */
    public void setJretStr(String jretStr) {
        this.jretStr = jretStr;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jtime
     *
     * @return the value of jreal_nowcmd.jtime
     */
    public Date getJtime() {
        return jtime;
    }

    /**
     */
    public JrealNowcmdEntity withJtime(Date jtime) {
        this.setJtime(jtime);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jtime
     *
     * @param jtime the value for jreal_nowcmd.jtime
     */
    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jlast_time
     *
     * @return the value of jreal_nowcmd.jlast_time
     */
    public Date getJlastTime() {
        return jlastTime;
    }

    /**
     */
    public JrealNowcmdEntity withJlastTime(Date jlastTime) {
        this.setJlastTime(jlastTime);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jlast_time
     *
     * @param jlastTime the value for jreal_nowcmd.jlast_time
     */
    public void setJlastTime(Date jlastTime) {
        this.jlastTime = jlastTime;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.juser_type
     *
     * @return the value of jreal_nowcmd.juser_type
     */
    public Integer getJuserType() {
        return juserType;
    }

    /**
     */
    public JrealNowcmdEntity withJuserType(Integer juserType) {
        this.setJuserType(juserType);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.juser_type
     *
     * @param juserType the value for jreal_nowcmd.juser_type
     */
    public void setJuserType(Integer juserType) {
        this.juserType = juserType;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.juser_show
     *
     * @return the value of jreal_nowcmd.juser_show
     */
    public String getJuserShow() {
        return juserShow;
    }

    /**
     */
    public JrealNowcmdEntity withJuserShow(String juserShow) {
        this.setJuserShow(juserShow);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.juser_show
     *
     * @param juserShow the value for jreal_nowcmd.juser_show
     */
    public void setJuserShow(String juserShow) {
        this.juserShow = juserShow;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.juser_group
     *
     * @return the value of jreal_nowcmd.juser_group
     */
    public Integer getJuserGroup() {
        return juserGroup;
    }

    /**
     */
    public JrealNowcmdEntity withJuserGroup(Integer juserGroup) {
        this.setJuserGroup(juserGroup);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.juser_group
     *
     * @param juserGroup the value for jreal_nowcmd.juser_group
     */
    public void setJuserGroup(Integer juserGroup) {
        this.juserGroup = juserGroup;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.joperator
     *
     * @return the value of jreal_nowcmd.joperator
     */
    public String getJoperator() {
        return joperator;
    }

    /**
     */
    public JrealNowcmdEntity withJoperator(String joperator) {
        this.setJoperator(joperator);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.joperator
     *
     * @param joperator the value for jreal_nowcmd.joperator
     */
    public void setJoperator(String joperator) {
        this.joperator = joperator;
    }

    /**
     * This method returns the value of the database column jreal_nowcmd.jip_addr
     *
     * @return the value of jreal_nowcmd.jip_addr
     */
    public String getJipAddr() {
        return jipAddr;
    }

    /**
     */
    public JrealNowcmdEntity withJipAddr(String jipAddr) {
        this.setJipAddr(jipAddr);
        return this;
    }

    @ApiModelProperty(dataType = "int", example = "-1", value = "门操作类型")
    private Integer operateLx;
    @ApiModelProperty(dataType = "list", value = "场所列表")
    private List<Integer> placeList;
    @ApiModelProperty(dataType = "list", value = "门列表")
    private List<String> gateList;
    private Integer timeSec;
    public Integer getOperateLx() {
        return operateLx;
    }

    public void setOperateLx(Integer operateLx) {
        this.operateLx = operateLx;
    }

    public List<Integer> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Integer> placeList) {
        this.placeList = placeList;
    }

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }

    public Integer getTimeSec() {
        return timeSec;
    }

    public void setTimeSec(Integer timeSec) {
        this.timeSec = timeSec;
    }

    /**
     * This method sets the value of the database column jreal_nowcmd.jip_addr
     *
     * @param jipAddr the value for jreal_nowcmd.jip_addr
     */
    public void setJipAddr(String jipAddr) {
        this.jipAddr = jipAddr;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}