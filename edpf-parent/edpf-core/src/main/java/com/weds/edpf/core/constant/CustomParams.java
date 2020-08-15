package com.weds.edpf.core.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.custom")
public class CustomParams {

    // 东药定制 年假申请
    private Integer leave = 0;

    // 东药定制 考勤点关联人员
    private Integer location = 0;

    private boolean outsideMsg;

    public Integer getLeave() {
        return leave;
    }

    public void setLeave(Integer leave) {
        this.leave = leave;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public boolean isOutsideMsg() {
        return outsideMsg;
    }

    public void setOutsideMsg(boolean outsideMsg) {
        this.outsideMsg = outsideMsg;
    }
}
