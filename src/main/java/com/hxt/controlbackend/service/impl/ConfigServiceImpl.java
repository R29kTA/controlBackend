package com.hxt.controlbackend.service.impl;

import com.hxt.controlbackend.pojo.Config;
import com.hxt.controlbackend.repository.ConfigRepository;
import com.hxt.controlbackend.service.ConfigService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigRepository configRepository;

    @Override
    public Config getConfig() {
        Config byId = configRepository.findById(1).orElse(null);
        if (byId==null){
            return null;
        }
        if (byId.getLatitude()==null||byId.getLongitude()==null) {
            return null;
        }
        return byId;
    }

    @Override
    public Config setConfig(Config config) {
        if (configRepository.existsById(1)) {
            config.setId(1);
        }
        return configRepository.save(config);
    }
}
