package com.huya.dc.datamanager.server.dao;

import com.huya.dc.datamanager.server.DatamanagerServerApplication;
import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.constants.TableStrategyState;
import com.huya.dc.datamanager.server.model.TableStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DatamanagerServerApplication.class})// 指定启动类
public class TableStrategyDaoTest {

    @Autowired
    private TableStrategyDao tableStrategyDao;
    @Test
    public void add() {
        TableStrategy tableStrategy = new TableStrategy();
        tableStrategy.setDbName("gamelive");
        tableStrategy.setTbName("ods_action_log");
        tableStrategy.setState(TableStrategyState.NEW);
        tableStrategy.setStrategyType(StrategyType.COLD);
        tableStrategy.setCycleVal(30);
        tableStrategy.setCreateUser("dw_chenjian4");
        tableStrategyDao.add(tableStrategy);
        TableStrategy result = tableStrategyDao.get("gamelive", "ods_action_log", StrategyType.COLD);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.getId() == tableStrategy.getId());
        System.out.println(result);
        tableStrategyDao.del(tableStrategy.getId());
        result = tableStrategyDao.get("gamelive", "ods_action_log", StrategyType.COLD);
        Assert.assertTrue(result == null);
    }
}