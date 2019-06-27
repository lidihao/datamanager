package com.huya.dc.datamanager.server.model.vo;

public class DataRatioInfoVo {
    private double coldDataRatio;
    private double warnDataRatio;
    private double heatDataRatio;
    private double migrationDataRatio;

    public double getColdDataRatio() {
        return coldDataRatio;
    }

    public void setColdDataRatio(double coldDataRatio) {
        this.coldDataRatio = coldDataRatio;
    }

    public double getWarnDataRatio() {
        return warnDataRatio;
    }

    public void setWarnDataRatio(double warnDataRatio) {
        this.warnDataRatio = warnDataRatio;
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
        return "DataRatioInfoVo{" +
                "coldDataRatio=" + coldDataRatio +
                ", warnDataRatio=" + warnDataRatio +
                ", heatDataRatio=" + heatDataRatio +
                ", migrationDataRatio=" + migrationDataRatio +
                '}';
    }
}
