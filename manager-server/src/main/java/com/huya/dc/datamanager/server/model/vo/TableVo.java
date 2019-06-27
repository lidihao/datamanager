package com.huya.dc.datamanager.server.model.vo;

public class TableVo {
    private Long tableId;
    private String tableName;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "TableVo{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
