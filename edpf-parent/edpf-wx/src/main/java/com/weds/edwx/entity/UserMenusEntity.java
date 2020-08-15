package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author sxm
 * @Description 用户功能管理
 * @Date 2018-11-24
 */
public class UserMenusEntity extends BaseEntity implements Serializable {

    /**
     * 企业编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "企业编号")
    private String companyId;

    /**
     * 用户编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "用户编号")
    private String userId;

    /**
     * 功能编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能编号")
    private String menuId;

    /**
     * 首页显示
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "首页显示")
    private Integer homeFlag;

    /**
     * 功能顺序
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "功能顺序")
    private Integer menuIdx;

    /**
     * 备注
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "备注")
    private String remark;

    /**
     * 预留字段1
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段3")
    private String spareCol3;

    /**
     * 预留字段4
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段4")
    private String spareCol4;

    /**
     * 创建用户
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建用户")
    private String ctUser;

    /**
     * 创建时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建时间")
    private String ctDate;

    /**
     * 修改用户
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改用户")
    private String ltUser;

    /**
     * 修改时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改时间")
    private String ltDate;

    private String menuIds;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 功能名称
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能名称")
    private String menuName;

    /**
     * 图标编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "图标编号")
    private String iconId;

    /**
     * URL编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "URL编号")
    private String iconUrlId;

    /**
     * This method returns the value of the database column user_menus.company_id
     *
     * @return the value of user_menus.company_id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     */
    public UserMenusEntity withCompanyId(String companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.company_id
     *
     * @param companyId the value for user_menus.company_id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * This method returns the value of the database column user_menus.user_id
     *
     * @return the value of user_menus.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public UserMenusEntity withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.user_id
     *
     * @param userId the value for user_menus.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column user_menus.menu_id
     *
     * @return the value of user_menus.menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     */
    public UserMenusEntity withMenuId(String menuId) {
        this.setMenuId(menuId);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.menu_id
     *
     * @param menuId the value for user_menus.menu_id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * This method returns the value of the database column user_menus.home_flag
     *
     * @return the value of user_menus.home_flag
     */
    public Integer getHomeFlag() {
        return homeFlag;
    }

    /**
     */
    public UserMenusEntity withHomeFlag(Integer homeFlag) {
        this.setHomeFlag(homeFlag);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.home_flag
     *
     * @param homeFlag the value for user_menus.home_flag
     */
    public void setHomeFlag(Integer homeFlag) {
        this.homeFlag = homeFlag;
    }

    /**
     * This method returns the value of the database column user_menus.menu_idx
     *
     * @return the value of user_menus.menu_idx
     */
    public Integer getMenuIdx() {
        return menuIdx;
    }

    /**
     */
    public UserMenusEntity withMenuIdx(Integer menuIdx) {
        this.setMenuIdx(menuIdx);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.menu_idx
     *
     * @param menuIdx the value for user_menus.menu_idx
     */
    public void setMenuIdx(Integer menuIdx) {
        this.menuIdx = menuIdx;
    }

    /**
     * This method returns the value of the database column user_menus.remark
     *
     * @return the value of user_menus.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public UserMenusEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.remark
     *
     * @param remark the value for user_menus.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column user_menus.spare_col1
     *
     * @return the value of user_menus.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public UserMenusEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.spare_col1
     *
     * @param spareCol1 the value for user_menus.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column user_menus.spare_col2
     *
     * @return the value of user_menus.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public UserMenusEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.spare_col2
     *
     * @param spareCol2 the value for user_menus.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column user_menus.spare_col3
     *
     * @return the value of user_menus.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public UserMenusEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.spare_col3
     *
     * @param spareCol3 the value for user_menus.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column user_menus.ct_user
     *
     * @return the value of user_menus.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public UserMenusEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.ct_user
     *
     * @param ctUser the value for user_menus.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column user_menus.ct_date
     *
     * @return the value of user_menus.ct_date
     */
    public String getCtDate() {
        return ctDate;
    }

    /**
     */
    public UserMenusEntity withCtDate(String ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.ct_date
     *
     * @param ctDate the value for user_menus.ct_date
     */
    public void setCtDate(String ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column user_menus.lt_user
     *
     * @return the value of user_menus.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public UserMenusEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.lt_user
     *
     * @param ltUser the value for user_menus.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column user_menus.lt_date
     *
     * @return the value of user_menus.lt_date
     */
    public String getLtDate() {
        return ltDate;
    }

    /**
     */
    public UserMenusEntity withLtDate(String ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column user_menus.lt_date
     *
     * @param ltDate the value for user_menus.lt_date
     */
    public void setLtDate(String ltDate) {
        this.ltDate = ltDate;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getIconUrlId() {
        return iconUrlId;
    }

    public void setIconUrlId(String iconUrlId) {
        this.iconUrlId = iconUrlId;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public String getSpareCol4() {
        return spareCol4;
    }

    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }
}