package com.huya.dc.datamanager.server.constants;

/**
 * 策略周期单位
 */
@Deprecated
public enum StrategyCycleUnit {
    DAY("天"), WEEK("周"), MONTH("月"), YEAR("年");

    private String value;

    StrategyCycleUnit(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
