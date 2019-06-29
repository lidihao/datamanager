package com.huya.dc.datamanager.server.service.impl;

import com.huya.dc.datamanager.server.dao.CostTeamDao;
import com.huya.dc.datamanager.server.dao.DataBaseDao;
import com.huya.dc.datamanager.server.dao.TableInfoDao;
import com.huya.dc.datamanager.server.model.vo.CostTeamVo;
import com.huya.dc.datamanager.server.model.vo.DataBaseVo;
import com.huya.dc.datamanager.server.model.vo.TableVo;
import com.huya.dc.datamanager.server.service.DataBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseInfoServiceImpl implements DataBaseInfoService {

    @Autowired
    private CostTeamDao costTeamDao;

    @Autowired
    private DataBaseDao dataBaseDao;

    @Autowired
    private TableInfoDao tableInfoDao;

    @Override
    public List<CostTeamVo> getAllCostTeam() {
        return costTeamDao.getAllCostTeam();
    }

    @Override
    public String getCostTeamManagerByCostTeamName(String costTeamName) {
        return costTeamDao.getManagerNameByCostTeamName(costTeamName);
    }

    @Override
    public List<DataBaseVo> getAllDataBaseVoByCostTeamId(Long costTeamId) {
        return dataBaseDao.getDataBaseByCostTeamId(costTeamId);
    }

    @Override
    public List<TableVo> getTableNameByPattern(Long costTeamId, Long dataBaseId, String pattern) {
        String mysqlPattern = pattern+"%";
        return tableInfoDao.getAllTableNameByPattern(costTeamId,dataBaseId,mysqlPattern);
    }
}
