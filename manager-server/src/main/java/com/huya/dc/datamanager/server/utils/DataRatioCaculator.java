package com.huya.dc.datamanager.server.utils;

import com.huya.dc.datamanager.server.model.DataBaseStatisticsInfo;
import com.huya.dc.datamanager.server.model.vo.DataRatioInfoVo;

public abstract class DataRatioCaculator {
    public static DataRatioInfoVo calculateDataRatio(DataBaseStatisticsInfo dataBaseStatisticsInfo){
        DataRatioInfoVo dataRatioInfoVo = new DataRatioInfoVo();
        double totalSize = (double)dataBaseStatisticsInfo.getTotalSize();
        double coldDataRatio = dataBaseStatisticsInfo.getColdDataSize()/totalSize;
        double warmDataRatio = dataBaseStatisticsInfo.getWarmDataSize()/totalSize;
        double heatDataRatio = dataBaseStatisticsInfo.getHeatDataSize()/totalSize;
        double migrationRatio = dataBaseStatisticsInfo.getMigrationDataSize()/totalSize;
        dataRatioInfoVo.setColdDataRatio(coldDataRatio);
        dataRatioInfoVo.setWarnDataRatio(warmDataRatio);
        dataRatioInfoVo.setHeatDataRatio(heatDataRatio);
        dataRatioInfoVo.setMigrationDataRatio(migrationRatio);
        return dataRatioInfoVo;
    }
}
