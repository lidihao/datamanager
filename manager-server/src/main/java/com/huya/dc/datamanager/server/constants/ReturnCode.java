package com.huya.dc.datamanager.server.constants;

public enum  ReturnCode {

    SUCCESSED(1000), FAILED(2000);

    private Integer code;

    ReturnCode(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}