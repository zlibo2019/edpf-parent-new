package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class NEWSEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer newsState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String newsTitle;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String newsValues;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-01-03 16:04:08", value = "")
    private Date newsDate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "人员序号")
    private Long userSerial;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "消息是否已读 0 未读；1 已读")
    private Integer isRead;

    public Long getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column TT_NEWS.Xh
     *
     * @return the value of TT_NEWS.Xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public NEWSEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.Xh
     *
     * @param xh the value for TT_NEWS.Xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column TT_NEWS.Lx
     *
     * @return the value of TT_NEWS.Lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public NEWSEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.Lx
     *
     * @param lx the value for TT_NEWS.Lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column TT_NEWS.News_state
     *
     * @return the value of TT_NEWS.News_state
     */
    public Integer getNewsState() {
        return newsState;
    }

    /**
     */
    public NEWSEntity withNewsState(Integer newsState) {
        this.setNewsState(newsState);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.News_state
     *
     * @param newsState the value for TT_NEWS.News_state
     */
    public void setNewsState(Integer newsState) {
        this.newsState = newsState;
    }

    /**
     * This method returns the value of the database column TT_NEWS.News_title
     *
     * @return the value of TT_NEWS.News_title
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     */
    public NEWSEntity withNewsTitle(String newsTitle) {
        this.setNewsTitle(newsTitle);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.News_title
     *
     * @param newsTitle the value for TT_NEWS.News_title
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * This method returns the value of the database column TT_NEWS.News_values
     *
     * @return the value of TT_NEWS.News_values
     */
    public String getNewsValues() {
        return newsValues;
    }

    /**
     */
    public NEWSEntity withNewsValues(String newsValues) {
        this.setNewsValues(newsValues);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.News_values
     *
     * @param newsValues the value for TT_NEWS.News_values
     */
    public void setNewsValues(String newsValues) {
        this.newsValues = newsValues;
    }

    /**
     * This method returns the value of the database column TT_NEWS.News_date
     *
     * @return the value of TT_NEWS.News_date
     */
    public Date getNewsDate() {
        return newsDate;
    }

    /**
     */
    public NEWSEntity withNewsDate(Date newsDate) {
        this.setNewsDate(newsDate);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.News_date
     *
     * @param newsDate the value for TT_NEWS.News_date
     */
    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    /**
     * This method returns the value of the database column TT_NEWS.Gly_no
     *
     * @return the value of TT_NEWS.Gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public NEWSEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column TT_NEWS.Gly_no
     *
     * @param glyNo the value for TT_NEWS.Gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }
}