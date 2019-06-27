package com.huya.dc.datamanager.strategyflow.cold;

import com.huya.dc.datamanager.strategyflow.Data2ColdContext;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistcpCommand implements Command {
    private final static Logger logger = LoggerFactory.getLogger(DistcpCommand.class);

    private final static String DISTCP_CMD = "/data/apps/hadoop/bin/hadoop distcp -skipcrccheck -m 400 %s %s";
    @Override
    public boolean execute(Context context) throws Exception {
        logger.info("Distcp start:" + context.toString());
        Data2ColdContext data2ColdContext = (Data2ColdContext)context;

        String cmd = String.format(DISTCP_CMD, data2ColdContext.getSourceLocation(), data2ColdContext.getTargetLocation());

        System.out.println(cmd);

        return false;
    }
}
