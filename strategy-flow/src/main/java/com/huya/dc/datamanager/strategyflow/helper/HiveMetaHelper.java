package com.huya.dc.datamanager.strategyflow.helper;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hive.hcatalog.api.HCatClient;
import org.apache.hive.hcatalog.api.HCatClientHMSImpl;
import org.apache.hive.hcatalog.api.HCatPartition;
import org.apache.hive.hcatalog.api.HCatTable;
import org.apache.hive.hcatalog.common.HCatException;
import org.apache.hive.hcatalog.data.schema.HCatFieldSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HiveMetaHelper {
    private final static Logger log = LoggerFactory.getLogger(HiveMetaHelper.class);

    public static String getLocation(String database, String table) throws MetaException, IOException {
        HCatClient cli = initHiveMetaStoreCli();
        HCatTable hcTable = cli.getTable(database, table);
        return hcTable.getLocation();
    }
    public static String getLocation(String database, String table, Map<String, String> partitionSpec) throws MetaException, IOException{
        HCatClient cli = initHiveMetaStoreCli();
        HCatPartition partition = cli.getPartition(database, table, partitionSpec);
        if(partition == null){
            return "";
        }
        return partition.getLocation();
    }

    public static List<String> listDatabases(String pattern) throws HCatException {
        HCatClient cli = initHiveMetaStoreCli();
        return cli.listDatabaseNamesByPattern(pattern);
    }

    public static List<String> listTables(String dbName, String pattern) throws HCatException {
        HCatClient cli = initHiveMetaStoreCli();
        return cli.listTableNamesByPattern(dbName, pattern);
    }

    public static List<String> listColumns(String dbName, String tableName) throws HCatException {
        List<String> fields = Lists.newArrayList();
        HCatClient cli = initHiveMetaStoreCli();
        HCatTable table = cli.getTable(dbName, tableName);
        List<HCatFieldSchema> fieldSchemas = table.getCols();
        for(HCatFieldSchema fieldSchema : fieldSchemas){
            fields.add(fieldSchema.getName());
        }

        List<HCatFieldSchema> partitions = table.getPartCols();
        if(partitions != null){
            for(HCatFieldSchema p : partitions){
                fields.add(p.getName());
            }
        }

        return fields;
    }

    public static boolean checkDatabaseExists(String database) throws HCatException {
        List<String> list = listDatabases(database);
        if(list == null || list.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean checkPartitionExists(String database, String table, String partition) throws HCatException {
        List<HCatPartition> list = listPartitions(database, table, partition);
        if(list == null || list.isEmpty()){
            return false;
        }
        return true;
    }

    public static List<HCatPartition> listPartitions(String database, String table, String partition) throws HCatException {
        HCatClient cli = initHiveMetaStoreCli();
        return cli.listPartitionsByFilter(database, table, partition);
    }

    public static boolean checkTableExists(String database, String table) throws HCatException {
        List<String> list = listTables(database, table);
        if(list == null || list.isEmpty()){
            return false;
        }
        return true;
    }

    public static List<String> checkColumnExists(String database, String table, String columns) throws HCatException {
        if(StringUtils.isBlank(columns)){
            return null;
        }
        List<String> notExistCols = Lists.newArrayList();
        List<String> cols = listColumns(database, table);
        String[] colArr = columns.split(",");
        for(String col : colArr){
            if(!cols.contains(col)){
                notExistCols.add(col);
            }
        }

        return notExistCols;
    }

    /**
     * 检测表元数据
     * @param database
     * @param table
     * @param columns
     * @throws HCatException
     */
    public static void checkMeta(String database, String table, String columns) throws HCatException {
        if(!StringUtils.isBlank(database)) {
            if (!HiveMetaHelper.checkDatabaseExists(database)) {
                throw new RuntimeException("数据库不存在[" + database + "]");
            }
        }
        if(!StringUtils.isBlank(table)) {
            if (!HiveMetaHelper.checkTableExists(database, table)) {
                throw new RuntimeException("表不存在[" + database + "." + table + "]");
            }
        }

        if(!StringUtils.isBlank(columns)) {
            List<String> notExistCols = HiveMetaHelper.checkColumnExists(database, table, columns);

            if (notExistCols != null && !notExistCols.isEmpty()) {
                StringBuilder cols = new StringBuilder();
                notExistCols.forEach(s -> {
                    if (cols.length() == 0) {
                        cols.append(s);
                    } else {
                        cols.append("," + s);
                    }

                });
                throw new RuntimeException("字段不存在[" + database + "." + table + "." + cols + " ]");
            }
        }
    }

    //TODO 可缓存
    private static HCatClient initHiveMetaStoreCli(){
        Configuration conf = new Configuration();
        try {
            log.info("hive metastore url:" + conf.get("javax.jdo.option.ConnectionURL"));
            return HCatClientHMSImpl.create(conf);
        } catch (HCatException e) {
            log.error("HCatClientProvider.create() client error!", e);
        }
        return null;
    }
}
