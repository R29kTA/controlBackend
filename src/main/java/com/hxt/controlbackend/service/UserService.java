package com.hxt.controlbackend.service;

import com.hxt.controlbackend.pojo.JwtToken;
import com.hxt.controlbackend.pojo.LoginParma;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public JwtToken login(LoginParma loginParma);
    JwtToken refreshToken(String token);
}
