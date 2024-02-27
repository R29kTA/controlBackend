package com.hxt.controlbackend.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private Boolean status;
    private Integer runtime;
    private Double powerLimit;
    private Boolean powerSwitch;

    public Device() {
    }

    public Device(Integer id, String name, String type, Boolean status, Integer runtime, Double powerLimit, Boolean powerSwitch) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.runtime = runtime;
        this.powerLimit = powerLimit;
        this.powerSwitch = powerSwitch;
    }

    public Boolean getPowerSwitch() {
        return powerSwitch;
    }

    public void setPowerSwitch(Boolean powerSwitch) {
        this.powerSwitch = powerSwitch;
    }

    public Double getPowerLimit() {
        return powerLimit;
    }

    public void setPowerLimit(Double limit) {
        this.powerLimit = limit;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
}
