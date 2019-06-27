package com.huya.dc.datamanager.server.dao;


import com.huya.dc.datamanager.server.model.vo.TableVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableInfoDao {
    List<TableVo> getAllTableInfoByPattern(Long costTeamId,Long databaseId,String pattern);
}
