package com.hxt.controlbackend.service.impl;

import com.hxt.controlbackend.config.AirConditioningSimulator;
import com.hxt.controlbackend.exception.ConditionException;
import com.hxt.controlbackend.pojo.AirConditioning;
import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.repository.DeviceRepository;
import com.hxt.controlbackend.service.DeviceService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
    @Resource
    private DeviceRepository deviceRepository;
    @Resource
    private AirConditioningSimulator airConditioningSimulator;
    @Override
    public Device getDevice(Integer id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Device> getAllDevice() {
        List<Device> all = deviceRepository.findAll();
        return all;
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public void delete(Device device) {
         deviceRepository.deleteById(device.getId());
    }

    @Override
    public void updateStatus(Device device) {;
        deviceRepository.updateDevice(device.getId(),device.getStatus());
    }


    @Override
    public Device getDeviceByType(String type) {
        return deviceRepository.getDeviceByType(type);
    }

    @Override
    public List<Device> getDevicesByType(String type) {
        return deviceRepository.getDevicesByType(type);
    }

    @Override
    public AirConditioning getAirConditioning(Integer id) {
        String type = "空调";
        AirConditioning airConditioning;
        Device device = deviceRepository.getDeviceByTypeAndId(type, id);
        if (device==null){
          throw new ConditionException("设备不存在");
        }
        // 查空调数据
        AirConditioning info = airConditioningSimulator.getAirConditioning(id);
        airConditioning = new AirConditioning(device,info.getTemperature(),info.getMode());
        return airConditioning;
    }

    @Override
    public Page<Device> getDevicesByPage(int page, int limit) {
        page = page>1?page-1:0;
        PageRequest request = PageRequest.of(page,limit);
        Page<Device> devices = deviceRepository.findAll(request);
        return devices;
    }

    @Override
    public AirConditioning setAirConditioning(AirConditioning airConditioning) {
        return airConditioningSimulator
                .setAirConditioning(airConditioning.getId(),
                        airConditioning.getTemperature(),
                        airConditioning.getMode());

    }


}
