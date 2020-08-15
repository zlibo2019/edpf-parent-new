package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisJlAllEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String cardHao;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visPlace;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visDoor;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String doorName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Byte fx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Byte result;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jframeId;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:10:08", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jwatersn;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:10:08", value = "")
    private Date jwritetime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jdevserial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depName;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column Vis_JL_All.xh
     *
     * @return the value of Vis_JL_All.xh
     */
    public Long getXh() {
        return xh;
    }

    /**
     */
    public VisJlAllEntity withXh(Long xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.xh
     *
     * @param xh the value for Vis_JL_All.xh
     */
    public void setXh(Long xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Vis_Serial
     *
     * @return the value of Vis_JL_All.Vis_Serial
     */
    public String getVisSerial() {
        return visSerial;
    }

    /**
     */
    public VisJlAllEntity withVisSerial(String visSerial) {
        this.setVisSerial(visSerial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Vis_Serial
     *
     * @param visSerial the value for Vis_JL_All.Vis_Serial
     */
    public void setVisSerial(String visSerial) {
        this.visSerial = visSerial;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Card_Hao
     *
     * @return the value of Vis_JL_All.Card_Hao
     */
    public String getCardHao() {
        return cardHao;
    }

    /**
     */
    public VisJlAllEntity withCardHao(String cardHao) {
        this.setCardHao(cardHao);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Card_Hao
     *
     * @param cardHao the value for Vis_JL_All.Card_Hao
     */
    public void setCardHao(String cardHao) {
        this.cardHao = cardHao;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Vis_Place
     *
     * @return the value of Vis_JL_All.Vis_Place
     */
    public String getVisPlace() {
        return visPlace;
    }

    /**
     */
    public VisJlAllEntity withVisPlace(String visPlace) {
        this.setVisPlace(visPlace);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Vis_Place
     *
     * @param visPlace the value for Vis_JL_All.Vis_Place
     */
    public void setVisPlace(String visPlace) {
        this.visPlace = visPlace;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Vis_Type
     *
     * @return the value of Vis_JL_All.Vis_Type
     */
    public Integer getVisType() {
        return visType;
    }

    /**
     */
    public VisJlAllEntity withVisType(Integer visType) {
        this.setVisType(visType);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Vis_Type
     *
     * @param visType the value for Vis_JL_All.Vis_Type
     */
    public void setVisType(Integer visType) {
        this.visType = visType;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Vis_Door
     *
     * @return the value of Vis_JL_All.Vis_Door
     */
    public String getVisDoor() {
        return visDoor;
    }

    /**
     */
    public VisJlAllEntity withVisDoor(String visDoor) {
        this.setVisDoor(visDoor);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Vis_Door
     *
     * @param visDoor the value for Vis_JL_All.Vis_Door
     */
    public void setVisDoor(String visDoor) {
        this.visDoor = visDoor;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Door_Name
     *
     * @return the value of Vis_JL_All.Door_Name
     */
    public String getDoorName() {
        return doorName;
    }

    /**
     */
    public VisJlAllEntity withDoorName(String doorName) {
        this.setDoorName(doorName);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Door_Name
     *
     * @param doorName the value for Vis_JL_All.Door_Name
     */
    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.fx
     *
     * @return the value of Vis_JL_All.fx
     */
    public Byte getFx() {
        return fx;
    }

    /**
     */
    public VisJlAllEntity withFx(Byte fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.fx
     *
     * @param fx the value for Vis_JL_All.fx
     */
    public void setFx(Byte fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.Result
     *
     * @return the value of Vis_JL_All.Result
     */
    public Byte getResult() {
        return result;
    }

    /**
     */
    public VisJlAllEntity withResult(Byte result) {
        this.setResult(result);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.Result
     *
     * @param result the value for Vis_JL_All.Result
     */
    public void setResult(Byte result) {
        this.result = result;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.jFrame_id
     *
     * @return the value of Vis_JL_All.jFrame_id
     */
    public Integer getJframeId() {
        return jframeId;
    }

    /**
     */
    public VisJlAllEntity withJframeId(Integer jframeId) {
        this.setJframeId(jframeId);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.jFrame_id
     *
     * @param jframeId the value for Vis_JL_All.jFrame_id
     */
    public void setJframeId(Integer jframeId) {
        this.jframeId = jframeId;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.sj
     *
     * @return the value of Vis_JL_All.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisJlAllEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.sj
     *
     * @param sj the value for Vis_JL_All.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.jWaterSN
     *
     * @return the value of Vis_JL_All.jWaterSN
     */
    public Integer getJwatersn() {
        return jwatersn;
    }

    /**
     */
    public VisJlAllEntity withJwatersn(Integer jwatersn) {
        this.setJwatersn(jwatersn);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.jWaterSN
     *
     * @param jwatersn the value for Vis_JL_All.jWaterSN
     */
    public void setJwatersn(Integer jwatersn) {
        this.jwatersn = jwatersn;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.jWriteTime
     *
     * @return the value of Vis_JL_All.jWriteTime
     */
    public Date getJwritetime() {
        return jwritetime;
    }

    /**
     */
    public VisJlAllEntity withJwritetime(Date jwritetime) {
        this.setJwritetime(jwritetime);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.jWriteTime
     *
     * @param jwritetime the value for Vis_JL_All.jWriteTime
     */
    public void setJwritetime(Date jwritetime) {
        this.jwritetime = jwritetime;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.jDevSerial
     *
     * @return the value of Vis_JL_All.jDevSerial
     */
    public String getJdevserial() {
        return jdevserial;
    }

    /**
     */
    public VisJlAllEntity withJdevserial(String jdevserial) {
        this.setJdevserial(jdevserial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.jDevSerial
     *
     * @param jdevserial the value for Vis_JL_All.jDevSerial
     */
    public void setJdevserial(String jdevserial) {
        this.jdevserial = jdevserial;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.user_name
     *
     * @return the value of Vis_JL_All.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     */
    public VisJlAllEntity withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.user_name
     *
     * @param userName the value for Vis_JL_All.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the value of the database column Vis_JL_All.dep_name
     *
     * @return the value of Vis_JL_All.dep_name
     */
    public String getDepName() {
        return depName;
    }

    /**
     */
    public VisJlAllEntity withDepName(String depName) {
        this.setDepName(depName);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_JL_All.dep_name
     *
     * @param depName the value for Vis_JL_All.dep_name
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
}