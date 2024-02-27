package com.hxt.controlbackend.controller;

import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.pojo.Log;
import com.hxt.controlbackend.pojo.R;
import com.hxt.controlbackend.service.DeviceService;
import com.hxt.controlbackend.service.LogService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LogController {
    @Resource
    private LogService logService;
    @GetMapping("/api/log/page/{start}/{size}/{name}")
    public R<Page<Log>> getLog(@PathVariable Integer size, @PathVariable Integer start, @PathVariable String name){
        return new R<>(logService.getLogByUsername(start,size,name));
    }
    @GetMapping("/api/log/page/{start}/{size}")
    public R<Page<Log>> getLog(@PathVariable Integer size, @PathVariable Integer start){
        return new R<>(logService.getLog(start,size));
    }
}
