package com.huya.dc.datamanager.server.service.impl;

import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.constants.TableStrategyState;
import com.huya.dc.datamanager.server.dao.StrategyPropertyDao;
import com.huya.dc.datamanager.server.dao.TableStrategyDao;
import com.huya.dc.datamanager.server.model.StrategyProperty;
import com.huya.dc.datamanager.server.model.TableStrategy;
import com.huya.dc.datamanager.server.service.DataLifecycleService;
import com.huya.dc.datamanager.server.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DataLifecycleServiceImpl implements DataLifecycleService {

    @Autowired
    private TableStrategyDao tableStrategyDao;

    @Autowired
    private StrategyPropertyDao strategyPropertyDao;

    @Override
    public TableStrategy setTableStrategy(String database, String table, Integer cycleVal, StrategyType strategyType, String user, List<StrategyProperty> strategyProperties) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        TableStrategy tableStrategy = new TableStrategy();
        tableStrategy.setDbName(database);
        tableStrategy.setTbName(table);
        tableStrategy.setCycleVal(cycleVal);
        tableStrategy.setStrategyType(strategyType);
        tableStrategy.setState(TableStrategyState.NEW);
        tableStrategy.setCreateTime(now);
        tableStrategy.setUpdateTime(now);
        tableStrategy.setCreateUser(user);
        tableStrategyDao.add(tableStrategy);
        if(strategyProperties != null && !strategyProperties.isEmpty()){
            for(StrategyProperty property : strategyProperties){
                property.setTableStrategyId(tableStrategy.getId());
                property.setCreateUser(user);
                strategyPropertyDao.add(property);
            }
        }
        tableStrategy.setId(tableStrategy.getId());
        tableStrategy.setStrategyProperties(strategyProperties);
        return tableStrategy;
    }

    @Override
    public void delTableStrategy(String database, String table, StrategyType strategyType) {
        TableStrategy tableStrategy = tableStrategyDao.get(database,table,strategyType);
        AssertUtils.notNull(tableStrategy, "无法查询到对应的策略(" + database + "." + table + "-" + strategyType.name() + ")");
        strategyPropertyDao.delByTableStrategyId(tableStrategy.getId());
        tableStrategyDao.del(tableStrategy.getId());
    }

    @Override
    public List<TableStrategy> getTableStrategys(String database, String table) {
        List<TableStrategy> tss = tableStrategyDao.getTableStrategys(database, table);
        if(tss != null && !tss.isEmpty()){
            for(TableStrategy ts : tss){
                List<StrategyProperty> sps = strategyPropertyDao.getByTableStrategyId(ts.getId());
                ts.setStrategyProperties(sps);
            }
        }
        return tss;
    }

    @Override
    public TableStrategy getTableStrategy(String database, String table, StrategyType strategyType) {
        TableStrategy ts = tableStrategyDao.get(database, table, strategyType);
        if(ts != null){
            List<StrategyProperty> sps = strategyPropertyDao.getByTableStrategyId(ts.getId());
            ts.setStrategyProperties(sps);
        }
        return ts;
    }
}
