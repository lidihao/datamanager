package com.huya.dc.datamanager.server.dao;

import com.huya.dc.datamanager.server.model.vo.DataBaseVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DataBaseDao {
    List<DataBaseVo> getDataBaseByCostTeamId(Long costTeamId);
}
