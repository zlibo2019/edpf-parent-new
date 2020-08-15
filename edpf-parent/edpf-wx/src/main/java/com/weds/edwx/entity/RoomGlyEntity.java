package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class RoomGlyEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer id;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer roomSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer roomLx;

    /**
     *
     */
    @Size(max = 30)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     *
     */
    @Size(max = 30)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ip;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-11-28 11:50:05", value = "")
    private Date sj;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    private String userLname;

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    /**
     * This method returns the value of the database column room_gly.id
     *
     * @return the value of room_gly.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public RoomGlyEntity withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.id
     *
     * @param id the value for room_gly.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column room_gly.user_serial
     *
     * @return the value of room_gly.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public RoomGlyEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.user_serial
     *
     * @param userSerial the value for room_gly.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column room_gly.room_serial
     *
     * @return the value of room_gly.room_serial
     */
    public Integer getRoomSerial() {
        return roomSerial;
    }

    /**
     */
    public RoomGlyEntity withRoomSerial(Integer roomSerial) {
        this.setRoomSerial(roomSerial);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.room_serial
     *
     * @param roomSerial the value for room_gly.room_serial
     */
    public void setRoomSerial(Integer roomSerial) {
        this.roomSerial = roomSerial;
    }

    /**
     * This method returns the value of the database column room_gly.room_lx
     *
     * @return the value of room_gly.room_lx
     */
    public Integer getRoomLx() {
        return roomLx;
    }

    /**
     */
    public RoomGlyEntity withRoomLx(Integer roomLx) {
        this.setRoomLx(roomLx);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.room_lx
     *
     * @param roomLx the value for room_gly.room_lx
     */
    public void setRoomLx(Integer roomLx) {
        this.roomLx = roomLx;
    }

    /**
     * This method returns the value of the database column room_gly.gly_no
     *
     * @return the value of room_gly.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public RoomGlyEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.gly_no
     *
     * @param glyNo the value for room_gly.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column room_gly.ip
     *
     * @return the value of room_gly.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     */
    public RoomGlyEntity withIp(String ip) {
        this.setIp(ip);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.ip
     *
     * @param ip the value for room_gly.ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * This method returns the value of the database column room_gly.sj
     *
     * @return the value of room_gly.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public RoomGlyEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column room_gly.sj
     *
     * @param sj the value for room_gly.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}