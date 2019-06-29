package com.huya.dc.datamanager.server.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.huya.dc.datamanager.server.model.RestResult;
import com.huya.dc.datamanager.server.model.TableStatisticsInfo;
import com.huya.dc.datamanager.server.service.DataStatisticsService;
import com.huya.dc.datamanager.server.utils.AssertUtils;
import com.huya.dc.datamanager.server.utils.StringToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 数据列表显示
 */
@RestController
@RequestMapping("/dataList")
public class DataListController {
    @Autowired
    private DataStatisticsService dataStatisticsService;

    /**根据databaseName获取整个数据库中数据库表的详细信息
     * @param databaseName 数据库名
     * @param sortMap 排序字段[field:asc|desc,field:asc|desc...]
     * @param pageNum 当前的页数
     * @return
     */
    @RequestMapping("/dataRatioTotalDatabase")
    public RestResult getDataRatioBydatabaseName(String databaseName,String sortMap,Integer pageNum){
        AssertUtils.notEmpty(databaseName,"数据库名不能为空或空串");
        AssertUtils.notNull(pageNum,"pageNum不能为空");
        Map<String,String> realSortMap = StringToMap.stringToMap(sortMap,",",":");
        PageInfo<TableStatisticsInfo> dataListVoList = dataStatisticsService.getDataRatioListByDataBaseNamePageable(databaseName,realSortMap,pageNum);
        return RestResult.make(dataListVoList);
    }

    /**根据databaseName,tablePatter获取整个数据库中数据库表的详细信息
     * @param databaseName  数据库名
     * @param tableNamePattern 数据表名前缀
     * @param sortMap 排序字段[field:asc|desc,field:asc|desc...]
     * @param pageNum 当前页数
     * @return
     */
    @RequestMapping("/dataRatioTablePattern")
    public RestResult getDataRatioBytablePattern(String databaseName,String tableNamePattern,String sortMap,Integer pageNum){
        AssertUtils.notEmpty(databaseName,"数据库名不能为空或空串");
        AssertUtils.notNull(tableNamePattern,"数据表前缀不能为空");
        AssertUtils.notNull(pageNum,"pageNum不能为空");
        Map<String,String> realSortMap = StringToMap.stringToMap(sortMap,",",":");
        PageInfo<TableStatisticsInfo> dataListVoList = dataStatisticsService.getDataRatioListByTableNamePatternPageable(databaseName, tableNamePattern, realSortMap,pageNum);
        return RestResult.make(dataListVoList);
    }
}
