package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class MsgSendEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long id;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer msgState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String recordDate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String insertDate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String sendDate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String templetId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mesContent;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String msgXh;

    private String openId;

    private String mesFunction;

    private String templetContent;

    /**
     */
    private static final long serialVersionUID = 1L;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMesFunction() {
        return mesFunction;
    }

    public void setMesFunction(String mesFunction) {
        this.mesFunction = mesFunction;
    }

    public String getTempletContent() {
        return templetContent;
    }

    public void setTempletContent(String templetContent) {
        this.templetContent = templetContent;
    }

    private String keys;

    /**
     * This method returns the value of the database column MSG_SEND.ID
     *
     * @return the value of MSG_SEND.ID
     */
    public Long getId() {
        return id;
    }

    /**
     */
    public MsgSendEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.ID
     *
     * @param id the value for MSG_SEND.ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column MSG_SEND.USER_SERIAL
     *
     * @return the value of MSG_SEND.USER_SERIAL
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public MsgSendEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.USER_SERIAL
     *
     * @param userSerial the value for MSG_SEND.USER_SERIAL
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column MSG_SEND.MSG_STATE
     *
     * @return the value of MSG_SEND.MSG_STATE
     */
    public Integer getMsgState() {
        return msgState;
    }

    /**
     */
    public MsgSendEntity withMsgState(Integer msgState) {
        this.setMsgState(msgState);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.MSG_STATE
     *
     * @param msgState the value for MSG_SEND.MSG_STATE
     */
    public void setMsgState(Integer msgState) {
        this.msgState = msgState;
    }

    /**
     * This method returns the value of the database column MSG_SEND.RECORD_DATE
     *
     * @return the value of MSG_SEND.RECORD_DATE
     */
    public String getRecordDate() {
        return recordDate;
    }

    /**
     */
    public MsgSendEntity withRecordDate(String recordDate) {
        this.setRecordDate(recordDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.RECORD_DATE
     *
     * @param recordDate the value for MSG_SEND.RECORD_DATE
     */
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method returns the value of the database column MSG_SEND.INSERT_DATE
     *
     * @return the value of MSG_SEND.INSERT_DATE
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     */
    public MsgSendEntity withInsertDate(String insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.INSERT_DATE
     *
     * @param insertDate the value for MSG_SEND.INSERT_DATE
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * This method returns the value of the database column MSG_SEND.SEND_DATE
     *
     * @return the value of MSG_SEND.SEND_DATE
     */
    public String getSendDate() {
        return sendDate;
    }

    /**
     */
    public MsgSendEntity withSendDate(String sendDate) {
        this.setSendDate(sendDate);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.SEND_DATE
     *
     * @param sendDate the value for MSG_SEND.SEND_DATE
     */
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * This method returns the value of the database column MSG_SEND.TEMPLET_ID
     *
     * @return the value of MSG_SEND.TEMPLET_ID
     */
    public String getTempletId() {
        return templetId;
    }

    /**
     */
    public MsgSendEntity withTempletId(String templetId) {
        this.setTempletId(templetId);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.TEMPLET_ID
     *
     * @param templetId the value for MSG_SEND.TEMPLET_ID
     */
    public void setTempletId(String templetId) {
        this.templetId = templetId;
    }

    /**
     * This method returns the value of the database column MSG_SEND.MES_CONTENT
     *
     * @return the value of MSG_SEND.MES_CONTENT
     */
    public String getMesContent() {
        return mesContent;
    }

    /**
     */
    public MsgSendEntity withMesContent(String mesContent) {
        this.setMesContent(mesContent);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.MES_CONTENT
     *
     * @param mesContent the value for MSG_SEND.MES_CONTENT
     */
    public void setMesContent(String mesContent) {
        this.mesContent = mesContent;
    }

    /**
     * This method returns the value of the database column MSG_SEND.MSG_XH
     *
     * @return the value of MSG_SEND.MSG_XH
     */
    public String getMsgXh() {
        return msgXh;
    }

    /**
     */
    public MsgSendEntity withMsgXh(String msgXh) {
        this.setMsgXh(msgXh);
        return this;
    }

    /**
     * This method sets the value of the database column MSG_SEND.MSG_XH
     *
     * @param msgXh the value for MSG_SEND.MSG_XH
     */
    public void setMsgXh(String msgXh) {
        this.msgXh = msgXh;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}