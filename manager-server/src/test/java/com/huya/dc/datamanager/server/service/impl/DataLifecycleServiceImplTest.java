package com.huya.dc.datamanager.server.service.impl;

import com.google.common.collect.Lists;
import com.huya.dc.datamanager.server.DatamanagerServerApplication;
import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.constants.TableStrategyState;
import com.huya.dc.datamanager.server.dao.DataStatisticsDao;
import com.huya.dc.datamanager.server.dao.StrategyPropertyDao;
import com.huya.dc.datamanager.server.dao.TableStrategyDao;
import com.huya.dc.datamanager.server.model.StrategyProperty;
import com.huya.dc.datamanager.server.model.TableStrategy;
import com.huya.dc.datamanager.server.service.DataLifecycleService;
import com.huya.dc.datamanager.server.utils.AssertUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore( {"javax.management.*", "javax.net.ssl.*", "javax.crypto.*"})
@SpringBootTest(classes={DatamanagerServerApplication.class})// 指定启动类
public class DataLifecycleServiceImplTest {

    @Autowired
    private DataLifecycleService dataLifecycleService;

    @Test
    public void setTableStrategy() throws Exception {
        List<StrategyProperty> strategyProperties = Lists.newArrayList();

        String dbName = "gamelive";
        String tbName = "ods_action_log";
        String user = "dw_chenjian4";

        for(int i = 0; i < 10; i++){
            strategyProperties.add(newProp("prop_" + i, "val_" + i));
        }

        dataLifecycleService.setTableStrategy(dbName, tbName, 30, StrategyType.COLD, user, strategyProperties);

        TableStrategy ts = dataLifecycleService.getTableStrategy(dbName, tbName, StrategyType.COLD);

        //添加测试
        Assert.assertTrue(ts != null);

        Assert.assertNotNull(ts.getStrategyProperties());

        Assert.assertTrue(ts.getStrategyProperties().size() == 10);

        //获取测试
        List<TableStrategy> tss = dataLifecycleService.getTableStrategys(dbName, tbName);

        Assert.assertNotNull(tss);

        Assert.assertTrue(tss.size() == 1);

        List<StrategyProperty> sps = tss.get(0).getStrategyProperties();

        Assert.assertTrue(sps != null);

        Assert.assertTrue(sps.size() == 10);

        dataLifecycleService.delTableStrategy(dbName, tbName, StrategyType.COLD);

        tss = dataLifecycleService.getTableStrategys(dbName, tbName);

        Assert.assertTrue(tss == null || tss.isEmpty());
    }

    private StrategyProperty newProp(String prop, String val){
        StrategyProperty sp = new StrategyProperty();
        sp.setProp(prop);
        sp.setVal(val);
        return sp;
    }

    private TableStrategy getTableStrategy() {
        TableStrategy tableStrategy = new TableStrategy();
        tableStrategy.setDbName("gamelive");
        tableStrategy.setTbName("ods_action_log");
        tableStrategy.setState(TableStrategyState.NEW);
        tableStrategy.setStrategyType(StrategyType.COLD);
        tableStrategy.setCycleVal(30);
        tableStrategy.setCreateUser("dw_chenjian4");
        return tableStrategy;
    }

    @Autowired
    private DataStatisticsDao dataStatisticsDao;

}