package com.huya.dc.datamanager.server.model;

import com.huya.dc.datamanager.server.constants.StrategyCycleUnit;
import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.constants.TableStrategyState;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * 数据存储策略
 */
public class TableStrategy {
    private Integer id;
    private String dbName;
    private String tbName;
    private StrategyType strategyType;
    private Integer cycleVal;
    private Timestamp startTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUser;
    private String updateUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    private TableStrategyState state;
    private List<StrategyProperty> strategyProperties;


    public StrategyType getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(StrategyType strategyType) {
        this.strategyType = strategyType;
    }


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }


    public Integer getCycleVal() {
        return cycleVal;
    }

    public void setCycleVal(Integer cycleVal) {
        this.cycleVal = cycleVal;
    }

    public TableStrategyState getState() {
        return state;
    }

    public void setState(TableStrategyState state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<StrategyProperty> getStrategyProperties() {
        return strategyProperties;
    }

    public void setStrategyProperties(List<StrategyProperty> strategyProperties) {
        this.strategyProperties = strategyProperties;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "TableStrategy{" +
                "id=" + id +
                ", dbName='" + dbName + '\'' +
                ", tbName='" + tbName + '\'' +
                ", strategyType=" + strategyType +
                ", cycleVal=" + cycleVal +
                ", startTime=" + startTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", state=" + state +
                ", strategyProperties=" + strategyProperties +
                '}';
    }
}
