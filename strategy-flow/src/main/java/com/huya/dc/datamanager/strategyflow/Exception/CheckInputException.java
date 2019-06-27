package com.huya.dc.datamanager.strategyflow.Exception;

public class CheckInputException extends BaseException {
    public CheckInputException(String errMsg) {
        super(ExceptionCode.ERROR, errMsg);
    }

    public CheckInputException(Throwable cause, String errMsg) {
        super(cause, ExceptionCode.ERROR, errMsg);
    }

    public CheckInputException(Integer errorCode, String errMsg) {
        super(errorCode, errMsg);
    }

    public CheckInputException(String message, Integer errorCode, String errMsg) {
        super(message, errorCode, errMsg);
    }

    public CheckInputException(String message, Throwable cause, Integer errorCode, String errMsg) {
        super(message, cause, errorCode, errMsg);
    }

    public CheckInputException(Throwable cause, Integer errorCode, String errMsg) {
        super(cause, errorCode, errMsg);
    }

    public CheckInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errorCode, String errMsg) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode, errMsg);
    }
}
