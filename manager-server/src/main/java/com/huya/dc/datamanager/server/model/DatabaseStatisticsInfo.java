package com.huya.dc.datamanager.server.model;

public class DatabaseStatisticsInfo {
    private String databaseName;
    private Integer accessCountPerDay;
    private Long totalSize;
    private double coldDataRatio;
    private double warmDataRatio;
    private double heatDataRatio;
    private double migrationDataRatio;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
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

    public double getColdDataRatio() {
        return coldDataRatio;
    }

    public void setColdDataRatio(double coldDataRatio) {
        this.coldDataRatio = coldDataRatio;
    }

    public double getWarmDataRatio() {
        return warmDataRatio;
    }

    public void setWarmDataRatio(double warmDataRatio) {
        this.warmDataRatio = warmDataRatio;
    }

    public double getHeatDataRatio() {
        return heatDataRatio;
    }

    public void setHeatDataRatio(double heatDataRatio) {
        this.heatDataRatio = heatDataRatio;
    }

    public double getMigrationDataRatio() {
        return migrationDataRatio;
    }

    public void setMigrationDataRatio(double migrationDataRatio) {
        this.migrationDataRatio = migrationDataRatio;
    }

    @Override
    public String toString() {
        return "DatabaseStatisticsInfo{" +
                "databaseName='" + databaseName + '\'' +
                ", accessCountPerDay=" + accessCountPerDay +
                ", totalSize=" + totalSize +
                ", coldDataRatio=" + coldDataRatio +
                ", warmDataRatio=" + warmDataRatio +
                ", heatDataRatio=" + heatDataRatio +
                ", migrationDataRatio=" + migrationDataRatio +
                '}';
    }
}
