package com.huya.dc.datamanager.server.dao;

import com.huya.dc.datamanager.server.model.vo.CostTeamVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CostTeamDao {
    List<CostTeamVo> getAllCostTeam();
    String getManagerNameByCostTeamName(String costTeamName);
}
