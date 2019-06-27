package com.huya.dc.datamanager.strategyflow;

import com.huya.dc.datamanager.strategyflow.cold.*;
import org.apache.commons.chain.impl.ChainBase;

/**
 * 数据冷迁移(仅支持按日期为一层分区的表)
 * 输入：表名，日期分区  是否删除已有COLD分区
 * 流程：
 * 1、检测输入
 *     a、表是否存在
 *     b、分区是否符合格式以及是否存在
 *     c、检查COLD集群中是否存在同样分区路径，存在则根据第三个参数判断是否删除，如果TRUE则删除，FALSE则抛出异常
 * 2、distcp 分区
 * 3、校验分区CRC
 *     a、生成新旧分区下所有文件路径列表，并将列表保存至HDFS
 *     b、调用计算CRC的MR程序，生成新老集群CRC数据文件保存至HDFS
 *     c、比较新老CRC值差异，并保存至HDFS
 * 4、获取CRC对比结果：
 *      存在差异：进行单个文件拷贝验证流程
 *      不存在：则继续下一步
 * 5、ALTER TABLE分区路径
 * 6、完成
 */
public class Data2ColdChain extends ChainBase {
    public static void main(String[] args) throws Exception {

        if(args == null || args.length != 5){
            throw new IllegalArgumentException("参数数量错误，应传入5个参数，分别是：数据库名，表名，日期分区，日期分区格式，是否删除存在的冷数据标志(true|false)");
        }
        Data2ColdChain chain = new Data2ColdChain();
        chain.addCommand(new CheckInputCommand());
        chain.addCommand(new DistcpCommand());
        chain.addCommand(new CalculateCRCCommand());
        chain.addCommand(new CheckCRCResultCommand());
        chain.addCommand(new AlterTableCommand());

        Data2ColdContext context = new Data2ColdContext();
        context.setDatabase(args[0]);
        context.setTable(args[1]);
        context.setDtPart(args[2]);
        context.setDtFormat(args[3]);
        context.setDelExistColdData(Boolean.parseBoolean(args[4]));
        chain.execute(context);
    }
}
