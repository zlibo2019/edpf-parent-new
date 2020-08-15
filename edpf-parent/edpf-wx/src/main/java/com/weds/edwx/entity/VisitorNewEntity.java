package com.weds.edwx.entity;

public class VisitorNewEntity {
    private VisRegisterNewEntity visRegisterEntity;

    private VisUserNewEntity visUserEntity;

    private String type;

    public VisRegisterNewEntity getVisRegisterEntity() {
        return visRegisterEntity;
    }

    public void setVisRegisterEntity(VisRegisterNewEntity visRegisterEntity) {
        this.visRegisterEntity = visRegisterEntity;
    }

    public VisUserNewEntity getVisUserEntity() {
        return visUserEntity;
    }

    public void setVisUserEntity(VisUserNewEntity visUserEntity) {
        this.visUserEntity = visUserEntity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
