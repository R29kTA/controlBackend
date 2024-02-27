package com.hxt.controlbackend.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "config")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 家名称
    private String name;
    // 电费费率
    private Double powerRate;
    // 区域面积
    private Integer area;
    // 电费限制
    private Double powerLimit;
    // 经纬度
    private Float latitude;
    private Float longitude;
    // 超过电费限制是否关闭所有电器;
    private Boolean powerSwitch;
    //位置
    private String location;

    public Config() {
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", powerRate=" + powerRate +
                ", area=" + area +
                ", powerLimit=" + powerLimit +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", powerSwitch=" + powerSwitch +
                ", location='" + location + '\'' +
                '}';
    }

    public Config(Integer id, String name, Double powerRate, Integer area, Double powerLimit, Float latitude, Float longitude, Boolean powerSwitch, String location) {
        this.id = id;
        this.name = name;
        this.powerRate = powerRate;
        this.area = area;
        this.powerLimit = powerLimit;
        this.latitude = latitude;
        this.longitude = longitude;
        this.powerSwitch = powerSwitch;
        this.location = location;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Boolean getPowerSwitch() {
        return powerSwitch;
    }

    public void setPowerSwitch(Boolean powerSwitch) {
        this.powerSwitch = powerSwitch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPowerRate() {
        return powerRate;
    }

    public void setPowerRate(Double powerRate) {
        this.powerRate = powerRate;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getPowerLimit() {
        return powerLimit;
    }

    public void setPowerLimit(Double powerLimit) {
        this.powerLimit = powerLimit;
    }
}
