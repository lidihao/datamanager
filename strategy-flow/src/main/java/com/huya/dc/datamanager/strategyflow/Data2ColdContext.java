package com.huya.dc.datamanager.strategyflow;

import org.apache.commons.chain.impl.ContextBase;

public class Data2ColdContext extends ContextBase {
    private String database;
    private String table;
    private String dtPart;

    private String dtFormat;
    private boolean isDelExistColdData = false;

    private String sourceLocation;
    private String targetLocation;

    private String checksumOutputPath;

    public String getChecksumOutputPath() {
        return checksumOutputPath;
    }

    public void setChecksumOutputPath(String checksumOutputPath) {
        this.checksumOutputPath = checksumOutputPath;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public String getDtFormat() {
        return dtFormat;
    }

    public void setDtFormat(String dtFormat) {
        this.dtFormat = dtFormat;
    }



    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getDtPart() {
        return dtPart;
    }

    public void setDtPart(String dtPart) {
        this.dtPart = dtPart;
    }

    public boolean isDelExistColdData() {
        return isDelExistColdData;
    }

    public void setDelExistColdData(boolean delExistColdData) {
        isDelExistColdData = delExistColdData;
    }
}
