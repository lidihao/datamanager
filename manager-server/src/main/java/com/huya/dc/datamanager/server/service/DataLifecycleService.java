package com.huya.dc.datamanager.server.service;

import com.huya.dc.datamanager.server.constants.StrategyCycleUnit;
import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.model.StrategyProperty;
import com.huya.dc.datamanager.server.model.TableStrategy;

import java.util.List;

/**
 * 数据生命周期相关服务：
 * 数据生命周期管理
 * 数据冷热配置管理
 */
public interface DataLifecycleService {
    TableStrategy setTableStrategy(String database, String table, Integer cycleVal, StrategyType strategyType, String user, List<StrategyProperty> strategyProperties);

    void delTableStrategy(String database, String table, StrategyType strategyType);

    List<TableStrategy> getTableStrategys(String database, String table);

    TableStrategy getTableStrategy(String database, String table, StrategyType strategyType);
}
