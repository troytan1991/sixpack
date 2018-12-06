package com.troytan.sixpack.dto;

import java.util.List;

public class PlanDetailDto {

    private Integer         planId;
    private Short           level;
    private Short           trainingDay;
    private Short           totalDay;
    private String          cost;
    private Boolean         vocation;
    private List<Excercise> excercises;

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

    public Short getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Short totalDay) {
        this.totalDay = totalDay;
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

    public List<Excercise> getExcercises() {
        return excercises;
    }

    public void setExcercises(List<Excercise> excercises) {
        this.excercises = excercises;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

}
