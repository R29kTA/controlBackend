package com.hxt.controlbackend.config;

import com.hxt.controlbackend.exception.ConditionException;
import com.hxt.controlbackend.pojo.AirConditioning;
import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.repository.DeviceRepository;
import com.hxt.controlbackend.service.DeviceService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class AirConditioningSimulator {
    @Resource
    private DeviceRepository deviceRepository;
    List<AirConditioning> airs = new ArrayList<>();
    @Bean
    public List<AirConditioning> initAirConditioning(){
        String type = "空调";
        List<Device> air = deviceRepository.getDevicesByType(type);
        Random random = new Random();
        int min = 16; // 最小值
        int max = 30; // 最大值
        int temp;
        for (Device device : air) {
             temp = random.nextInt((max - min) + 1) + min;
            airs.add(new AirConditioning(device, temp, false));
        }
        return airs;
    }
    public AirConditioning getAirConditioning(Integer id) {
        for (AirConditioning air : airs) {
            if (air.getId().intValue() ==  id){
                return air;
            }
        }
        throw new ConditionException("设备未找到");
    }
    public AirConditioning setAirConditioning(Integer id,Integer temp,Boolean mode){
        for (AirConditioning air : airs) {
            if (air.getId().intValue() == id) {
                air.setMode(mode);
                air.setTemperature(temp);
                return air;
            }
        }
        throw new ConditionException("设备未找到");
    }
}
