package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisCardUserEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String acType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long visSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String cardHao;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visFlg;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer upJl;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:10:58", value = "")
    private Date kssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:10:58", value = "")
    private Date jssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:10:58", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column Vis_card_user.xh
     *
     * @return the value of Vis_card_user.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisCardUserEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.xh
     *
     * @param xh the value for Vis_card_user.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column Vis_card_user.bh
     *
     * @return the value of Vis_card_user.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public VisCardUserEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.bh
     *
     * @param bh the value for Vis_card_user.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column Vis_card_user.ac_type
     *
     * @return the value of Vis_card_user.ac_type
     */
    public String getAcType() {
        return acType;
    }

    /**
     */
    public VisCardUserEntity withAcType(String acType) {
        this.setAcType(acType);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.ac_type
     *
     * @param acType the value for Vis_card_user.ac_type
     */
    public void setAcType(String acType) {
        this.acType = acType;
    }

    /**
     * This method returns the value of the database column Vis_card_user.vis_serial
     *
     * @return the value of Vis_card_user.vis_serial
     */
    public Long getVisSerial() {
        return visSerial;
    }

    /**
     */
    public VisCardUserEntity withVisSerial(Long visSerial) {
        this.setVisSerial(visSerial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.vis_serial
     *
     * @param visSerial the value for Vis_card_user.vis_serial
     */
    public void setVisSerial(Long visSerial) {
        this.visSerial = visSerial;
    }

    /**
     * This method returns the value of the database column Vis_card_user.card_hao
     *
     * @return the value of Vis_card_user.card_hao
     */
    public String getCardHao() {
        return cardHao;
    }

    /**
     */
    public VisCardUserEntity withCardHao(String cardHao) {
        this.setCardHao(cardHao);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.card_hao
     *
     * @param cardHao the value for Vis_card_user.card_hao
     */
    public void setCardHao(String cardHao) {
        this.cardHao = cardHao;
    }

    /**
     * This method returns the value of the database column Vis_card_user.vis_flg
     *
     * @return the value of Vis_card_user.vis_flg
     */
    public Integer getVisFlg() {
        return visFlg;
    }

    /**
     */
    public VisCardUserEntity withVisFlg(Integer visFlg) {
        this.setVisFlg(visFlg);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.vis_flg
     *
     * @param visFlg the value for Vis_card_user.vis_flg
     */
    public void setVisFlg(Integer visFlg) {
        this.visFlg = visFlg;
    }

    /**
     * This method returns the value of the database column Vis_card_user.up_jl
     *
     * @return the value of Vis_card_user.up_jl
     */
    public Integer getUpJl() {
        return upJl;
    }

    /**
     */
    public VisCardUserEntity withUpJl(Integer upJl) {
        this.setUpJl(upJl);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.up_jl
     *
     * @param upJl the value for Vis_card_user.up_jl
     */
    public void setUpJl(Integer upJl) {
        this.upJl = upJl;
    }

    /**
     * This method returns the value of the database column Vis_card_user.kssj
     *
     * @return the value of Vis_card_user.kssj
     */
    public Date getKssj() {
        return kssj;
    }

    /**
     */
    public VisCardUserEntity withKssj(Date kssj) {
        this.setKssj(kssj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.kssj
     *
     * @param kssj the value for Vis_card_user.kssj
     */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
     * This method returns the value of the database column Vis_card_user.jssj
     *
     * @return the value of Vis_card_user.jssj
     */
    public Date getJssj() {
        return jssj;
    }

    /**
     */
    public VisCardUserEntity withJssj(Date jssj) {
        this.setJssj(jssj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.jssj
     *
     * @param jssj the value for Vis_card_user.jssj
     */
    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    /**
     * This method returns the value of the database column Vis_card_user.sj
     *
     * @return the value of Vis_card_user.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisCardUserEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.sj
     *
     * @param sj the value for Vis_card_user.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column Vis_card_user.gly_no
     *
     * @return the value of Vis_card_user.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisCardUserEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_card_user.gly_no
     *
     * @param glyNo the value for Vis_card_user.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}