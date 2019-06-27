package com.huya.dc.datamanager.strategyflow.cold;

import com.huya.dc.datamanager.strategyflow.Data2ColdContext;
import com.huya.dc.datamanager.strategyflow.helper.PathHelper;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 计算CRC值（新旧集群分开计算，旧集群需进行远程调用）：
 * 1、生成文件列表，保存至HDFS临时目录
 * 2、执行hdfs_checksum脚本，输出文件列表对应的CRC值，并保存至OUTPUT文件
 */
public class CalculateCRCCommand implements Command {
    private final static Logger logger = LoggerFactory.getLogger(CalculateCRCCommand.class);

    private final static String CHECK_CRC_CMD = "/data/apps/colddata/hdfs_checksum.sh /data/apps/colddata/lib/file-tools-1.0-SNAPSHOT.jar %s %s";
    @Override
    public boolean execute(Context context) throws Exception {
        logger.info("Check CRC start");
        Data2ColdContext data2ColdContext = (Data2ColdContext)context;
        String input = PathHelper.getCheckSumInputPath(data2ColdContext.getDatabase(), data2ColdContext.getTable(), data2ColdContext.getDtPart());

        String output = PathHelper.getCheckSumOutputPath(data2ColdContext.getDatabase(), data2ColdContext.getTable(), data2ColdContext.getDtPart());

        System.out.println(String.format(CHECK_CRC_CMD, input, output));

        data2ColdContext.setChecksumOutputPath(output);
        return false;
    }
}
