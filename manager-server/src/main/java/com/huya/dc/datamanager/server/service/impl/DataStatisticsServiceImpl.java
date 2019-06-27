package com.huya.dc.datamanager.server.service.impl;

import com.huya.dc.datamanager.server.dao.DataStatisticsDao;
import com.huya.dc.datamanager.server.model.DataBaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.vo.DataListVo;
import com.huya.dc.datamanager.server.model.vo.DataRatioInfoVo;
import com.huya.dc.datamanager.server.service.DataStatisticsService;
import com.huya.dc.datamanager.server.utils.DataRatioCaculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Autowired
    private DataStatisticsDao statisticsDao;
    @Override
    public DataRatioInfoVo getDataRatioInfo(String databaseName, String tableName) {
        String dateNearly=statisticsDao.getNearDate();
        DataBaseStatisticsInfo dataBaseStatisticsInfo=statisticsDao.getTableStatisticsInfo(databaseName,tableName,dateNearly);
        return DataRatioCaculator.calculateDataRatio(dataBaseStatisticsInfo);
    }

    @Override
    public DataRatioInfoVo getDataRatioInfoTotalDataBase(String databaseName) {
        String dateNearly=statisticsDao.getNearDate();
        //获取今天的数据，并没有
        DataBaseStatisticsInfo dataBaseStatisticsInfo = statisticsDao.getDataBaseStatisticsInfo(databaseName,dateNearly);
        return DataRatioCaculator.calculateDataRatio(dataBaseStatisticsInfo);
    }

    @Override
    public List<DataListVo> getDataRatioListByDataBaseName(String databaseName, Map<String, String> sortMap,Integer pageNum) {
        String dateNearly = statisticsDao.getNearDate();
        List<DataListVo> dataListVoList = statisticsDao.getDataRatioByDataBaseName(sortMap,databaseName,dateNearly);
        return dataListVoList;
    }

    @Override
    public List<DataListVo> getDataRatioListByTableNamePattern(String databaseName, String tableNamePattern, Map<String, String> sortMap) {
        String dateNearly = statisticsDao.getNearDate();
        List<DataListVo> dataListVoList = statisticsDao.getDataRatioByTableNamePattern(sortMap,databaseName,dateNearly,tableNamePattern);
        return dataListVoList;
    }


}
