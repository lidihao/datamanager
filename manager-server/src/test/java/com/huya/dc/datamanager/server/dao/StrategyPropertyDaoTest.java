package com.huya.dc.datamanager.server.dao;

import com.huya.dc.datamanager.server.DatamanagerServerApplication;
import com.huya.dc.datamanager.server.model.StrategyProperty;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DatamanagerServerApplication.class})// 指定启动类
public class StrategyPropertyDaoTest {

    @Autowired
    private StrategyPropertyDao strategyPropertyDao;

    @Test
    public void add() {
        Integer tableStrategyId = 1;
        addStrategyProperty(tableStrategyId, "test1", "test1", "dw_chenjian4");
        addStrategyProperty(tableStrategyId, "test2", "test2", "dw_chenjian4");

        List<StrategyProperty> sps = strategyPropertyDao.getByTableStrategyId(tableStrategyId);
        Assert.assertTrue(sps.size() == 2);
        strategyPropertyDao.delByTableStrategyId(tableStrategyId);
        sps = strategyPropertyDao.getByTableStrategyId(tableStrategyId);
        Assert.assertTrue(sps == null || sps.isEmpty());
    }

    private void addStrategyProperty(Integer tableStrategyId, String prop, String val, String createUser) {
        StrategyProperty p = new StrategyProperty();
        p.setTableStrategyId(tableStrategyId);
        p.setProp(prop);
        p.setVal(val);
        p.setCreateUser(createUser);
        strategyPropertyDao.add(p);
    }
}