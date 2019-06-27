package com.huya.dc.datamanager.server.dao;

import com.huya.dc.datamanager.server.model.StrategyProperty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StrategyPropertyDao {
    void add(StrategyProperty strategyProperty);
    void delByTableStrategyId(Integer id);
    List<StrategyProperty> getByTableStrategyId(Integer id);
}
