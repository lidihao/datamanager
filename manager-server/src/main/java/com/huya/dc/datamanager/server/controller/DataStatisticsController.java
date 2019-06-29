package com.huya.dc.datamanager.server.controller;


import com.huya.dc.datamanager.server.model.DatabaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.RestResult;
import com.huya.dc.datamanager.server.model.TableStatisticsInfo;
import com.huya.dc.datamanager.server.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取冷温热迁移数据的占比
 */
@RestController
@RequestMapping("/statistics")
public class DataStatisticsController {
    @Autowired
    private DataStatisticsService dataStatisticsService;

    /**根据databaseName,tablename获取某个表冷温热迁移数据的占比
     * @param databaseName
     * @param tableName
     * @return
     */
    @RequestMapping("/table/dataRatio")
    public RestResult getDataRatioByTableName(String databaseName, String tableName){
        TableStatisticsInfo tableStatisticsInfo = dataStatisticsService.getDataRatioInfo(databaseName,tableName);
        return RestResult.make(tableStatisticsInfo);
    }

    /**
     * 获取整个数据库的冷温热迁移数据的占比
     * @param databaseName
     * @return
     */
    @RequestMapping("/database/dataRatio")
    public  RestResult getDataRatioBydataBaseName(String databaseName){
        DatabaseStatisticsInfo databaseStatisticsInfo = dataStatisticsService.getDataRatioInfoTotalDataBase(databaseName);
        return RestResult.make(databaseStatisticsInfo);
    }
}
