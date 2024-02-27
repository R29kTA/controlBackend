package com.hxt.controlbackend.pojo;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "power")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer deviceId;
    private Double power;
    private Date date;

    public Power() {
    }

    public Power(Integer id, Integer deviceId, Double power, Date date) {
        this.id = id;
        this.deviceId = deviceId;
        this.power = power;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", power=" + power +
                ", date=" + date +
                '}';
    }
}
