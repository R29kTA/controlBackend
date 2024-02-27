package com.hxt.controlbackend.service;

import com.hxt.controlbackend.pojo.AirConditioning;
import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.pojo.R;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeviceService {
    public Device getDevice(Integer id);
    List<Device> getAllDevice();
    Device save(Device device);
    void delete(Device device);
    void updateStatus(Device device);
    Device getDeviceByType(String type);
    List<Device> getDevicesByType(String type);
    AirConditioning getAirConditioning(Integer id);
    Page<Device> getDevicesByPage(int page, int limit);
    AirConditioning setAirConditioning(AirConditioning airConditioning);
}
