package com.huya.dc.datamanager.server.controller.statistics;


import com.huya.dc.datamanager.server.model.RestResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statisticsInfo")
public class StatisticsInfoConstroller {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public RestResult getTableStatisticsInfo(String tableName){
        return RestResult.make();
    }
}
