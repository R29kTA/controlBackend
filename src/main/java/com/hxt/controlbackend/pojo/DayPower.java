package com.hxt.controlbackend.pojo;

public class DayPower {
    private Integer day;
    private Double power;

    public DayPower() {
    }

    public DayPower(Integer day, Double power) {
        this.day = day;
        this.power = power;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
}
