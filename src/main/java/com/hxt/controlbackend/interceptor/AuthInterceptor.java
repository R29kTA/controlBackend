package com.hxt.controlbackend.interceptor;

import com.hxt.controlbackend.exception.ConditionException;
import com.hxt.controlbackend.pojo.JwtToken;
import com.hxt.controlbackend.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        if (method.equals("OPTIONS")){
            return true;
        }
        if (uri.equals("/api/login")){
            return true;
        }
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new ConditionException("未登录");
        }
        TokenUtil.verifyToken(authorization);
        return true;
    }
}
