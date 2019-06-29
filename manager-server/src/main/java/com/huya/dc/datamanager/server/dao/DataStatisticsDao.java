package com.huya.dc.datamanager.server.dao;


import com.huya.dc.datamanager.server.model.DatabaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.TableStatisticsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DataStatisticsDao {
    TableStatisticsInfo getTableStatisticsInfo(String databaseName, String tableName, String date);
    DatabaseStatisticsInfo getDataBaseStatisticsInfo(String databaseName, String date);
    String getNearDate();
    List<TableStatisticsInfo> getDataRatioByDataBaseName(Map<String,String> sortMap, String databaseName, String date);
    List<TableStatisticsInfo> getDataRatioByTableNamePattern(Map<String,String> sortMap, String databaseName, String date,String tableNamePattern);
}
