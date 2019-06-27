package com.huya.dc.datamanager.server.model.vo;

public class DataListVo {
    /**
     *
     * databaseName,tableName,accessCountperDay,totalSize,coldDataSize/totalSize AS coldDataRatio,warmDataSize/totalSize AS warmDataSizeRatio FROM datastatistics
     * */
    private String databaseName;
    private String tableName;
    private int accessCountperDay;
    private Long totalSize;
    private double coldDataRatio;
    private double warmDataSizeRatio;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getAccessCountperDay() {
        return accessCountperDay;
    }

    public void setAccessCountperDay(int accessCountperDay) {
        this.accessCountperDay = accessCountperDay;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public double getColdDataRatio() {
        return coldDataRatio;
    }

    public void setColdDataRatio(double coldDataRatio) {
        this.coldDataRatio = coldDataRatio;
    }

    public double getWarmDataSizeRatio() {
        return warmDataSizeRatio;
    }

    public void setWarmDataSizeRatio(double warmDataSizeRatio) {
        this.warmDataSizeRatio = warmDataSizeRatio;
    }

    @Override
    public String toString() {
        return "DataListVo{" +
                "databaseName='" + databaseName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", accessCountperDay=" + accessCountperDay +
                ", totalSize=" + totalSize +
                ", coldDataRatio=" + coldDataRatio +
                ", warmDataSizeRatio=" + warmDataSizeRatio +
                '}';
    }
}
