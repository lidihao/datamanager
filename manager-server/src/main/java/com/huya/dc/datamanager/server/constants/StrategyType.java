package com.huya.dc.datamanager.server.constants;

/**
 * 存储策略类型：
 * 冷数据策略：指定表进行冷数据迁移的策略
 * 清除策略：指定表进行定期清除的策略
 */
public enum StrategyType {
    COLD("冷数据策略"), CLEAR("清除策略"), COMPRESS("压缩策略"), COMBINE("合并");

    private String value;

    StrategyType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
