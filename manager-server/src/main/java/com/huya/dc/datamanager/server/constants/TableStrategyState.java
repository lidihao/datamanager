package com.huya.dc.datamanager.server.constants;

public enum TableStrategyState {
    NEW("新建"), SCHEDULED("计划已生成"), STOP("策略停止");

    private String value;

    TableStrategyState(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
