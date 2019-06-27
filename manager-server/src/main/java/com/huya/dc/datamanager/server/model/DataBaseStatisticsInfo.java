package com.huya.dc.datamanager.server.model;

public class DataBaseStatisticsInfo {
    private String dbName;
    private String tableName;
    private Integer accessCountPerDay;
    private Long totalSize;
    private Long coldDataSize;
    private Long warmDataSize;
    private Long heatDataSize;
    private Long migrationDataSize;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getAccessCountPerDay() {
        return accessCountPerDay;
    }

    public void setAccessCountPerDay(Integer accessCountPerDay) {
        this.accessCountPerDay = accessCountPerDay;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public double getColdDataSize() {
        return coldDataSize;
    }

    public void setColdDataSize(Long coldDataSize) {
        this.coldDataSize = coldDataSize;
    }

    public Long getWarmDataSize() {
        return warmDataSize;
    }

    public void setWarmDataSize(Long warmDataSize) {
        this.warmDataSize = warmDataSize;
    }

    public Long getHeatDataSize() {
        return heatDataSize;
    }

    public void setHeatDataSize(Long heatDataSize) {
        this.heatDataSize = heatDataSize;
    }

    public Long getMigrationDataSize() {
        return migrationDataSize;
    }

    public void setMigrationDataSize(Long migrationDataSize) {
        this.migrationDataSize = migrationDataSize;
    }

    @Override
    public String toString() {
        return "DataBaseStatisticsInfo{" +
                "dbName='" + dbName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", accessCountPerDay=" + accessCountPerDay +
                ", totalSize=" + totalSize +
                ", coldDataSize=" + coldDataSize +
                ", warmDataSize=" + warmDataSize +
                ", heatDataSize=" + heatDataSize +
                ", migrationDataSize=" + migrationDataSize +
                '}';
    }
}
