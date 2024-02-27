package com.hxt.controlbackend.controller;

import com.hxt.controlbackend.pojo.DayPower;
import com.hxt.controlbackend.pojo.DeviceConsume;
import com.hxt.controlbackend.pojo.R;
import com.hxt.controlbackend.service.PowerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PowerController {
    @Resource
    private PowerService powerService;

    @GetMapping("/day-power/{month}")
    public R<List<DayPower>> dayPower(@PathVariable Integer month){
        return new R<>(powerService.getDatePower(month));
    }
    @GetMapping("/device-power/{month}")
    public R<List<DeviceConsume> > devicePower(@PathVariable Integer month){
       return new R<>(powerService.getDevicePower(month));
    }
}
