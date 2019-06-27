package com.huya.dc.datamanager.server.model.vo;

public class CostTeamVo {
    private Long costTeamId;
    private String costTeamName;
    private String manager;

    public Long getCostTeamId() {
        return costTeamId;
    }

    public void setCostTeamId(Long costTeamId) {
        this.costTeamId = costTeamId;
    }

    public String getCostTeamName() {
        return costTeamName;
    }

    public void setCostTeamName(String costTeamName) {
        this.costTeamName = costTeamName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "CostTeamVo{" +
                "costTeamId=" + costTeamId +
                ", costTeamName='" + costTeamName + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
