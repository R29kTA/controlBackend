package com.hxt.controlbackend.pojo;

public class DeviceConsume {
    private String name;
    private Double consume;
    private Double limit;

    public DeviceConsume(String name, Double consume, Double limit) {
        this.name = name;
        this.consume = consume;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getConsume() {
        return consume;
    }

    public void setConsume(Double consume) {
        this.consume = consume;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }
}
