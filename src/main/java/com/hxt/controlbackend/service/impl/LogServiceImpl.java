package com.hxt.controlbackend.service.impl;

import com.hxt.controlbackend.exception.ConditionException;
import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.pojo.Log;
import com.hxt.controlbackend.pojo.User;
import com.hxt.controlbackend.repository.DeviceRepository;
import com.hxt.controlbackend.repository.LogRepository;
import com.hxt.controlbackend.repository.UserRepository;
import com.hxt.controlbackend.service.LogService;
import com.hxt.controlbackend.utils.TokenUtil;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogRepository logRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private DeviceRepository deviceRepository;
    @Override
    public Page<Log> getLog(int page,int limit) {
        page = page>1?page-1:0;
        PageRequest request = PageRequest.of(page,limit);
        return logRepository.findAllByOrderByDateDesc(request);
    }

    @Override
    public void save(String token, Device device, String action) {
        Long id = TokenUtil.verifyToken(token);
        User user = userRepository.findById(id).orElse(null);
        Device dev = deviceRepository.findById(device.getId()).orElse(null);
        if (user != null && dev != null ) {
            Log log = new Log(user.getUsername(),id.intValue(),action,dev.getStatus(),dev.getName(),dev.getId(),new Date());
            logRepository.save(log);
        }
    }

    @Override
    public Page<Log> getLogByUsername(int page, int limit, String username) {
        User user = userRepository.getUserByUsername(username);
        if (user==null){
            throw new ConditionException("查询日志失败，该用户不存在");
        }
        page = page>1?page-1:0;
        PageRequest request = PageRequest.of(page,limit);
        return logRepository.findAllByUserId(user.getId().intValue(),request);
    }

}
