package com.huya.dc.datamanager.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huya.dc.datamanager.server.constants.SystemConstants;
import com.huya.dc.datamanager.server.dao.DataStatisticsDao;
import com.huya.dc.datamanager.server.model.DatabaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.TableStatisticsInfo;
import com.huya.dc.datamanager.server.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Autowired
    private DataStatisticsDao statisticsDao;
    @Override
    public TableStatisticsInfo getDataRatioInfo(String databaseName, String tableName) {
        String dateNearly=statisticsDao.getNearDate();
        return statisticsDao.getTableStatisticsInfo(databaseName,tableName,dateNearly);
    }

    @Override
    public DatabaseStatisticsInfo getDataRatioInfoTotalDataBase(String databaseName) {
        String dateNearly=statisticsDao.getNearDate();
        //获取今天的数据，并没有
        return statisticsDao.getDataBaseStatisticsInfo(databaseName,dateNearly);
    }

    @Override
    public PageInfo<TableStatisticsInfo> getDataRatioListByDataBaseNamePageable(String databaseName, Map<String, String> sortMap, Integer pageNum) {
        String dateNearly = statisticsDao.getNearDate();
        PageHelper.startPage(pageNum, SystemConstants.PAGE_SIZE);
        List<TableStatisticsInfo> dataListVoList = statisticsDao.getDataRatioByDataBaseName(sortMap,databaseName,dateNearly);
        return new PageInfo<>(dataListVoList);
    }

    @Override
    public PageInfo<TableStatisticsInfo> getDataRatioListByTableNamePatternPageable(String databaseName, String tableNamePattern, Map<String, String> sortMap,Integer pageNum) {
        String dateNearly = statisticsDao.getNearDate();
        PageHelper.startPage(pageNum,SystemConstants.PAGE_SIZE);
        tableNamePattern = tableNamePattern+"%";
        List<TableStatisticsInfo> dataListVoList = statisticsDao.getDataRatioByTableNamePattern(sortMap,databaseName,dateNearly,tableNamePattern);
        return new PageInfo<>(dataListVoList);
    }


}
