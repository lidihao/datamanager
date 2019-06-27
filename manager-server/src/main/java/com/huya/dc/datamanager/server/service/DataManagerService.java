package com.huya.dc.datamanager.server.service;

import com.huya.dc.datamanager.server.model.Database;
import com.huya.dc.datamanager.server.model.Table;

import java.util.List;

/**
 * 数据管理服务
 */
public interface DataManagerService {
    /**
     * 获取库列表
     * @param pattern
     * @return
     */
    List<Database> listDatabases(String pattern);

    /**
     * 表列表
     * @param database
     * @param pattern
     * @return
     */
    List<Table> queryTables(String database, String pattern);

}
