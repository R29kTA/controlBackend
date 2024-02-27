package com.hxt.controlbackend.exception;

import java.io.Serial;

public class ConditionException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    private String code;
    public ConditionException(String code, String name){
        super(name);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ConditionException(String name){
        super(name);
        code = "500";
    }



}
