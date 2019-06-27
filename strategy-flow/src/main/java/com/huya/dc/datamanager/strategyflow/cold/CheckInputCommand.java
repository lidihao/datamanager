package com.huya.dc.datamanager.strategyflow.cold;

import com.huya.dc.datamanager.strategyflow.Data2ColdContext;
import com.huya.dc.datamanager.strategyflow.Exception.CheckInputException;
import com.huya.dc.datamanager.strategyflow.helper.HiveMetaHelper;
import com.huya.dc.datamanager.strategyflow.helper.PathHelper;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hive.hcatalog.api.HCatPartition;
import org.apache.hive.hcatalog.common.HCatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 检测输入
 *    a、表是否存在
 *    b、分区是否符合格式以及是否存在
 *    c、检查COLD集群中是否存在同样分区路径，存在则根据第三个参数判断是否删除，如果TRUE则删除，FALSE则抛出异常
 */
public class CheckInputCommand implements Command {
    private final static Logger logger = LoggerFactory.getLogger(CheckInputCommand.class);

    @Override
    public boolean execute(Context context) throws Exception {
        logger.info("Check input start. " + context.toString());
        Data2ColdContext data2ColdContext = (Data2ColdContext)context;
        try {
            checkDtPartFormat(data2ColdContext);
            checkTable(data2ColdContext);
            checkPartition(data2ColdContext);
        }catch (CheckInputException e){
            logger.error(e.getErrMsg(), e);
            return true;
        }

        return false;
    }

    private void checkPartition(Data2ColdContext data2ColdContext) throws IOException {
        String database = data2ColdContext.getDatabase();
        String table = data2ColdContext.getTable();
        String partition = data2ColdContext.getDtFormat();
        try {
            List<HCatPartition> parts = HiveMetaHelper.listPartitions(database, table, partition);
            if(parts == null || parts.isEmpty()){
                throw new CheckInputException("日期分区不存在[" + database + "." + table + "][" + partition + "]");
            }

            //TODO 需要支持更多的分区格式
            if(parts.size() > 1){
                throw new CheckInputException("当前分区类型不支持，目前仅支持dt=xxx的一层分区");
            }

            HCatPartition hcp = parts.get(0);

            String location = hcp.getLocation();

            data2ColdContext.setSourceLocation(location);
            String coldPath = PathHelper.convertToColdPath(location, true);

            data2ColdContext.setTargetLocation(coldPath);

            Path path = new Path(coldPath);
            FileSystem fs = path.getFileSystem(new Configuration());
            if(!fs.exists(path) || fs.isDirectory(path)){
                return;
            }

            if(!data2ColdContext.isDelExistColdData()){
                throw new CheckInputException("分区目录已经存在[" + coldPath + "]");
            }

            fs.delete(path, true);
        } catch (HCatException e) {
            throw new CheckInputException(e, "日期分区不存在[" + database + "." + table + "][" + partition + "]");
        }
    }

    private void checkDtPartFormat(Data2ColdContext data2ColdContext){
        String dtPart = data2ColdContext.getDtPart();
        String format = data2ColdContext.getDtFormat();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            sdf.parse(dtPart);
        } catch (ParseException e) {
            throw new CheckInputException(e, "日期分区格式错误[" + dtPart +"][" + format + "]");
        }
        logger.info("checkDtPartFormat successed.[" + dtPart + "]");
    }

    private void checkTable(Data2ColdContext data2ColdContext){
        String database = data2ColdContext.getDatabase();
        String table = data2ColdContext.getTable();
        try {
            HiveMetaHelper.checkTableExists(database, table);
        } catch (HCatException e) {
            throw new CheckInputException(e, "表不存在[" + data2ColdContext.getDatabase() + "." + data2ColdContext.getTable() +"]");
        }
    }
}
