package com.hxt.controlbackend.pojo;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private Integer userId;
    private String action;
    private Boolean status;
    private String device;
    private Integer deviceId;
    private Date date;

    public Log() {
    }

    public Log(String username, Integer userId, String action, Boolean status, String device, Integer deviceId, Date date) {
        this.username = username;
        this.userId = userId;
        this.action = action;
        this.status = status;
        this.device = device;
        this.deviceId = deviceId;
        this.date = date;
    }

    public Log(Integer id, String username, Integer userId, String action, Boolean status, String device, Integer deviceId, Date date) {
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.action = action;
        this.status = status;
        this.device = device;
        this.deviceId = deviceId;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
