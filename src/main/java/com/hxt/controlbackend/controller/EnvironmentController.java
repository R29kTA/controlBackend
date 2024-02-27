package com.hxt.controlbackend.controller;

import com.hxt.controlbackend.pojo.Config;
import com.hxt.controlbackend.pojo.Environment;
import com.hxt.controlbackend.pojo.R;
import com.hxt.controlbackend.service.ConfigService;
import com.hxt.controlbackend.service.EnvironmentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EnvironmentController {
    @Resource
    private EnvironmentService environmentService;
    @Resource
    private ConfigService configService;
    @GetMapping("/environment")
    public R<Environment> environment(){
        return new R<>(environmentService.getEnvironmentInfo());
    }
    @GetMapping("/config")
    public R<Config> config(){
        return new R<>(configService.getConfig());
    }
    @PostMapping("/config")
    public R<Config> setConfig(@RequestBody Config config){
        return new R<>(configService.setConfig(config));
    }
}
