package com.huya.dc.datamanager.server.model;


import com.huya.dc.datamanager.server.constants.ReturnCode;

public class RestResult {
    private Integer code;
    private String message;
    private Object vo;

    public RestResult(){};

    public RestResult(ReturnCode code, String message, Object obj){
        this.code = code.getCode();
        this.message = message;
        this.vo = obj;
    }

    public RestResult(Integer code, String message, Object obj){
        this.code = code;
        this.message = message;
        this.vo = obj;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getVo() {
        return vo;
    }

    public void setVo(Object vo) {
        this.vo = vo;
    }

    public static RestResult make(ReturnCode code, String message, Object obj){
        return new RestResult(code, message, obj);
    }

    public static RestResult make(Object obj){
        return new RestResult(ReturnCode.SUCCESSED, "", obj);
    }

    public static RestResult make(){
        return new RestResult(ReturnCode.SUCCESSED, "", null);
    }
}
