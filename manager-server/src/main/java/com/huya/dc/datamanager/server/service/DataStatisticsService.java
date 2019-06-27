package com.huya.dc.datamanager.server.service;

import com.huya.dc.datamanager.server.model.vo.DataListVo;
import com.huya.dc.datamanager.server.model.vo.DataRatioInfoVo;

import java.util.List;
import java.util.Map;

public interface DataStatisticsService {
    DataRatioInfoVo getDataRatioInfo(String databaseName,String tableName);
    DataRatioInfoVo getDataRatioInfoTotalDataBase(String databaseName);
    List<DataListVo> getDataRatioListByDataBaseName(String databaseName, Map<String,String> sortMap,Integer pageNum);
    List<DataListVo> getDataRatioListByTableNamePattern(String databaseName,String tableNamePattern,Map<String,String> sortMap);
}
