package com.huya.dc.datamanager.server.service;

import com.huya.dc.datamanager.server.dao.TableInfoDao;
import com.huya.dc.datamanager.server.model.vo.CostTeamVo;
import com.huya.dc.datamanager.server.model.vo.DataBaseVo;
import com.huya.dc.datamanager.server.model.vo.TableVo;

import java.util.List;

public interface DataBaseInfoService {
   List<CostTeamVo> getAllCostTeam();
   String getCostTeamManagerByCostTeamName(String costTeamName);
   List<DataBaseVo> getAllDataBaseVoByCostTeamId(Long costTeamId);
   List<TableVo> getTableNameByPattern(Long costTeamId,Long dataBaseId,String pattern);
}
