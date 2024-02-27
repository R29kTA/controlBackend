package com.hxt.controlbackend.service.impl;

import com.hxt.controlbackend.exception.ConditionException;
import com.hxt.controlbackend.pojo.JwtToken;
import com.hxt.controlbackend.pojo.LoginParma;
import com.hxt.controlbackend.pojo.User;
import com.hxt.controlbackend.repository.UserRepository;
import com.hxt.controlbackend.service.UserService;
import com.hxt.controlbackend.utils.TokenUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Override
    public JwtToken login(LoginParma loginParma) {
        String username = loginParma.getUsername();
        String password = loginParma.getPassword();
        User user;
        if (!(StringUtils.hasText(username) && StringUtils.hasText(password))){
            throw new ConditionException("参数错误");
        }
        user= userRepository.getUserByUsername(username);
        if (user==null || !password.equals(user.getPassword())){
            throw new ConditionException("用户名或密码错误");
        }
        JwtToken jwtToken;
        try {
            jwtToken =  TokenUtil.generateToken(user.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        jwtToken.setUsername(username);
        ArrayList<String> roles = new ArrayList<>();
        roles.add("admin");
        jwtToken.setRoles(roles);
        return jwtToken;
    }

    @Override
    public JwtToken refreshToken(String token) {
        Long id = TokenUtil.verifyToken(token);
        JwtToken jwtToken;
        try {
            jwtToken =  TokenUtil.generateToken(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        User user= userRepository.findById(id).orElse(new User());
        jwtToken.setUsername(user.getUsername());
        ArrayList<String> roles = new ArrayList<>();
        roles.add("admin");
        jwtToken.setRoles(roles);
        return jwtToken;
    }
}
