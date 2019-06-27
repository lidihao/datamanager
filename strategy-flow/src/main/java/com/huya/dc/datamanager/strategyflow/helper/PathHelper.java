package com.huya.dc.datamanager.strategyflow.helper;

import org.apache.hadoop.fs.Path;

public class PathHelper {
    private final static String COLD_SCHEMA_FOR_HDFS = "hdfs://huyacoldcluster.local.hadoop.hy:8020";
    private final static String COLD_SCHEMA_FOR_WEBHDFS = "webhdfs://huyacoldcluster.local.hadoop.hy:50070";

    private final static String TMP_DIR = "/tmp";

    private final static String CHECKSUM_TMP_DIR = TMP_DIR + "/checksum";
    public static String convertToColdPath(String location, boolean isHdfs){
        Path path = new Path(location);
        String loc = path.toUri().getPath();
        if(isHdfs){
            return COLD_SCHEMA_FOR_HDFS + loc;
        }else{
            return COLD_SCHEMA_FOR_WEBHDFS + loc;
        }
    }

    public static String getCheckSumInputPath(String database, String table, String partition){
        return CHECKSUM_TMP_DIR + "/" + database + "/" + table + "/" + partition + "/input";
    }

    public static String getCheckSumOutputPath(String database, String table, String partition){
        return CHECKSUM_TMP_DIR + "/" + database + "/" + table + "/" + partition + "/out";
    }
}
