package com.huya.dc.datamanager.server.model;

import java.sql.Timestamp;

public class Table {
    private String name;
    private Timestamp createTime;
    private Long size;
    private Integer partCnt;
    private Integer fileCnt;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getPartCnt() {
        return partCnt;
    }

    public void setPartCnt(Integer partCnt) {
        this.partCnt = partCnt;
    }

    public Integer getFileCnt() {
        return fileCnt;
    }

    public void setFileCnt(Integer fileCnt) {
        this.fileCnt = fileCnt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                ", size=" + size +
                ", partCnt=" + partCnt +
                ", fileCnt=" + fileCnt +
                ", location='" + location + '\'' +
                '}';
    }
}
