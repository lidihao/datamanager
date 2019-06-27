package com.huya.dc.datamanager.server.model;

public class Database {
    private String name;
    private String desc;
    private Long size;
    private Integer tableCount;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getTableCount() {
        return tableCount;
    }

    public void setTableCount(Integer tableCount) {
        this.tableCount = tableCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Database{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", size=" + size +
                ", tableCount=" + tableCount +
                ", location='" + location + '\'' +
                '}';
    }
}
