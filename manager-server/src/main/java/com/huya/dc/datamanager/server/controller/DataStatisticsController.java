package com.huya.dc.datamanager.server.controller;


import com.huya.dc.datamanager.server.model.RestResult;
import com.huya.dc.datamanager.server.model.vo.DataRatioInfoVo;
import com.huya.dc.datamanager.server.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class DataStatisticsController {
    @Autowired
    private DataStatisticsService dataStatisticsService;

    @RequestMapping("/table/dataRatio")
    public RestResult getDataRatioByTableName(String databaseName, String tableName){
        DataRatioInfoVo dataRatioInfoVo = dataStatisticsService.getDataRatioInfo(databaseName,tableName);
        return RestResult.make(dataRatioInfoVo);
    }

    @RequestMapping("/database/dataRatio")
    public  RestResult getDataRatioBydataBaseName(String databaseName){
        DataRatioInfoVo dataRatioInfoVo = dataStatisticsService.getDataRatioInfoTotalDataBase(databaseName);
        return RestResult.make(dataRatioInfoVo);
    }
}
