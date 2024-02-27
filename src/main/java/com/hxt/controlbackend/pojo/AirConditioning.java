package com.hxt.controlbackend.pojo;

public class AirConditioning extends Device{
    private Integer temperature;
    // 两种模式 true 热
    private Boolean mode;
    public AirConditioning(){

    }
    public AirConditioning(Integer temperature, Boolean mode) {
        this.temperature = temperature;
        this.mode = mode;
    }
    public AirConditioning(Device device,Integer temperature, Boolean mode) {
        super(device.getId(),device.getName(), device.getType(), device.getStatus(), device.getRuntime(), device.getPowerLimit(), device.getPowerSwitch());
        this.temperature = temperature;
        this.mode = mode;
    }
    public AirConditioning(Integer id, String name, String type, Boolean status, Integer runtime, Double powerLimit, Boolean powerSwitch, Integer temperature, Boolean mode) {
        super(id, name, type, status, runtime, powerLimit, powerSwitch);
        this.temperature = temperature;
        this.mode = mode;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Boolean getMode() {
        return mode;
    }

    public void setMode(Boolean mode) {
        this.mode = mode;
    }
}
