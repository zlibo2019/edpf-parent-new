package com.weds.edpf.core.entity;

import java.util.List;

public class DepUserEntity {
    private List<DepEntity> depList;
    private List<UserBaseEntity> userList;

    public List<DepEntity> getDepList() {
        return depList;
    }

    public void setDepList(List<DepEntity> depList) {
        this.depList = depList;
    }

    public List<UserBaseEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserBaseEntity> userList) {
        this.userList = userList;
    }
}
