package com.huya.dc.datamanager.strategyflow.Exception;

public class BaseException extends RuntimeException {
    private Integer errorCode;
    private String errMsg;

    public BaseException(Integer errorCode, String errMsg) {
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public BaseException(String message, Integer errorCode, String errMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public BaseException(String message, Throwable cause, Integer errorCode, String errMsg) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public BaseException(Throwable cause, Integer errorCode, String errMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errorCode, String errMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
