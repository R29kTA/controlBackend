package com.hxt.controlbackend.config;

import com.hxt.controlbackend.pojo.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public R<String> exceptionHandler(Exception e){
        return R.fail("501",e.getMessage());
    }
}
