package com.huya.dc.datamanager.server.controller;

import com.huya.dc.datamanager.server.model.RestResult;
import com.huya.dc.datamanager.server.model.vo.DataListVo;
import com.huya.dc.datamanager.server.service.DataStatisticsService;
import com.huya.dc.datamanager.server.utils.StringToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataList")
public class DataListController {
    @Autowired
    private DataStatisticsService dataStatisticsService;

    @RequestMapping("/dataRatioalldatabase")
    public RestResult getDataRatioBydatabaseName(String databaseName,String sortMap,Integer pageNum){
        Map<String,String> realSortMap = StringToMap.stringToMap(sortMap,",",":");
        List<DataListVo> dataListVoList = dataStatisticsService.getDataRatioListByDataBaseName(databaseName,realSortMap,pageNum);
        return RestResult.make(dataListVoList);
    }

    @RequestMapping("/dataRatiotablepattern")
    public RestResult getDataRatioBytablePattern(String databaseName,String tableNamePattern,String sortMap){
        Map<String,String> realSortMap = StringToMap.stringToMap(sortMap,",",":");
        List<DataListVo> dataListVoList = dataStatisticsService.getDataRatioListByTableNamePattern(databaseName, tableNamePattern, realSortMap);
        return RestResult.make(dataListVoList);
    }
}
