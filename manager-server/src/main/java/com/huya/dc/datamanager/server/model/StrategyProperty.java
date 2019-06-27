package com.huya.dc.datamanager.server.model;

import java.sql.Timestamp;

/**
 * 策略属性模型
 */
public class StrategyProperty {
    private Integer id;
    private Integer tableStrategyId;
    private String prop;
    private String val;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUser;
    private String updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTableStrategyId() {
        return tableStrategyId;
    }

    public void setTableStrategyId(Integer tableStrategyId) {
        this.tableStrategyId = tableStrategyId;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "StrategyProperty{" +
                "id=" + id +
                ", tableStrategyId=" + tableStrategyId +
                ", prop='" + prop + '\'' +
                ", val='" + val + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
