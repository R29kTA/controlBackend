package com.hxt.controlbackend.controller;

import com.hxt.controlbackend.pojo.AirConditioning;
import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.pojo.R;
import com.hxt.controlbackend.service.DeviceService;
import com.hxt.controlbackend.service.LogService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DeviceController {
    @Resource
    private DeviceService deviceService;
    @Resource
    private LogService logService;
    @GetMapping("/api/all-device")
    public R<List<Device>> getAllDevice(){
        return new R<>(deviceService.getAllDevice());
    }
    @GetMapping("/api/device/page/{start}/{limit}")
    public R<Page<Device>> pageDevice(@PathVariable int start, @PathVariable int limit){
        return new R<>(deviceService.getDevicesByPage(start,limit));
    }
    @GetMapping("/api/device/{id}")
    public R<Device> device(@PathVariable int id){
        return new R<>(deviceService.getDevice(id));
    }

    @PostMapping("/api/device")
    public R<Device> saveDevice(@RequestBody Device device,@RequestHeader("Authorization") String token){
        Device save = deviceService.save(device);
        logService.save(token,device,"添加");
        return new R<>(save);
    }
    @PostMapping("/api/device/status")
    public R updateDeviceStatus(@RequestBody Device device,@RequestHeader("Authorization") String token){
        deviceService.updateStatus(device);
        logService.save(token,device,"更新");
        return R.ok();
    }
    @DeleteMapping("/api/device")
    public R deleteDevice(@RequestBody Device device,@RequestHeader("Authorization") String token){
        deviceService.delete(device);
        logService.save(token,device,"删除");
        return R.ok();
    }
    @GetMapping("/api/device/air-conditioning/{id}")
    public R<AirConditioning> getAirConditioning(@PathVariable Integer id){
        return new R<>(deviceService.getAirConditioning(id));
    }
    @GetMapping("/api/all-device/type/{type}")
    public R<List<Device>> getAllDeviceByType(@PathVariable String type){
        return new R<>(deviceService.getDevicesByType(type));
    }
    @PostMapping("/api/device/air-conditioning")
    public R<AirConditioning> setAirConditioning(@RequestBody AirConditioning airConditioning){
        return new R<>(deviceService.setAirConditioning(airConditioning));
    }

}
