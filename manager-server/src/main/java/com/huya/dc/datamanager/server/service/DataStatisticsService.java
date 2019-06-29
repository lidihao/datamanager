package com.huya.dc.datamanager.server.service;

import com.github.pagehelper.PageInfo;
import com.huya.dc.datamanager.server.model.DatabaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.TableStatisticsInfo;

import java.util.List;
import java.util.Map;

public interface DataStatisticsService {
    TableStatisticsInfo getDataRatioInfo(String databaseName, String tableName);
    DatabaseStatisticsInfo getDataRatioInfoTotalDataBase(String databaseName);
    PageInfo<TableStatisticsInfo> getDataRatioListByDataBaseNamePageable(String databaseName, Map<String,String> sortMap, Integer pageNum);
    PageInfo<TableStatisticsInfo> getDataRatioListByTableNamePatternPageable(String databaseName,String tableNamePattern,Map<String,String> sortMap,Integer pageNum);
}
