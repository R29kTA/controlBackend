package com.hxt.controlbackend.service;

import com.hxt.controlbackend.pojo.DayPower;
import com.hxt.controlbackend.pojo.DeviceConsume;
import com.hxt.controlbackend.pojo.Power;

import java.util.List;

public interface PowerService {
    public List<Power> getPower();
    List<DayPower> getDatePower(int month);
    List<DeviceConsume> getDevicePower(int month);
}
