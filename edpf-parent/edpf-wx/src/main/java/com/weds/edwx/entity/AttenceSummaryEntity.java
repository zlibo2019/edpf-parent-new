package com.weds.edwx.entity;

public class AttenceSummaryEntity {

    private String total;

    private String actualTotal;

    private String late;

    private String leave;

    private String absenteeism;

    private String goout;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(String actualTotal) {
        this.actualTotal = actualTotal;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public String getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(String absenteeism) {
        this.absenteeism = absenteeism;
    }

    public String getGoout() {
        return goout;
    }

    public void setGoout(String goout) {
        this.goout = goout;
    }
}
