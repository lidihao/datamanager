package com.huya.dc.datamanager.server.model.vo;

public class DataBaseVo {
    private Long dataBaseId;
    private String dataBaseName;

    public Long getDataBaseId() {
        return dataBaseId;
    }

    public void setDataBaseId(Long dataBaseId) {
        this.dataBaseId = dataBaseId;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    @Override
    public String toString() {
        return "DataBaseVo{" +
                "dataBaseId=" + dataBaseId +
                ", dataBaseName='" + dataBaseName + '\'' +
                '}';
    }
}
