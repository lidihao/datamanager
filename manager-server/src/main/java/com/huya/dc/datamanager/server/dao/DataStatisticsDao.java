package com.huya.dc.datamanager.server.dao;


import com.huya.dc.datamanager.server.model.DataBaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.vo.DataListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DataStatisticsDao {
    DataBaseStatisticsInfo getTableStatisticsInfo(String databaseName,String tableName,String date);
    DataBaseStatisticsInfo getDataBaseStatisticsInfo(String databaseName,String date);
    String getNearDate();
    List<DataListVo> getDataRatioByDataBaseName(Map<String,String> sortMap, String databaseName, String date);
    List<DataListVo> getDataRatioByTableNamePattern(Map<String,String> sortMap, String databaseName, String date,String tableNamePattern);
}
