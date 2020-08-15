package com.weds.edwx.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.visitor")
public class VisitorParams {
    // 门卫是否看到自身记录
    private boolean doorKeeperSelf;

    // 是否有微信端
    private String wxAppFlag = "0";

    // 是否有停车场
    private String ptAppFlag = "0";

    // 是否有梯控
    private String tkAppFlag = "0";

    // 是否需要门卫审核
    private String doorKeeperApprove = "1";

    // 设备类型 0 公司 1 商汤
    private String deviceType = "0";

    public boolean isDoorKeeperSelf() {
        return doorKeeperSelf;
    }

    public void setDoorKeeperSelf(boolean doorKeeperSelf) {
        this.doorKeeperSelf = doorKeeperSelf;
    }

    public String getWxAppFlag() {
        return wxAppFlag;
    }

    public void setWxAppFlag(String wxAppFlag) {
        this.wxAppFlag = wxAppFlag;
    }

    public String getPtAppFlag() {
        return ptAppFlag;
    }

    public void setPtAppFlag(String ptAppFlag) {
        this.ptAppFlag = ptAppFlag;
    }

    public String getDoorKeeperApprove() {
        return doorKeeperApprove;
    }

    public void setDoorKeeperApprove(String doorKeeperApprove) {
        this.doorKeeperApprove = doorKeeperApprove;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getTkAppFlag() {
        return tkAppFlag;
    }

    public void setTkAppFlag(String tkAppFlag) {
        this.tkAppFlag = tkAppFlag;
    }
}
