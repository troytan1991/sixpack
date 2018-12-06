package com.troytan.sixpack.dto;

public class PlanDto {

    private Integer planId;
    private Short   level;
    private Short   trainingDay;
    private String  cost;
    private Boolean vocation;
    private Short   status;     // 0解锁,1一半进度,2完成

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Short getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(Short trainingDay) {
        this.trainingDay = trainingDay;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Boolean getVocation() {
        return vocation;
    }

    public void setVocation(Boolean vocation) {
        this.vocation = vocation;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

}
