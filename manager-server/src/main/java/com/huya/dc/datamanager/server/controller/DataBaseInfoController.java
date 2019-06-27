package com.huya.dc.datamanager.server.controller;


import com.huya.dc.datamanager.server.model.RestResult;
import com.huya.dc.datamanager.server.model.vo.CostTeamVo;
import com.huya.dc.datamanager.server.model.vo.DataBaseVo;
import com.huya.dc.datamanager.server.model.vo.TableVo;
import com.huya.dc.datamanager.server.service.DataBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/databaseInfo")
public class DataBaseInfoController {

    @Autowired
    private DataBaseInfoService dataBaseInfoService;

    /**获取成本组的所有名字
     * @return RestResult
     */
    @RequestMapping(value = "/costTeamNames",method = RequestMethod.GET)
    public RestResult getAllCostTeamName(){
        List<CostTeamVo> costTeamName = dataBaseInfoService.getAllCostTeam();
        return RestResult.make(costTeamName);
    }

    /**
     * 根据成本组名字获取成本组管理员
     * @param costTeamName 成本组名字
     * @return
     */
    @RequestMapping(value = "/costTeamManager",method = RequestMethod.GET)
    public RestResult getCostTeamManagerByCostTeamName(String costTeamName){
        String managerName = dataBaseInfoService.getCostTeamManagerByCostTeamName(costTeamName);
        return RestResult.make(managerName);
    }


    /**根据成本组的id获取其拥有的数据库
     * @param costTeamId
     * @return
     */
    @RequestMapping(value = "/databaseList",method = RequestMethod.GET)
    public RestResult getAllDataBase(Long costTeamId){
        List<DataBaseVo> dataBaseVoList = dataBaseInfoService.getAllDataBaseVoByCostTeamId(costTeamId);
        return RestResult.make(dataBaseVoList);
    }


    /**
     * 根据成本组的id和数据库的id获取数据库表
     * @param costTeamId
     * @param databaseId
     * @param pattern
     * @return
     */
    @RequestMapping(value = "/tableList",method = RequestMethod.GET)
    public RestResult getAllTable(Long costTeamId,Long databaseId,String pattern){
        List<TableVo> tableVoList = dataBaseInfoService.getTableInfoByPattern(costTeamId, databaseId, pattern);
        return RestResult.make(tableVoList);
    }
}
