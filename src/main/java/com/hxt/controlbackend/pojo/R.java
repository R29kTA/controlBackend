package com.hxt.controlbackend.pojo;

public class R<T> {
    private String code;
    private String msg;
    private T data;
    public R(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public R(T data) {
        this.data = data;
        msg = "success";
        code = "200";
    }
    public static R<String> ok(){
        return new R<>(null);
    }
    public static R<String> ok(String data){
        return new R<>(data);
    }
    public static R<String> fail(){
        return new R<>("1","fail");
    }
    public static R<String> fail(String code,String msg){
        return new R<>(code, msg);
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
