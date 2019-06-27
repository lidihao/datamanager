package com.huya.dc.datamanager.server.utils;

import org.apache.commons.lang3.StringUtils;


public class AssertUtils {
    public static void notEmpty(String val, String msg){
        if(StringUtils.isBlank(val)){
            throw new IllegalArgumentException(msg);
        }
    }

    public static void notNull(Object val, String msg){
        if(val == null){
            throw new IllegalArgumentException(msg);
        }
    }

    public static void notGT0(Integer val, String msg){
        if(val == null || val <= 0){
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isTrue(Boolean val, String msg){
        if(!val){
            throw new IllegalArgumentException(msg);
        }
    }
}
