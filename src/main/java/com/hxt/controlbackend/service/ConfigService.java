package com.hxt.controlbackend.service;

import com.hxt.controlbackend.pojo.Config;

public interface ConfigService {
    Config getConfig();
    Config setConfig(Config config);
}
