package com.huya.dc.datamanager.server.dao;

import com.huya.dc.datamanager.server.constants.StrategyType;
import com.huya.dc.datamanager.server.model.TableStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableStrategyDao {
    void add(TableStrategy tableStrategy);

    void del(int id);

    TableStrategy get(@Param("dbName") String dbName, @Param("tbName") String tbName, @Param("strategyType") StrategyType strategyType);

    List<TableStrategy> getTableStrategys(@Param("dbName") String dbName, @Param("tbName") String tbName);
}
