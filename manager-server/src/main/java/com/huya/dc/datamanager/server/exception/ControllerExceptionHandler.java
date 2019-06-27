package com.huya.dc.datamanager.server.exception;


import com.huya.dc.datamanager.server.constants.ReturnCode;
import com.huya.dc.datamanager.server.model.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理，返回JSON格式
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public RestResult handleIllegalArgumentException(Exception e){
        logger.error(e.getMessage(), e);
        return RestResult.make(ReturnCode.FAILED, e.getMessage(), e);
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public RestResult handleRuntimeException(Exception e){
        logger.error(e.getMessage(), e);
        return RestResult.make(ReturnCode.FAILED, e.getMessage(), e);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RestResult handleUnknownException(Exception e){
        logger.error(e.getMessage(), e);
        return RestResult.make(ReturnCode.FAILED, e.getMessage(), e);
    }
}
