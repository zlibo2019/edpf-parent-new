package com.weds.edwx.entity;

public class VisitorEntity {
    private VisRegisterEntity visRegisterEntity;
    private VisUserEntity visUserEntity;

    public VisRegisterEntity getVisRegisterEntity() {
        return visRegisterEntity;
    }

    public void setVisRegisterEntity(VisRegisterEntity visRegisterEntity) {
        this.visRegisterEntity = visRegisterEntity;
    }

    public VisUserEntity getVisUserEntity() {
        return visUserEntity;
    }

    public void setVisUserEntity(VisUserEntity visUserEntity) {
        this.visUserEntity = visUserEntity;
    }
}
