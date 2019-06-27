package com.huya.dc.datamanager.server.controller;

import com.duowan.dc.web.auth.client.PassportPrincipal;
import com.duowan.dc.web.auth.client.SubjectUtil;
import com.huya.dc.datamanager.server.constants.StrategyCycleUnit;
import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.model.RestResult;
import com.huya.dc.datamanager.server.model.StrategyProperty;
import com.huya.dc.datamanager.server.model.TableStrategy;
import com.huya.dc.datamanager.server.service.DataLifecycleService;
import com.huya.dc.datamanager.server.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;
import java.util.List;

@RestController
@RequestMapping("/lifecycle")
public class DataLifecycleController {

    @Autowired
    private DataLifecycleService dataLifecycleService;
    /**
     * 添加数据库表的存储策略
     *
     * @param database
     * @param table
     * @param cycleVal    策略周期值，设置该策略应用于多久时间之前的数据
     * @param strategyType  存储策略类型 {@link com.huya.dc.datamanager.server.constants.StrategyType}
     * @param strategyProperties   策略属性，不同的策略有不同的属性配置
     * @return
     */
    @ResponseBody
    @RequestMapping("/addStrategy")
    public RestResult setTableStrategy(String database, String table, Integer cycleVal, String strategyType, @RequestBody List<StrategyProperty> strategyProperties){
        AssertUtils.notEmpty(database, "数据库名不能为空");
        AssertUtils.notEmpty(table, "表名不能为空");
        AssertUtils.notGT0(cycleVal, "数据策略周期必须是大于0的整数");
        AssertUtils.notEmpty(strategyType, "存储策略类型不能为空");
        String user = SubjectUtil.getPrincipal(PassportPrincipal.class).getName();
        AssertUtils.notEmpty(user, "登录用户名无法获取，请确定登录状态是否失效");

        StrategyType type = StrategyType.valueOf(strategyType);

        TableStrategy tableStrategy = dataLifecycleService.setTableStrategy(database, table, cycleVal, type, user, strategyProperties);
        return RestResult.make(tableStrategy);
    }
}
