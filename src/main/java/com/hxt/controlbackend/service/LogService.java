package com.hxt.controlbackend.service;

import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.pojo.Log;
import org.springframework.data.domain.Page;

public interface LogService {
    Page<Log> getLog(int page,int limit);
    void save(String token, Device device, String action);
    Page<Log> getLogByUsername(int page,int limit,String username);
}
